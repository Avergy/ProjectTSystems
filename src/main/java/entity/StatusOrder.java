package entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Siry on 30.05.2016.
 */
@Entity
@Table(name = "statusorder")
public class StatusOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "statusorder")
    private String statusOrder;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatusOrder that = (StatusOrder) o;

        if (id != that.id) return false;
        return statusOrder.equals(that.statusOrder);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + statusOrder.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "StatusOrder{" +
                "id=" + id +
                ", statusOrder='" + statusOrder + '\'' +
                '}';
    }
}
