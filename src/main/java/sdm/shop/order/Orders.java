package sdm.shop.order;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private final List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public int getOrderCount() {
        return orders.size();
    }

    public Order getOrder(int index) {
        return orders.get(index);
    }
}
