import Util.ServicesUtil;
import entity.Brand;
import entity.Color;
import entity.Phone;
import exceptions.DuplicateDBException;
import exceptions.NotFoundInDBException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Siry on 23.06.2016.
 */
public class StoreTest {



    @Ignore
    @Test(expected = DuplicateDBException.class)
    public void ExceptionDuplicateInDB() throws DuplicateDBException {
        Brand brand = new Brand();
        brand.setBrand("Test");
        ServicesUtil.getBrandService().addNewBrand(brand);
        ServicesUtil.getBrandService().addNewBrand(brand);
    }


    @After
    public void deleteBrand()
    {
        Brand brand = ServicesUtil.getBrandService().findByBrandName("Test");
        ServicesUtil.getBrandService().deleteBrand(brand);
    }
}
