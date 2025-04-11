package nabil.project.Controller;



import nabil.project.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/market")
@CrossOrigin(origins = "http://localhost:63342")
public class MarketController {

    private final MarketSystem marketSystem;

    @Autowired
    public MarketController(MarketSystem marketSystem) {
        this.marketSystem = marketSystem;
    }

    @PostMapping("/vendor/register")
    public ResponseEntity<String> registerVendor(@RequestParam String username, @RequestParam String password, @RequestParam String description) {
        if (marketSystem.registerVendor(username, password, description)) {
            return ResponseEntity.ok("Vendor registered successfully!");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(username + " could not be registered as a Vendor!");
    }

    @PostMapping("/visitor/register")
    public ResponseEntity<String> registerVisitor(@RequestParam String username, @RequestParam String password) {
        if (marketSystem.registerVisitor(username, password)) {
            return ResponseEntity.ok("Visitor registered successfully");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(username + " could not be registered as a Visitor!");
    }

    @PostMapping("/vendor/login")
    public ResponseEntity<String> loginVendor(@RequestParam String username, @RequestParam String password) {
        boolean success = marketSystem.loginVendor(username, password);
        if (success) {
            return ResponseEntity.ok("Vendor logged in successfully");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }

    @PostMapping("/visitor/login")
    public ResponseEntity<String> loginVisitor(@RequestParam String username, @RequestParam String password) {
        boolean success = marketSystem.loginVisitor(username, password);
        if (success) {
            return ResponseEntity.ok("Visitor logged in successfully");
        }
        return ResponseEntity.badRequest().body("Invalid username or password");
    }

    @PostMapping("/vendor/logout")
    public void logoutVendor(@RequestParam String username) {
        marketSystem.logoutVendor(username);
    }

    // Logout Visitor
    @PostMapping("/visitor/logout")
    public void logoutVisitor(@RequestParam String username) {
        marketSystem.logoutVisitor(username);
    }

    @GetMapping("/vendor/all")
    public ResponseEntity<List<Vendor>> getVendors() {
        return ResponseEntity.ok().body(marketSystem.getVendors());
    }

    // Get all Visitors
    @GetMapping("/visitor/all")
    public ResponseEntity<List<Visitor>> getVisitors() {
        return ResponseEntity.ok().body(marketSystem.getVisitors());
    }

    @GetMapping("/vendor/{vendorId}/products")
    public ResponseEntity<Map<Product, Integer>> getVendor(@PathVariable String vendorId) {
        Vendor vendor = marketSystem.getVendor(vendorId);

        if (vendor == null) {
            // Return a 404 not found response if the vendor does not exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        //return ResponseEntity.ok(vendor.getProductsByType());
        return ResponseEntity.ok(vendor.getAvailableProductsByType());
    }

    @GetMapping("/vendor/{vendorId}/sales")
    public ResponseEntity<String> getSales(@PathVariable String vendorId) {
        Vendor vendor = marketSystem.getVendor(vendorId);
        return ResponseEntity.ok(vendor.getSales());

    }

    @GetMapping("/visitor/{visitorId}/cart")
    public ResponseEntity<ShoppingCart> getCart(@PathVariable String visitorId) {
        Visitor visitor = marketSystem.getVisitor(visitorId);
        if(visitor != null) {
            ShoppingCart cart = visitor.getCart();

            if (cart != null) {
                return ResponseEntity.ok(cart);
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PostMapping("/vendor/{vendorId}/products")
    public ResponseEntity<String> addProducts(
            @PathVariable String vendorId,
            @RequestParam String type,
            @RequestParam String description,
            @RequestParam double price,
            @RequestParam int amount)
    {

        Vendor vendor = marketSystem.getVendor(vendorId);
        //todo fix
        if (vendor == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vendor not found");
        }
        boolean goodsProduced = vendor.produceGoods(type, description, price, amount);
        if (!goodsProduced) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could not add Products. Please check the types of goods");
        }
        return ResponseEntity.ok(amount + " Goods added successfully");
    }

    @PostMapping("/cart/{visitorId}/{vendorId}")
    public ResponseEntity<String> addToCart(@PathVariable String visitorId, @PathVariable String vendorId, @RequestParam String type, @RequestParam int amount) {
        Visitor visitor = marketSystem.getVisitor(visitorId);
        if (visitor != null) {
            if (visitor.addToCart(type, vendorId, amount)) {
                return ResponseEntity.ok("Products added to Cart successfully");
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add to cart - Probably the amount you asked for is not available");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add to cart");
    }

    @PostMapping("/visitor/{visitorId}/purchase")
    public ResponseEntity<String> purchase(@PathVariable String visitorId) {
        Visitor visitor = marketSystem.getVisitor(visitorId);
        if(visitor!= null && visitor.purchase()) {
            return ResponseEntity.ok("Product(s) purchased successfully!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No purchase is possible. Please check your cart");
    }


    //todo update description
    //todo submit button
    //todo logout user when quitting
}
