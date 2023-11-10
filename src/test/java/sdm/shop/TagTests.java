package sdm.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TagTests {

    @Test
    void simpleEmptyTag() {
        assertEquals("<price/>", new TagNode("price").toString());
    }

    @Test
    void simpleTagWithValue() {
        TagNode priceTag = new TagNode("price");
        priceTag.addValue("1.99");
        assertEquals("<price>1.99</price>", priceTag.toString());
    }

    @Test
    void simpleTagWithAttributesAndValue() {
        TagNode priceTag = new TagNode("price");
        priceTag.addAttribute("currency", "USD");
        priceTag.addValue("8.95");

        String expected =
                "<price currency='USD'>" +
                    "8.95" +
                "</price>";

        assertEquals(expected, priceTag.toString());
    }

    @Test
    void compositeTagWithOneChild() {
        TagNode productTag = new TagNode("product");
        productTag.add(new TagNode("price"));

        String expected =
                "<product>" +
                    "<price/>" +
                "</product>";

        assertEquals(expected, productTag.toString());
    }

    @Test
    void compositeTagWithTwoChildren() {
        TagNode orderTag = new TagNode("order");
        orderTag.add(new TagNode("product"));
        orderTag.add(new TagNode("product"));

        String expected =
                "<order>" +
                    "<product/>" +
                    "<product/>" +
                "</order>";

        assertEquals(expected, orderTag.toString());
    }

    @Test
    void compositeTagWithChildrenAndGrandChildren() {
        TagNode ordersTag = new TagNode("orders");
        TagNode orderTag = new TagNode("order");
        TagNode productTag = new TagNode("product");
        ordersTag.add(orderTag);
        orderTag.add(productTag);

        String expected =
                "<orders>" +
                    "<order>" +
                        "<product/>" +
                    "</order>" +
                "</orders>";

        assertEquals(expected, ordersTag.toString());
    }
}
