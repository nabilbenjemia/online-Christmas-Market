package org.example.Model.Products;


import org.example.Model.Product;
import org.example.Model.Vendor;

public class ChristmasSweater extends Product {
    public ChristmasSweater(Vendor vendor, String description, double price) {
        super("ChristmasSweater", vendor, description, price);
    }
}
