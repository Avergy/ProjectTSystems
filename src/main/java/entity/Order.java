package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Siry on 30.05.2016.
 */
@Entity
@Table(name = "order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Client")
    private Position role;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Address")
    private ClientAddress clientAddress;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Payment")
    private Payment payment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_delivery")
    private Delivery delivery;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_StatusPayment")
    private StatusPayment statusPayment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_StatusOrder")
    private StatusDelivery statusDelivery;

    @Temporal(TemporalType.DATE)
    @Column(name = "Date")
    private Date date;

    @Column(name = "Cost")
    private int cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Position getRole() {
        return role;
    }

    public void setRole(Position role) {
        this.role = role;
    }

    public ClientAddress getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(ClientAddress clientAddress) {
        this.clientAddress = clientAddress;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public StatusPayment getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(StatusPayment statusPayment) {
        this.statusPayment = statusPayment;
    }

    public StatusDelivery getStatusDelivery() {
        return statusDelivery;
    }

    public void setStatusDelivery(StatusDelivery statusDelivery) {
        this.statusDelivery = statusDelivery;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (cost != order.cost) return false;
        if (!role.equals(order.role)) return false;
        if (!clientAddress.equals(order.clientAddress)) return false;
        if (!payment.equals(order.payment)) return false;
        if (!delivery.equals(order.delivery)) return false;
        if (!statusPayment.equals(order.statusPayment)) return false;
        if (!statusDelivery.equals(order.statusDelivery)) return false;
        return date.equals(order.date);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + role.hashCode();
        result = 31 * result + clientAddress.hashCode();
        result = 31 * result + payment.hashCode();
        result = 31 * result + delivery.hashCode();
        result = 31 * result + statusPayment.hashCode();
        result = 31 * result + statusDelivery.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + cost;
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", role=" + role +
                ", clientAddress=" + clientAddress +
                ", payment=" + payment +
                ", delivery=" + delivery +
                ", statusPayment=" + statusPayment +
                ", statusDelivery=" + statusDelivery +
                ", date=" + date +
                ", cost=" + cost +
                '}';
    }
}
