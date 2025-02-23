package nabil.prsnl.prjct.Controller.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    //A ShoppingCart can add/remove items and return the total number of items
    private List<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public void removeItem(Product product) {
        items.remove(product);
    }

    public int numberOfItems() {
        return items.size();
    }

    public void checkout() {
        //todo
    }

    public void clear() {
        items.clear();
    }

    public List<Product> getItems() {
        return items;
    }

    public boolean purchase() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty. Cannot proceed with purchase.");
            return false;
        }

        String date = java.time.LocalDate.now().toString(); // Current date
        Sale sale = new Sale(date);
        Map<Vendor, Sale> vendorSales = new HashMap<>();

        for (Product product : items) {
            Vendor vendor = product.getVendor();
            vendorSales.putIfAbsent(vendor, new Sale(date));

            Sale vendorSale = vendorSales.get(vendor);
            vendorSale.addItem(product.getType(), 1, product.getPrice());

            // Mark product as sold
            product.setSold();
        }

        // Add the sale to each vendor's sales list
        for (Map.Entry<Vendor, Sale> entry : vendorSales.entrySet()) {
            Vendor vendor = entry.getKey();
            Sale vendorSale = entry.getValue();
            vendor.addSale(vendorSale);
        }

        // Clear the cart after purchase
        clear();

        System.out.println("Purchase completed successfully.");
        return true;
    }


}
