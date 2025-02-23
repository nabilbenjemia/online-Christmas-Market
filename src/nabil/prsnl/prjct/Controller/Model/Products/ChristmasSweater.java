package nabil.prsnl.prjct.Controller.Model.Products;
import nabil.prsnl.prjct.Controller.Model.Product;
import nabil.prsnl.prjct.Controller.Model.Vendor;

public class ChristmasSweater extends Product {
    public ChristmasSweater(Vendor vendor, String description, double price) {
        super("ChristmasSweater", vendor, description, price);
    }
}
