import java.util.List;

public class Visitor {

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

    public void addToCart(Product product) {
        cart.addItem(product);
    }

    public void purchase() {
        //todo
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + username + '\'' +
                '}';
    }

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
}
