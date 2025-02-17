package src.Model.Products;
import src.Model.Product;
import src.Model.Vendor;

public class ChristmasLights extends Product {
    public ChristmasLights(Vendor vendor) {
        super("ChristmasLights", 9.00, vendor);
    }
}
