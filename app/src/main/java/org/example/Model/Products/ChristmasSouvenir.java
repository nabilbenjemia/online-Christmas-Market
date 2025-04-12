package org.example.Model.Products;


import org.example.Model.Product;
import org.example.Model.Vendor;

public class ChristmasSouvenir extends Product {

    public ChristmasSouvenir(Vendor vendor, String description, double price) {
        super("ChristmasSouvenir", vendor, description, price);
    }

}
