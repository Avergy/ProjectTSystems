package cart;

import entity.OrderItem;
import entity.Phone;
import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.List;

public class ShoppingCartManagerImpl implements ShoppingCartManager {

    private ShoppingCart cart;

    final static Logger logger = Logger.getLogger(ShoppingCart.class.getName());

    public ShoppingCartManagerImpl() {
    }


    public ShoppingCart getShoppingCart() {
        return cart;
    }

    public void setShoppingCart(ShoppingCart cart) {
        this.cart = cart;
    }


    @Override
    public void removeOrderItem(Phone phone) {
        logger.info("Remove orderitem from cart...");
        List<OrderItem> orderItems = cart.getOrderItems();
        Iterator<OrderItem> iter = orderItems.iterator();
        while (iter.hasNext()) {
            OrderItem item = iter.next();
            if (item.getPhone().equals(phone)) {
                iter.remove();
            }
        }
        logger.info("Orderitem has been removed from cart.");
    }

    @Override
    public void clearCart() {
        logger.info("Clear cart...");
        List<OrderItem> orderItems = cart.getOrderItems();
        orderItems.clear();
        cart.setOrderItems(orderItems);
        logger.info("Cart has been cleared.");
    }

    @Override
    public int quantityPhonesInCart() {
        List<OrderItem> orderItems = cart.getOrderItems();
        int quantity = 0;
        for (OrderItem item: orderItems)
        {
           quantity += item.getQuantity();
        }
        return quantity;
    }
}
