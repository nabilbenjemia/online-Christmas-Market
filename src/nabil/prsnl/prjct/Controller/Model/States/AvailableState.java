package nabil.prsnl.prjct.Controller.Model.States;
import nabil.prsnl.prjct.Controller.Model.Product;

public class AvailableState implements ProductState{
    @Override
    public void reserve(Product product) {
        product.setState(new ReservedState());
    }

    @Override
    public void sell(Product product) {
        //can't sell a non reserved product
    }

    @Override
    public void cancel(Product product) {
        //nothing changes
    }

    @Override
    public boolean isAvailable(Product product) {
        return true;
    }
}