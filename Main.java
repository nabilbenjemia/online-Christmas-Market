import src.Model.MarketSystem;
import src.Model.Vendor;
import src.Model.Visitor;
import src.Model.Products.ChristmasSweater;

public final class Main {

    private Main() {
    }

    /**
     * Main method.
     * Add code to demonstrate your implementation here.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {


        MarketSystem marketSystem = new MarketSystem();
        Vendor vendor = new Vendor("stand01", "1234", marketSystem);
        vendor.produceGoods("ChristmasSweater", 3);
        vendor.produceGoods("ChristmasLights", 2);
        Vendor vendor2 = new Vendor("stand02", "12345", marketSystem);
        vendor2.produceGoods("ChristmasSouvenir", 7);
        Visitor visitor = new Visitor("Alex", "ilovemunich", marketSystem);
        marketSystem.registerVendor(vendor);
        marketSystem.registerVendor(vendor2);
        marketSystem.registerVisitor(visitor);
        visitor.addToCart(new ChristmasSweater(vendor));
        System.out.println("Vendors: " + marketSystem.getVendors());
        System.out.println("Visitors: "+ marketSystem.getVisitors());
        System.out.println();
        Vendor v1 = new Vendor("stand01", "1234", marketSystem);


        System.out.println(visitor.getCartProducts());
        return;
    }

}

