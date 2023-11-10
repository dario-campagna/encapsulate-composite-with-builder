package sdm.shop;

import sdm.shop.order.Order;
import sdm.shop.order.Orders;
import sdm.shop.product.Product;
import sdm.shop.product.ProductSize;

public class OrdersWriter {
    private final Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        StringBuilder xml = new StringBuilder();
        writeOrdersTo(xml);
        return xml.toString();
    }

    private void writeOrdersTo(StringBuilder xml) {
        TagNode ordersTag = new TagNode("orders");
        for (int i = 0; i < orders.getOrderCount(); i++) {
            Order order = orders.getOrder(i);
            TagNode orderTag = new TagNode("order");
            orderTag.addAttribute("id", order.getOrderId());
            writeProductsTo(orderTag, order);
            ordersTag.add(orderTag);
        }
        xml.append(ordersTag);
    }

    private static void writeProductsTo(TagNode orderTag, Order order) {
        for (int j = 0; j < order.getProductCount(); j++) {
            Product product = order.getProduct(j);
            TagNode productTag = new TagNode("product");
            productTag.addAttribute("id", product.getID());
            productTag.addAttribute("color", product.getColor().toString());
            if (product.getSize() != ProductSize.NOT_APPLICABLE) {
                productTag.addAttribute("size", product.getSize().toString());
            }
            writePriceTo(productTag, product);
            productTag.addValue(product.getName());
            orderTag.add(productTag);
        }
    }

    private static void writePriceTo(TagNode productTag, Product product) {
        TagNode priceNode = new TagNode("price");
        priceNode.addAttribute("currency", product.getCurrency().toString());
        priceNode.addValue(product.getPrice());
        productTag.add(priceNode);
    }

}
