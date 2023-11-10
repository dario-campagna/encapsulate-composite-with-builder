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
        TagBuilder tagBuilder = new TagBuilder("orders");
        writeOrdersTo(tagBuilder);
        return tagBuilder.toXml();
    }

    private void writeOrdersTo(TagBuilder tagBuilder) {
        for (int i = 0; i < orders.getOrderCount(); i++) {
            Order order = orders.getOrder(i);
            tagBuilder.addToParent("orders", "order");
            tagBuilder.addAttribute("id", order.getOrderId());
            writeProductsTo(tagBuilder, order);
        }
    }

    private static void writeProductsTo(TagBuilder tagBuilder, Order order) {
        for (int j = 0; j < order.getProductCount(); j++) {
            Product product = order.getProduct(j);
            tagBuilder.addToParent("order", "product");
            tagBuilder.addAttribute("id", product.getID());
            tagBuilder.addAttribute("color", product.getColor().toString());
            if (product.getSize() != ProductSize.NOT_APPLICABLE) {
                tagBuilder.addAttribute("size", product.getSize().toString());
            }
            tagBuilder.addValue(product.getName());
            writePriceTo(tagBuilder, product);
        }
    }

    private static void writePriceTo(TagBuilder tagBuilder, Product product) {
        tagBuilder.addChild("price");
        tagBuilder.addAttribute("currency", product.getCurrency().toString());
        tagBuilder.addValue(product.getPrice());
    }

}
