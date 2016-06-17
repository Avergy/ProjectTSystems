package entity;


import enums.Delivery;
import enums.Payment;
import enums.StatusOrder;
import enums.StatusPayment;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idUser")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idAddress", nullable = false)
    private UserAddress userAddress;

    @Column(name = "Payment", nullable = false)
    @Enumerated(EnumType.STRING)
    private Payment payment;

    @Column(name = "Delivery", nullable = false)
    @Enumerated(EnumType.STRING)
    private Delivery delivery;

    @Column(name = "StatusPayment", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusPayment statusPayment;

   @Column(name = "StatusOrder", nullable = false)
   @Enumerated(EnumType.STRING)
    private StatusOrder statusDelivery;

    @Temporal(TemporalType.DATE)
    @Column(name = "Date", nullable = false)
    private Date date;

    @Column(name = "Cost", nullable = false)
    private long cost;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (cost != order.cost) return false;
        if (user != null ? !user.equals(order.user) : order.user != null) return false;
        if (userAddress != null ? !userAddress.equals(order.userAddress) : order.userAddress != null) return false;
        if (payment != order.payment) return false;
        if (delivery != order.delivery) return false;
        if (statusPayment != order.statusPayment) return false;
        if (statusDelivery != order.statusDelivery) return false;
        return date != null ? date.equals(order.date) : order.date == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (userAddress != null ? userAddress.hashCode() : 0);
        result = 31 * result + (payment != null ? payment.hashCode() : 0);
        result = 31 * result + (delivery != null ? delivery.hashCode() : 0);
        result = 31 * result + (statusPayment != null ? statusPayment.hashCode() : 0);
        result = 31 * result + (statusDelivery != null ? statusDelivery.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (int) (cost ^ (cost >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
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
