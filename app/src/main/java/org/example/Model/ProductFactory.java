package org.example.Model;


import org.example.Model.Products.ChristmasLights;
import org.example.Model.Products.ChristmasSouvenir;
import org.example.Model.Products.ChristmasSweater;

public class ProductFactory {


    public Product createChristmasProduct(String type, Vendor vendor, String description, double price) {
        return switch (type) {
            case "ChristmasLights" -> new ChristmasLights(vendor, description, price);
            case "ChristmasSweater" -> new ChristmasSweater(vendor, description, price);
            case "ChristmasSouvenir" -> new ChristmasSouvenir(vendor, description, price);
            default -> null;
        };
    }
}
