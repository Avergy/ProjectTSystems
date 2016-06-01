package entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Siry on 30.05.2016.
 */
@Entity
@Table(name = "role")
public class Position implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "role")
    private String position;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position role = (Position) o;

        if (id != role.id) return false;
        return position.equals(role.position);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + position.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PositionService{" +
                "id=" + id +
                ", position='" + position + '\'' +
                '}';
    }
}
