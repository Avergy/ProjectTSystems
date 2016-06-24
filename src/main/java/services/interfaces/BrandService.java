package services.interfaces;

import entity.Brand;
import exceptions.DuplicateDBException;

import java.util.List;

public interface BrandService {

    void addNewBrand(Brand brand) throws DuplicateDBException;

    Brand findByBrandName(String brandName);

    List<Brand> loadAllBrands();

    void updateBrand(Brand brand);

    void deleteBrand(Brand brand);


}
