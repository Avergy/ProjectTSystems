package entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Siry on 30.05.2016.
 */
@Entity
@Table(name = "apartment")
public class Apartment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "apartment")
    private String Apartment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApartment() {
        return Apartment;
    }

    public void setApartment(String apartment) {
        Apartment = apartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Apartment apartment = (Apartment) o;

        if (id != apartment.id) return false;
        return Apartment.equals(apartment.Apartment);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Apartment.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", Apartment='" + Apartment + '\'' +
                '}';
    }
}
