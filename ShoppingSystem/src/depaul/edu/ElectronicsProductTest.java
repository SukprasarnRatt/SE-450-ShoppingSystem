package depaul.edu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ElectronicsProductTest {

    @Test
    void testCreateProduct() {
        ElectronicsProduct product = new ElectronicsProduct("1", "Laptop", 1200.00);
        assertEquals("1", product.getId());
        assertEquals("Laptop", product.getName());
        assertEquals(1200.00, product.getPrice());
    }
}
