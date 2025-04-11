package nabil.project.Model.Products;
import nabil.project.Model.Product;
import nabil.project.Model.Vendor;

public class ChristmasSweater extends Product {
    public ChristmasSweater(Vendor vendor, String description, double price) {
        super("ChristmasSweater", vendor, description, price);
    }
}
