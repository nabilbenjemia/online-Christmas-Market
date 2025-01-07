import java.util.List;

public class Visitor {

    //A visitor can log in, add/remove products to/from a cart
    //todo purchase
    private String username;
    private final String password;
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

    public void browseStalls() {
        //todo
    }

    //todo check if quantity is available
    //add quantity (how many products?)
    public void addToCart(Product product, int amount) {
        String type = product.getType();
        if (isLoggedIn) {
            Vendor vendor = product.getVendor();
            List<Product> availableProducts = vendor.getProductsMap().get(type);
            if (availableProducts == null) {
                return;
            }
            int reservedCount = 0;

            for (Product product_ : availableProducts) {
                if (!product_.isReserved()) {
                    product_.setReserved(true); // Mark as reserved
                    cart.addItem(product_);    // Add to the cart
                    reservedCount++;
                    if (reservedCount == amount) {
                        break;
                    }
                }
            }

            if (reservedCount < amount) {
                System.out.println("Not enough available products for type: " + type);
            }
        }
    }


    public void addToCart(Product product) {
        addToCart(product, 1);
    }

    public void removeFromCart(Product product) {cart.removeItem(product);}

    public void purchase() {
        //todo
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + username + '\'' +
                '}';
    }
/*
    public void register() {
        marketSystem.registerVisitor(this);
    }

    public String login() {
        List<Visitor> visitors = marketSystem.getVisitors();
        for (Visitor visitor: visitors) {
            if (visitor.getUsername().equals(username) && visitor.getPassword().equals(password)) {
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
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

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