package nabil.project.Model;

import java.util.HashMap;
import java.util.Map;

public class Authenticator {
    Map<String, String> vendorCredentials = new HashMap<>();
    Map<String, String> visitorCredentials = new HashMap<>();


    public boolean registerVendor(String username, String password) {
        if (!vendorCredentials.containsKey(username)) {
            vendorCredentials.put(username, password);
            return true;
        }
        return false;
    }

    public boolean registerVisitor(String username, String password) {
        if (!visitorCredentials.containsKey(username)) {
            visitorCredentials.put(username, password);
            return true;
        }
        return false;
    }

    public boolean loginVendor(String username, String password) {
        if (vendorCredentials.containsKey(username)) {
            return vendorCredentials.get(username).equals(password);
        }
        return false;
    }

    public boolean loginVisitor(String username, String password) {
        if (visitorCredentials.containsKey(username)) {
            return visitorCredentials.get(username).equals(password);
        }
        return false;
    }

    public void logoutVendor(String username) {
        vendorCredentials.remove(username);
    }

    public void logoutVisitor(String username) {
        visitorCredentials.remove(username);
    }

    public Map<String, String> getVendorCredentials() {
        return vendorCredentials;
    }

    public Map<String, String> getVisitorCredentials() {
        return visitorCredentials;
    }
}

