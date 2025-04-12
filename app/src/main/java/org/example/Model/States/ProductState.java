package org.example.Model.States;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.example.Model.Product;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AvailableState.class, name = "available"),
        @JsonSubTypes.Type(value = ReservedState.class, name = "reserved"),
        @JsonSubTypes.Type(value = SoldState.class, name = "sold")
})

public interface ProductState {
    void reserve(Product product);
    void sell(Product product);
    void cancel(Product product);
    boolean isAvailable(Product product);
}
