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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idUser")
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idAddress")
    private UserAddress userAddress;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idPayment")
    private Payment payment;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idDelivery")
    private Delivery delivery;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idStatusPayment")
    private StatusPayment statusPayment;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idStatusOrder")
    private StatusOrder statusDelivery;

    @Temporal(TemporalType.DATE)
    @Column(name = "Date")
    private Date date;

    @Column(name = "Cost")
    private int cost;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
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

    public StatusOrder getStatusDelivery() {
        return statusDelivery;
    }

    public void setStatusDelivery(StatusOrder statusDelivery) {
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
        if (!userAddress.equals(order.userAddress)) return false;
        if (!payment.equals(order.payment)) return false;
        if (!delivery.equals(order.delivery)) return false;
        if (!statusPayment.equals(order.statusPayment)) return false;
        if (!statusDelivery.equals(order.statusDelivery)) return false;
        return date.equals(order.date);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + role.hashCode();
        result = 31 * result + userAddress.hashCode();
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
                ", userAddress=" + userAddress +
                ", payment=" + payment +
                ", delivery=" + delivery +
                ", statusPayment=" + statusPayment +
                ", statusDelivery=" + statusDelivery +
                ", date=" + date +
                ", cost=" + cost +
                '}';
    }
}
