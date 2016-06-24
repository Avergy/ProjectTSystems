package servlets;

import Util.ServicesUtil;
import entity.Phone;
import entity.User;
import exceptions.DuplicateDBException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class PhoneControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userPath = req.getServletPath();


        String url = "/admin/" + userPath +".jsp";

        HttpSession session = req.getSession();

        if (userPath.equals("/editPhone"))
        {
            String idString = req.getQueryString();
            if (idString != null)
            {
                long id = Long.parseLong(idString);
                Phone phone = ServicesUtil.getPhoneService().loadPhone(id);
                req.setAttribute("currentPhone", phone);
            }
        }

        req.getRequestDispatcher(url).forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String type = null;
        String url = null;
        String error = "/error/later.jsp";
        HttpSession session = req.getSession();

        FileItemFactory fileItemFactory = new DiskFileItemFactory();
        ServletFileUpload fileUpload =  new ServletFileUpload(fileItemFactory);
        List<FileItem> fileItems = null;
        try{
            fileItems = fileUpload.parseRequest(req);
        }catch (FileUploadException e)
        {
            e.printStackTrace();
        }

        for (FileItem item: fileItems)
        {
            if (item.isFormField())
            {
                String name = item.getFieldName();
                String value = item.getString();
                if (name.equals("type"))
                    type = value;
            }

        }

        if (type != null)
        {
            switch (type) {
                case "add": {
                    Phone phone = fillPhoneField(fileItems);
                    url = "/admin/newPhone.jsp";
                    try {
                        ServicesUtil.getPhoneService().addNewPhone(phone);
                    } catch (DuplicateDBException e) {
                        e.printStackTrace();
                        url = error;
                    }
                    break;
                }
                case "edit": {
                    Phone upPhone = fillPhoneField(fileItems);
                    Phone phone = ServicesUtil.getPhoneService().findPhoneById(upPhone.getId());
                    upPhone.setImageURL(phone.getImageURL());


                    url = "/admin/editPhone.jsp?" + upPhone.getId();
                    try {
                        ServicesUtil.getPhoneService().updatePhone(upPhone);
                        req.setAttribute("currentPhone", upPhone);
                    } catch (DuplicateDBException e) {
                        e.printStackTrace();
                        url = error;
                    }
                    break;
                }
                default:
                    break;
            }


        }

        req.getRequestDispatcher(url).forward(req,resp);
    }

    private Phone fillPhoneField(List<FileItem> fileItems)
    {
        Phone phone = new Phone();

        for (FileItem item : fileItems) {
            if (item.isFormField()) {
                String name = item.getFieldName();
                String value = item.getString();
                switch (name) {
                    case "phone_name":
                        if (value.length() == 0) throw new IllegalArgumentException();
                        phone.setName(value);
                        break;
                    case "phone_brand":
                        phone.setBrand(ServicesUtil.getBrandService().findByBrandName(value));
                        break;
                    case "phone_color":
                        phone.setColor(ServicesUtil.getColorService().findColorByName(value));
                        break;
                    case "phone_weight":
                        phone.setWeight(Integer.parseInt(value));
                        break;
                    case "phone_quantity_stock":
                        phone.setQuantityStock(Integer.parseInt(value));
                        break;
                    case "phone_price":
                        phone.setPrice((long) (Double.parseDouble(value)*100));
                        break;
                    case "phone_id":
                        long id = Long.parseLong(value);
                        phone.setId(id);
                        break;
                    default:
                        break;
                }
            } else {
                if (item.get().length != 0)
                    phone.setImage(item.get());
            }
        }
        return phone;
    }
}
