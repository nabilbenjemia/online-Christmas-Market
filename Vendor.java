
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vendor {

    private Map<Product, Integer> productList;
    private String username;

    private final String password;

    //private ProductFactory productFactory;

    private boolean isLoggedIn;

    private MarketSystem marketSystem;



    public Vendor(String username, String password, MarketSystem marketSystem) {
        this.username = username;
        this.password = password;
        this.marketSystem = marketSystem;
        this.productList = new HashMap<>();
        //this.productFactory = new ProductFactory();
        this.isLoggedIn = false;
    }




    public void trackSales() {

    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /* 
    public void produceGoods(ProductType type, int amount) {
        for(int i=0; i<amount; i++) {
            Product product = productFactory.createChristmasProduct(type, this);
            productList.put(product, amount);
        }

    }
*/
    @Override
    public String toString() {
        return "Vendor{" +
                "name='" + username + '\'' +
                ", total products= " + productList.size() +'\'' +
                //"productList=" + productList +
        '}';
    }

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

    public String getPassword() {
        return password;
    }
}
