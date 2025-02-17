package src.Model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Vendor {

    //A vendor can log in, add products
    //todo viewInventory
    //todo set reserved

    //changing from Map<Product, Integer> to ap<ProductType, ProductStock>
    private Map<String, List<Product>> productsMap;
    private String username;

    private final String password;

    private ProductFactory productFactory;

    private boolean isLoggedIn;

    private MarketSystem marketSystem;



    public Vendor(String username, String password, MarketSystem marketSystem) {
        this.username = username;
        this.password = password;
        this.marketSystem = marketSystem;
        this.productsMap = new HashMap<>();
        this.productFactory = new ProductFactory();
        this.isLoggedIn = false;
    }



    //todo statistics
    public void trackSales() {

    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //todo adding the same type
    public void produceGoods(String type, int amount) {
        List<Product> productList = new LinkedList<>();
        for (int i = 0; i < amount; i++) {
            Product product = productFactory.createChristmasProduct(type, this);
            productList.add(product);
        }
            productsMap.put(type, productList);

    }

    @Override
    public String toString() {
        return "Vendor{" +
                "name='" + username + '\'' +
                ", types= " + productsMap.size() +'\'' +
                //"productList=" + productList +
        '}';
    }

    /*
    public void register() {
        marketSystem.registerVendor(this);
    }

    public String login() {
        List<Vendor> vendors = marketSystem.getVendors();
        for (Vendor vendor: vendors) {
            if (vendor.getUsername().equals(username) && vendor.getPassword().equals(password)) {
                isLoggedIn = true;
                break;
            }
        }
        return isLoggedIn? username + " is logged in succesfully": "NOT logged in successfully";
    }

    public void logout() {
        isLoggedIn = false;
    }
*/
    public String getPassword() {
        return password;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    //todo maybe move it to ShoppingCart
    public boolean CheckAvailability(String type, int amount) {
        int availableAmount = 0;
        if (productsMap.containsKey(type)) {
            for (Product product: productsMap.get(type)) {
                if (!product.isReserved()) {
                    availableAmount++;
                }
                if (availableAmount >= amount) {
                    return true;
                }
            }
            return availableAmount >= amount;
        }
        return false;
    }

    public Map<String, List<Product>> getProductsMap() {
        return productsMap;
    }
}