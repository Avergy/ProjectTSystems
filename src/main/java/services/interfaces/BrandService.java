package services.interfaces;

import entity.Brand;

import java.util.List;

public interface BrandService {

    void addNewBrand(Brand brand);

    Brand findByBrandName(String brandName);

    List<Brand> loadAllBrands();
}
