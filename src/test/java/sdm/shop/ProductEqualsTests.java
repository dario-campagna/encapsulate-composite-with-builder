package sdm.shop;

import org.junit.jupiter.api.Test;
import sdm.shop.product.Color;
import sdm.shop.product.Currency;
import sdm.shop.product.Product;
import sdm.shop.product.ProductSize;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ProductEqualsTests {

    @Test
    void sameProduct() {
        Product product = new Product("productID", "Product Name", "2.20", Currency.EUR, Color.GREEN, ProductSize.LARGE);
        Product anotherProduct = new Product("productID", "Product Name", "2.20", Currency.EUR, Color.GREEN, ProductSize.LARGE);
        assertEquals(anotherProduct, product);
    }

    @Test
    void differentProducts() {
        Product product = new Product("bb8", "Droid", "99.99", Currency.USD, Color.RED, ProductSize.SMALL);
        Product anotherProduct = new Product("a12b", "Thing", "3.14", Currency.USD, Color.RED);
        assertNotEquals(anotherProduct, product);
    }
}
