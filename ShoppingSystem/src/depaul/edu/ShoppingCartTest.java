package depaul.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    private ShoppingCart cart;
    private Product product;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
        product = new ElectronicsProduct("1", "TestProduct", 99.99);
    }

    @Test
    void testAddItem() {
        cart.addItem(product, 1);
        assertEquals(1, cart.getItems().size());
        assertTrue(cart.getItems().containsKey(product));
    }

    @Test
    void testRemoveItem() {
        cart.addItem(product, 1);
        cart.removeItem(product);
        assertEquals(0, cart.getItems().size());
    }

    @Test
    void testGetTotalAmount() {
        cart.addItem(product, 2);
        assertEquals(199.98, cart.getTotalAmount());
    }

    @Test
    void testUpdateItemQuantity() {
        cart.addItem(product, 1);
        cart.updateItemQuantity(product, 3);
        assertEquals(3, cart.getItems().get(product));
    }

    @Test
    void testRemoveItemWithZeroQuantity() {
        cart.addItem(product, 1);
        cart.updateItemQuantity(product, 0);
        assertEquals(0, cart.getItems().size());
    }
}

