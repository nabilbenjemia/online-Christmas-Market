package src.Model.States;
import src.Model.Product;

public class ReservedState implements ProductState{
    @Override
    public void reserve(Product product) {
        //not possible
    }

    @Override
    public void sell(Product product) {
        product.setState(new SoldState());
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