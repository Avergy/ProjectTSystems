package dao.implementations;

import dao.interfaces.PhoneDao;
import entity.Brand;
import entity.Phone;

import javax.persistence.Query;
import java.util.List;


public class PhoneDaoImpl extends AbstractGenericDao implements PhoneDao{

    public PhoneDaoImpl() {
        super();
        setEntityClass(Phone.class);
    }

    @Override
    public List<Phone> findByBrand(Brand brand) {
        Query query = entityManager.createQuery("Select p FROM Phone p WHERE p.brand = :brand");
        query.setParameter("brand", brand);
        List<Phone> phones = query.getResultList();
        return phones;
    }
}