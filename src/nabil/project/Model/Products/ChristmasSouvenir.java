package nabil.project.Model.Products;

import nabil.project.Model.Product;
import nabil.project.Model.Vendor;

public class ChristmasSouvenir extends Product {

    public ChristmasSouvenir(Vendor vendor, String description, double price) {
        super("ChristmasSouvenir", vendor, description, price);
    }

}
