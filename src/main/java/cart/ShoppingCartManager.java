package cart;

import entity.Phone;

public interface ShoppingCartManager {

    ShoppingCart getShoppingCart();

    void setShoppingCart(ShoppingCart shoppingCart);

    void removeOrderItem(Phone phone);

    void clearCart();

    int quantityPhonesInCart();
}
