package dao.interfaces;

import entity.Brand;
import entity.Color;
import entity.Phone;

import javax.persistence.EntityManager;
import java.util.List;


public interface PhoneDao extends GenericDao {

    List<Phone> findByBrand(Brand brand);

    List<Phone> findByName(String phoneName);

    List<Phone> findByColor(Color color);

    boolean setPhoneQuantity(long id, int quantity, EntityManager entityManager);
}
