package nabil.project.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Visitor {

    //A visitor can log in, add/remove products to/from a cart
    //todo purchase
    private String username;
    @JsonIgnore
    private final String password;
    @JsonIgnore
    private ShoppingCart cart;

    private boolean isLoggedIn;

    private MarketSystem marketSystem;

    public Visitor(String username, String password, MarketSystem marketSystem) {
        this.username = username;
        this.password = password;
        this.marketSystem = marketSystem;
        this.cart = new ShoppingCart();
        this.isLoggedIn = false;
    }



    private boolean checkAvailability(String product, String vendorID, int amount) {
        Vendor vendor = marketSystem.getVendor(vendorID);
        List<Product> availableProducts = vendor.getProductsMap().get(product);

        if (availableProducts == null) {
            return false; // No products found
        }

        int availableCount = 0;

        // Count available products that are not reserved or sold
        for (Product product_ : availableProducts) {
            if (product_.isAvailable()) {
                availableCount++;
            }
        }

        return availableCount >= amount; // Return true if enough products are available
    }

    public boolean addToCart(String product, String vendorID, int amount) {
        //todo
        //if (isLoggedIn) {
        // Check if there are enough products available
        if (!checkAvailability(product, vendorID, amount)) {
            return false; // Not enough products, return false
        }

        Vendor vendor = marketSystem.getVendor(vendorID);
        List<Product> availableProducts = vendor.getProductsMap().get(product);
        if (availableProducts == null) {
            return false; // No products found
        }

        int reservedCount = 0;

        // Add products to the cart
        for (Product product_ : availableProducts) {
            if (product_.isAvailable()) {
                product_.setReserved(); // Mark product as reserved
                cart.addItem(product_);      // Add product to cart
                reservedCount++;

                if (reservedCount == amount) {
                    break; // Stop once the requested amount is added
                }
            }
        }

        // Check if we successfully added the requested amount
        return reservedCount == amount;
        //}
        //return false; // If not logged in, return false
    }


    public boolean addToCart(Product product, int amount) {
        String type = product.getType();
        String vendorID = product.getVendor().getUsername();
        return addToCart(type, vendorID, amount);
    }


    public boolean addToCart(Product product) {
        return addToCart(product,1);
    }

    public void removeFromCart(Product product) {cart.removeItem(product);}

    public boolean purchase() {
        return cart.purchase();
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + username + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @JsonIgnore
    public String getCartProducts() {
        if(isLoggedIn) {
            String s = "Cart = {";
            if (cart.getItems() == null) {
                return "Cart is empty";
            }
            for (Product product : cart.getItems()) {
                s += product + "\n";
            }
            return s + "}";
        }
        return "Visitor should login";
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public ShoppingCart getCart() {
        return cart;
    }
}
