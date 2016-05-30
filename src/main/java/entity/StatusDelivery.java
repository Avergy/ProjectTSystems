import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Siry on 30.05.2016.
 */
@Entity
@Table(name = "statusorder")
public class StatusDelivery implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "statusorder")
    private String statusDeliv;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatusDeliv() {
        return statusDeliv;
    }

    public void setStatusDeliv(String statusDeliv) {
        this.statusDeliv = statusDeliv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatusDelivery that = (StatusDelivery) o;

        if (id != that.id) return false;
        return statusDeliv.equals(that.statusDeliv);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + statusDeliv.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "StatusDelivery{" +
                "id=" + id +
                ", statusDeliv='" + statusDeliv + '\'' +
                '}';
    }
}
