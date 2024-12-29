public abstract class Product {

    private ProductType type;
    private double price;

    private Vendor vendor;

    public Product(ProductType type, double price, Vendor vendor) {
        this.type = type;
        this.price = price;
        this.vendor = vendor;
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
}
