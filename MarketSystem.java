import java.util.LinkedList;
import java.util.List;

public class MarketSystem {

    private List<Vendor> vendors;
    private List<Visitor> visitors;
    //private StageEventManager stageManager;


    public MarketSystem() {
        this.vendors = new LinkedList<>();
        this.visitors = new LinkedList<>();
    }

    public void registerVendor(Vendor vendor) {
        vendors.add(vendor);
    }


    public void registerVisitor(Visitor visitor) {
        visitors.add(visitor);
    }


    public List<Vendor> getVendors() {
        return vendors;
    }

    public List<Visitor> getVisitors() {
        return visitors;
    }


}
