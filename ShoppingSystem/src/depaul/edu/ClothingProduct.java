package depaul.edu;

public class ClothingProduct extends Product{
    public ClothingProduct(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void displayProductInfo() {
        System.out.println(this.toString());
    }
    
}
