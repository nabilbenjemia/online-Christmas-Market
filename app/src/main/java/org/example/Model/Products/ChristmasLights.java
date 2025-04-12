package org.example.Model.Products;


import org.example.Model.Product;
import org.example.Model.Vendor;

public class ChristmasLights extends Product {
    public ChristmasLights(Vendor vendor, String description, double price) {
        super("ChristmasLights", vendor, description, price);
    }
}
