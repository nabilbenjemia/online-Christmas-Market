package src.Model;
import src.Model.States.AvailableState;
import src.Model.States.ProductState;

public abstract class Product {
    //A product has a type, a price, and a vendor
    private String type;
    private double price;
    private Vendor vendor;
    private boolean isReserved;
    private ProductState state;

    public Product(String type, double price, Vendor vendor) {
        this.type = type;
        this.price = price;
        this.vendor = vendor;
        this.isReserved = false;
        this.state = new AvailableState();
    }

    public void sell() {

    }

    public void updateStock() {

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    @Override
    public String toString() {
        return "Product{" +
                "type=" + type +
                ", price=" + price +
                '}';
    }

    public Vendor getVendor() {
        return vendor;
    }

    public String getType() {
        return type;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public void setState(ProductState state) {
        this.state = state;
    }

    public ProductState getState() {
        return state;
    }
}
