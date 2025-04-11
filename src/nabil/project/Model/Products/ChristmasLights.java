package nabil.project.Model.Products;
import nabil.project.Model.Product;
import nabil.project.Model.Vendor;

public class ChristmasLights extends Product {
    public ChristmasLights(Vendor vendor, String description, double price) {
        super("ChristmasLights", vendor, description, price);
    }
}
