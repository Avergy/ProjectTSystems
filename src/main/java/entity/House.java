package entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Siry on 30.05.2016.
 */
@Entity
@Table(name = "house")
public class House implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "house")
    private String house;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        House house1 = (House) o;

        if (id != house1.id) return false;
        return house.equals(house1.house);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + house.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "HouseDao{" +
                "id=" + id +
                ", house='" + house + '\'' +
                '}';
    }
}
