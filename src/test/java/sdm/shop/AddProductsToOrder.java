package sdm.shop;

import org.junit.jupiter.api.Test;
import sdm.shop.order.Order;
import sdm.shop.product.Color;
import sdm.shop.product.Currency;
import sdm.shop.product.Product;
import sdm.shop.product.ProductSize;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddProductsToOrder {

    private final Order order = new Order("orderID");

    @Test
    void addOneProduct() {
        Product product = new Product("id", "Car", "8.50", Currency.USD, Color.GREEN, ProductSize.SMALL);
        order.addProduct(product);
        assertAll(
                () -> assertEquals(1, order.getProductCount()),
                () -> assertEquals(product, order.getProduct(0))
        );
    }

    @Test
    void addTwoProducts() {
        Product product1 = new Product("1", "Train", "218.05", Currency.EUR, Color.RED, ProductSize.LARGE);
        Product product2 = new Product("2", "Ship", "28.60", Currency.USD, Color.GREEN, ProductSize.SMALL);
        order.addProduct(product1);
        order.addProduct(product2);
        assertAll(
                () -> assertEquals(2, order.getProductCount()),
                () -> assertEquals(product1, order.getProduct(0)),
                () -> assertEquals(product2, order.getProduct(1))
        );
    }
}
