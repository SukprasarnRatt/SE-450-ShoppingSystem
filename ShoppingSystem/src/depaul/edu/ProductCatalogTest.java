package depaul.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class ProductCatalogTest {

    private ProductCatalog catalog;
    private ProductFactory productFactory;

    @BeforeEach
    void setUp() {
        productFactory = new ProductFactory();
        catalog = new ProductCatalog(productFactory);
    }

    @Test
    void testAddAndGetAllProducts() {
        Product electronics = productFactory.createProduct("electronics", "1", "Smartphone", 999.99);
        Product clothing = productFactory.createProduct("clothing", "2", "Jeans", 59.99);
        

        List<Product> allProducts = catalog.getAllProducts();
        allProducts.add(electronics);
        allProducts.add(clothing);
        assertNotNull(allProducts);
        assertEquals(2, allProducts.size());


        assertTrue(allProducts.contains(electronics));
        assertTrue(allProducts.contains(clothing));
    }
}

