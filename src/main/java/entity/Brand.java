package entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Siry on 30.05.2016.
 */
@Entity
@Table(name = "brand")
public class Brand implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Brand")
    private String Brand;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Brand brand = (Brand) o;

        if (id != brand.id) return false;
        return Brand.equals(brand.Brand);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Brand.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", Brand='" + Brand + '\'' +
                '}';
    }
}
