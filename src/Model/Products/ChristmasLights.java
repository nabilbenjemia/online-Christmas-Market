package Model.Products;
import src.Model.Product;
import src.Model.Vendor;

public class ChristmasLights extends Product {
    public ChristmasLights(Vendor vendor, String description, double price) {
        super("ChristmasLights", vendor, description, price);
    }
}
