package org.example.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.Model.States.AvailableState;
import org.example.Model.States.ProductState;


public abstract class Product {
    //A product has a type, a price, and a vendor
    private String type;
    private double price;
    @JsonIgnore
    private Vendor vendor;

    private String vendorId;

    private String description;

    @JsonIgnore
    private ProductState state;
    public Product(String type, Vendor vendor, String description, double price) {
        this.type = type;
        this.vendor = vendor;
        this.vendorId = vendor.getUsername();
        this.description = description;
        this.price = price;
        this.state = new AvailableState();
    }

    public ProductState getState() {
        return state;
    }

    public void setState(ProductState state) {
        this.state = state;
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
                ", description='" + description + "'" +
                ", price=" + price +
                '}';
    }

    public Vendor getVendor() {
        return vendor;
    }

    public String getType() {
        return type;
    }

    @JsonIgnore
    public boolean isReserved() {
        return state.isAvailable(this);
    }

    @JsonIgnore
    public boolean isAvailable() {
        return state.isAvailable(this);
    }

    public void setReserved() {
        state.reserve(this);
    }

    public void setSold() {
        state.sell(this);
    }

    public String getDescription() {
        return description;
    }
}

