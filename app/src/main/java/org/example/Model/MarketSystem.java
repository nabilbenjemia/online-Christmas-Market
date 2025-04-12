package org.example.Model;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


@Service
public class MarketSystem {

    private List<Vendor> vendors;
    private List<Visitor> visitors;
    //private StageEventManager stageManager;

    private Authenticator authenticator;

    public MarketSystem() {
        this.vendors = new LinkedList<>();
        this.visitors = new LinkedList<>();
        this.authenticator = new Authenticator();
    }

    public boolean registerVendor(Vendor vendor) {
        if (authenticator.registerVendor(vendor.getUsername(), vendor.getPassword())) {
            vendors.add(vendor);
            return true;
        }
        return false;
    }

    public boolean registerVendor(String username, String password, String description) {
        if (authenticator.registerVendor(username, password)) {
            vendors.add(new Vendor(username, password, description, this));
            return true;
        }
        return false;
    }


    public boolean registerVisitor(Visitor visitor) {
        if (authenticator.registerVisitor(visitor.getUsername(), visitor.getPassword())) {
            visitors.add(visitor);
            return true;
        }
        return false;
    }

    public boolean registerVisitor(String username, String password) {
        if (authenticator.registerVisitor(username, password)) {
            visitors.add(new Visitor(username, password, this));
            return true;
        }
        return false;
    }

    public boolean loginVendor(String username, String password) {
        Vendor vendor = getVendor(username);
        if (authenticator.loginVendor(username, password) && vendor != null) {
            vendor.setLoggedIn(true);
            return true;
        }
        return false;
    }

    public boolean loginVisitor(String username, String password) {
        Visitor visitor = getVisitor(username);
        if (authenticator.loginVisitor(username, password) && visitor != null) {
            visitor.setLoggedIn(true);
            return true;
        }
        return false;
    }

    public void logoutVendor(String username) {
        Vendor vendor = getVendor(username);
        if (vendor != null) {
            vendor.setLoggedIn(false);
        }
    }

    public void logoutVisitor(String username) {
        Visitor visitor = getVisitor(username);
        if (visitor != null) {
            visitor.setLoggedIn(false);
        }
    }
    public List<Vendor> getVendors() {
        return vendors;
    }

    public List<Visitor> getVisitors() {
        return visitors;
    }

    public Visitor getVisitor(String username) {
        for (Visitor visitor: visitors) {
            if (visitor.getUsername().equals(username)) {
                return visitor;
            }
        }
        return null;
    }

    public Vendor getVendor(String username) {
        for (Vendor vendor: vendors) {
            if (vendor.getUsername().equals(username)) {
                return vendor;
            }
        }
        return null;
    }

    public Authenticator getAuthenticator() {
        return authenticator;
    }
}

