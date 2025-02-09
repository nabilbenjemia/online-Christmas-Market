public interface ProductState {
    void reserve(Product product);
    void sell(Product product);
    void cancel(Product product);
    boolean isAvailable(Product product);
}
