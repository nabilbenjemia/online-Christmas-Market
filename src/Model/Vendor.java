package Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;
import src.Model.Product;
import src.Model.ProductFactory;
import src.Model.MarketSystem;

public class Vendor {

    //A vendor can log in, add products
    //todo viewInventory
    //changing from Map<Product, Integer> to ap<ProductType, ProductStock>
    @JsonIgnore
    private Map<String, List<Product>> productsMap;
    private String username;

    @JsonIgnore
    private final String password;

    private String description;

    private ProductFactory productFactory;

    private boolean isLoggedIn;

    private List<Sale> sales;

    public Vendor(String username, String password, String description, MarketSystem marketSystem) {
        this.username = username;
        this.password = password;
        this.description = description;
        this.sales = new ArrayList<>();
        this.productsMap = new HashMap<>();
        this.productFactory = new ProductFactory();
        this.isLoggedIn = false;
    }

    public void addSale(Sale sale) {
        sales.add(sale);
    }

    //todo statistics

    public String getSales() {
        String s = "";
        for (Sale sale : sales) {
            s += sale +"\n";
        }
        s += "Total Revenues= " + calculateTotalRevenue() + "€";
        return s;
    }

    public double calculateTotalRevenue() {
        double totalRevenue = 0;
        for (Sale sale : sales) {
            totalRevenue += sale.getTotal();
        }
        return totalRevenue;
    }

    public String printProducts() {
        for (int i = 0; i < productsMap.size(); i++) {

            List<Product> productList ;
        }
        return "";
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //todo adding the same type
    public boolean produceGoods(String type, String description, double price, int amount) {
        List<Product> productList = productsMap.getOrDefault(type, new LinkedList<>());
        for (int i = 0; i < amount; i++) {
            Product product = productFactory.createChristmasProduct(type, this, description, price);
            if (product == null) {
                return false;
            }
            productList.add(product);

        }
        productsMap.put(type, productList);
        return true;
    }

    public String getPassword() {
        return password;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public Map<String, List<Product>> getProductsMap() {
        return productsMap;
    }

    public String getDescription() {
        return description;
    }

    //todo PROBLEM HERE

    //@JsonIgnore
    public List<Product> getProducts() {
        List<Product> allProducts = new ArrayList<>();
        for (List<Product> productList : productsMap.values()) {
            allProducts.addAll(productList); // Add each product list to the result
        }
        return allProducts;
    }

    public Map<Product, Integer> getProductsByType() {
        Map<Product, Integer> productTypeCounts = new HashMap<>();
        for (Map.Entry<String, List<Product>> entry : productsMap.entrySet()) {
            productTypeCounts.put(entry.getValue().get(0), entry.getValue().size());
        }
        return productTypeCounts;
    }

    public Map<Product, Integer> getAvailableProductsByType() {
        Map<Product, Integer> productTypeCounts = new HashMap<>();
        for (Map.Entry<String, List<Product>> entry : productsMap.entrySet()) {
            // Filter only available products
            long availableCount = entry.getValue().stream()
                    .filter(Product::isAvailable) // Filter out unavailable products
                    .count();

            // Only add to the map if there are available products
            if (availableCount > 0) {
                productTypeCounts.put(entry.getValue().get(0), (int) availableCount); // Assumes the first product in the list represents the product type
            }
        }
        return productTypeCounts;
    }


}
