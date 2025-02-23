package nabil.prsnl.prjct.Controller.Model.Products;
import nabil.prsnl.prjct.Controller.Model.Product;
import nabil.prsnl.prjct.Controller.Model.Vendor;

public class ChristmasLights extends Product {
    public ChristmasLights(Vendor vendor, String description, double price) {
        super("ChristmasLights", vendor, description, price);
    }
}
