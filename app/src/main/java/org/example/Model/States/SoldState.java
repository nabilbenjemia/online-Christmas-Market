package org.example.Model.States;

import org.example.Model.Product;

public class SoldState implements ProductState{
    @Override
    public void reserve(Product product) {
        //not possible
    }

    @Override
    public void sell(Product product) {
        //not possible
    }

    @Override
    public void cancel(Product product) {
        product.setState(new AvailableState());
    }

    @Override
    public boolean isAvailable(Product product) {
        return false;
    }
}
