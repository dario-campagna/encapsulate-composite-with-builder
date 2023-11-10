package sdm.shop;

import org.junit.jupiter.api.Test;
import sdm.shop.order.Order;
import sdm.shop.order.Orders;
import sdm.shop.product.Color;
import sdm.shop.product.Currency;
import sdm.shop.product.Product;
import sdm.shop.product.ProductSize;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WriteOrdersToXML {

    @Test
    public void oneOrderWithTwoProducts() throws Exception {
        Order order = new Order("321");
        order.addProduct(new Product("f1234", "Fire truck", "8.95", Currency.USD, Color.RED, ProductSize.MEDIUM));
        order.addProduct(new Product("p1112", "Toy Porsche Convertible", "230.0", Currency.USD, Color.RED));
        Orders orders = new Orders();
        orders.addOrder(order);
        
        OrdersWriter ordersWriter = new OrdersWriter(orders);

        String expectedResult =
                "<orders>" + 
                    "<order id='321'>" +
                        "<product id='f1234' color='red' size='medium'>" +
                            "<price currency='USD'>" +
                                "8.95" +
                            "</price>" +
                            "Fire truck" +
                        "</product>" +
                        "<product id='p1112' color='red'>" +
                            "<price currency='USD'>" +
                                "230.0" +
                            "</price>" +
                            "Toy Porsche Convertible" +
                        "</product>" +
                    "</order>" +
                "</orders>";

        assertEquals(expectedResult, ordersWriter.getContents());
    }

}
