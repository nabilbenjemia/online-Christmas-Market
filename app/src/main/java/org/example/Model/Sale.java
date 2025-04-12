package org.example.Model;

import java.util.ArrayList;
import java.util.List;

public class Sale {
    private final List<SaleItem> items = new ArrayList<>();
    private final String date;

    public Sale(String date) {
        this.date = date;
    }

    public void addItem(String productType, int quantity, double totalPrice) {
        items.add(new SaleItem(productType, quantity, totalPrice));
    }

    @Override
    public String toString() {
        return "Sale{" +
                "items=" + items.size() +
                ", date='" + date + '\'' +
                ", Total Payed='" + getTotal() + '\'' +
                '}';
    }

    public List<SaleItem> getItems() {
        return items;
    }

    public String getDate() {
        return date;
    }

    public double getTotal() {
        return items.stream()
                .mapToDouble(SaleItem::getTotalPrice)
                .sum();
    }

    public static class SaleItem {
        private final String productType;
        private final int quantity;
        private final double totalPrice;

        public SaleItem(String productType, int quantity, double totalPrice) {
            this.productType = productType;
            this.quantity = quantity;
            this.totalPrice = totalPrice;
        }

        public String getProductType() {
            return productType;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getTotalPrice() {
            return totalPrice;
        }
    }


}


