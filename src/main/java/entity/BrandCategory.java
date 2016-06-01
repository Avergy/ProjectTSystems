package entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Siry on 30.05.2016.
 */

@Entity
@Table(name = "brandcategory")
public class BrandCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idBrand")
    private Brand Brand;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCategory")
    private CategoryProduct Category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Brand getBrand() {
        return Brand;
    }

    public void setBrand(Brand brand) {
        Brand = brand;
    }

    public CategoryProduct getCategory() {
        return Category;
    }

    public void setCategory(CategoryProduct category) {
        Category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BrandCategory that = (BrandCategory) o;

        if (id != that.id) return false;
        if (!Brand.equals(that.Brand)) return false;
        return Category.equals(that.Category);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Brand.hashCode();
        result = 31 * result + Category.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "BrandCategory{" +
                "id=" + id +
                ", Brand=" + Brand +
                ", Category=" + Category +
                '}';
    }
}
