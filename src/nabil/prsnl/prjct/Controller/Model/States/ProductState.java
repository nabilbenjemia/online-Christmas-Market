package nabil.prsnl.prjct.Controller.Model.States;
import nabil.prsnl.prjct.Controller.Model.Product;

public interface ProductState {
    void reserve(Product product);
    void sell(Product product);
    void cancel(Product product);
    boolean isAvailable(Product product);
}
