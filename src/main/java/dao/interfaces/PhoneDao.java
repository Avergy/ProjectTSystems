package dao.interfaces;

import entity.Brand;
import entity.Phone;

import java.util.List;


public interface PhoneDao extends GenericDao {

    List<Phone> findByBrand(Brand brand);
}
