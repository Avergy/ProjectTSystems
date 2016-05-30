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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "StatusPayment")
    private String statusPay;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatusPay() {
        return statusPay;
    }

    public void setStatusPay(String statusPay) {
        this.statusPay = statusPay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatusPayment that = (StatusPayment) o;

        if (id != that.id) return false;
        return statusPay.equals(that.statusPay);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + statusPay.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "StatusPayment{" +
                "id=" + id +
                ", statusPay='" + statusPay + '\'' +
                '}';
    }
}
