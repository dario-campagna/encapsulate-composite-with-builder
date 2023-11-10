package sdm.shop;

import org.junit.jupiter.api.Test;
import sdm.shop.order.Order;
import sdm.shop.order.Orders;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddOrders {

    private final Orders orders = new Orders();

    @Test
    void addOneOrder() {
        Order order = new Order("a1c2");
        orders.addOrder(order);
        assertAll(
                () -> assertEquals(1, orders.getOrderCount()),
                () -> assertEquals(order, orders.getOrder(0))
        );
    }

    @Test
    void addTwoOrders() {
        Order order1 = new Order("x2y1");
        Order order2 = new Order("v01");
        orders.addOrder(order1);
        orders.addOrder(order2);
        assertAll(
                () -> assertEquals(2, orders.getOrderCount()),
                () -> assertEquals(order1, orders.getOrder(0)),
                () -> assertEquals(order2, orders.getOrder(1))
        );
    }
}
