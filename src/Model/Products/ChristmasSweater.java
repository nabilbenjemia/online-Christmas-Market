package src.Model.Products;
import src.Model.Product;
import src.Model.Vendor;

public class ChristmasSweater extends Product{
    public ChristmasSweater(Vendor vendor) {
        super("ChristmasSweater", 15.00, vendor);
    }
}
