package depaul.edu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    private List<Product> products;
    private ProductFactory productFactory;

    public ProductCatalog(ProductFactory productFactory) {
        this.products = new ArrayList<>();
        this.productFactory = productFactory;
    }

    public void loadProductsFromCsv(String csvFilePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] productData = line.split(",");
                Product product = productFactory.createProduct(
                        productData[2].trim(), // category
                        productData[0].trim(), // id
                        productData[1].trim(), // name
                        Double.parseDouble(productData[3].trim()) // price
                );
                products.add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public List<Product> getAllProducts() {
        return new ArrayList<>(products); // Return a copy to prevent outside modifications
    }
}
