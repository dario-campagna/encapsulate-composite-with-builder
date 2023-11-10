package sdm.shop.order;

import sdm.shop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final String id;
    private final List<Product> products;

    public Order(String id) {
        this.id = id;
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public int getProductCount() {
        return products.size();
    }

    public Product getProduct(int index) {
        return products.get(index);
    }

    public String getOrderId() {
        return id;
    }
}
