

package depaul.edu;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> items;

    public ShoppingCart() {
        items = new HashMap<>();
    }

    public void addItem(Product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public void removeItem(Product product) {
        items.remove(product);
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public double getTotalAmount() {
        return items.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

 
    public void updateItemQuantity(Product product, int quantity) {
        if (items.containsKey(product)) {
            if (quantity > 0) {
                items.put(product, quantity);
            } else {
                items.remove(product);
            }
            System.out.println("Updated the quantity of the product.");
        } else {
            System.out.println("There is no such product in the shopping cart.");
        }
    }
    

    
}


