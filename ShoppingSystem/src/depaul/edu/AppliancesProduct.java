package depaul.edu;

public class AppliancesProduct extends Product{
    public AppliancesProduct(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void displayProductInfo() {
        System.out.println(this.toString());
    }
    
}
