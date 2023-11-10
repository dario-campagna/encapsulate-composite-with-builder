package sdm.shop;

import sdm.shop.product.ProductSize;

public class TagBuilder {
    private TagNode rootNode;

    public TagBuilder(String rootTagName) {
        rootNode = new TagNode(rootTagName);
    }

    public String toXml() {
        return rootNode.toString();
    }
}
