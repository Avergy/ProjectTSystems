package entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Siry on 30.05.2016.
 */
@Entity
@Table(name = "sity")
public class Sity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "sityName")
    private String sity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSity() {
        return sity;
    }

    public void setSity(String sity) {
        this.sity = sity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sity sity1 = (Sity) o;

        if (id != sity1.id) return false;
        return sity.equals(sity1.sity);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + sity.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Sity{" +
                "id=" + id +
                ", sity='" + sity + '\'' +
                '}';
    }
}
