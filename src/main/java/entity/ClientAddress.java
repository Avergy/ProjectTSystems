package entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Siry on 30.05.2016.
 */
@Entity
@Table(name = "clientaddress")
public class ClientAddress implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Client")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_PostalCode")
    private PostalCode postalCode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Street")
    private Street street;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_House")
    private House house;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Apartment")
    private Apartment apartment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PostalCode getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(PostalCode postalCode) {
        this.postalCode = postalCode;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientAddress that = (ClientAddress) o;

        if (id != that.id) return false;
        if (!user.equals(that.user)) return false;
        if (!postalCode.equals(that.postalCode)) return false;
        if (!street.equals(that.street)) return false;
        if (!house.equals(that.house)) return false;
        return apartment.equals(that.apartment);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + user.hashCode();
        result = 31 * result + postalCode.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + house.hashCode();
        result = 31 * result + apartment.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ClientAddress{" +
                "id=" + id +
                ", role=" + user +
                ", postalCode=" + postalCode +
                ", street=" + street +
                ", house=" + house +
                ", apartment=" + apartment +
                '}';
    }
}
