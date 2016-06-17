package cart;

import entity.OrderItem;
import entity.Phone;
import entity.User;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private User user;
    private List<OrderItem> orderItems;

    public ShoppingCart() {
        orderItems = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "user=" + user +
                ", orderItems=" + orderItems +
                '}';
    }
}
