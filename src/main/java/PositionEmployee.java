import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Siry on 30.05.2016.
 */
@Entity
@Table(name = "positionemployee")
public class PositionEmployee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "position")
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

        PositionEmployee position1 = (PositionEmployee) o;

        if (id != position1.id) return false;
        return position.equals(position1.position);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + position.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", position='" + position + '\'' +
                '}';
    }
}
