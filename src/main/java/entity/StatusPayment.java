package entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Siry on 30.05.2016.
 */
@Entity
@Table(name = "statuspayment")
public class StatusPayment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "StatusPayment")
    private String statusPayment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(String statusPayment) {
        this.statusPayment = statusPayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatusPayment that = (StatusPayment) o;

        if (id != that.id) return false;
        return statusPayment.equals(that.statusPayment);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + statusPayment.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "StatusPayment{" +
                "id=" + id +
                ", statusPayment='" + statusPayment + '\'' +
                '}';
    }
}
