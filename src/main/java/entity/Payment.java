
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Siry on 30.05.2016.
 */
@Entity
@Table(name = "payment")
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "payment")
    private String payment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment1 = (Payment) o;

        if (id != payment1.id) return false;
        return payment.equals(payment1.payment);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + payment.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", payment='" + payment + '\'' +
                '}';
    }
}
