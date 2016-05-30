package entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Siry on 30.05.2016.
 */
@Entity
@Table(name = "street")
public class Street implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "street")
    private String street;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Street street1 = (Street) o;

        if (id != street1.id) return false;
        return street.equals(street1.street);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + street.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Street{" +
                "id=" + id +
                ", street='" + street + '\'' +
                '}';
    }
}
