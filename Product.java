public abstract class Product {
    //A product has a type, a price, and a vendor
    private ProductType type;
    private double price;
    private Vendor vendor;
    private boolean isReserved;
    public Product(ProductType type, double price, Vendor vendor) {
        this.type = type;
        this.price = price;
        this.vendor = vendor;
        this.isReserved = false;
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

    public ProductType getType() {
        return type;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }
}
