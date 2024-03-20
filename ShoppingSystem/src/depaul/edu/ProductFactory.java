package depaul.edu;

public class ProductFactory {
    public Product createProduct(String category, String id, String name, double price) {
        switch (category.toLowerCase()) {
            case "electronics":
                return new ElectronicsProduct(id, name, price);
            case "clothing":
                return new ClothingProduct(id, name, price);
            case "appliances":
                return new AppliancesProduct(id, name, price);
            default:
                throw new IllegalArgumentException("Unknown category " + category);
        }
    }
}

