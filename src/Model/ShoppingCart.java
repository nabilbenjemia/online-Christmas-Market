package src.Model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public void removeItem(Product product) {
        items.remove(product);
    }

    public int numberOfItems() {
        return items.size();
    }

    public void checkout() {
        //todo
    }

    public List<Product> getItems() {
        return items;
    }
}
