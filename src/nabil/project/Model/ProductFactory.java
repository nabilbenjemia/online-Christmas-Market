package nabil.project.Model;

import nabil.project.Model.Products.ChristmasLights;
import nabil.project.Model.Products.ChristmasSouvenir;
import nabil.project.Model.Products.ChristmasSweater;

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
