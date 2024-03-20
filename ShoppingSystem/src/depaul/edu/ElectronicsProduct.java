package depaul.edu;

public class ElectronicsProduct extends Product {

    public ElectronicsProduct(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void displayProductInfo() {
        System.out.println(this.toString());
    }
}
