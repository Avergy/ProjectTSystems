package entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Siry on 30.05.2016.
 */
@Entity
@Table(name = "postalcode")
public class PostalCode implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "postalcode")
    private int postalcode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Country")
    private Country country;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Sity")
    private City city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(int postalcode) {
        this.postalcode = postalcode;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostalCode that = (PostalCode) o;

        if (id != that.id) return false;
        if (postalcode != that.postalcode) return false;
        if (!country.equals(that.country)) return false;
        return city.equals(that.city);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + postalcode;
        result = 31 * result + country.hashCode();
        result = 31 * result + city.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PostalCode{" +
                "id=" + id +
                ", postalcode=" + postalcode +
                ", country=" + country +
                ", city=" + city +
                '}';
    }
}
