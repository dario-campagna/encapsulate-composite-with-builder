package sdm.shop;

import java.util.ArrayList;
import java.util.List;

public class TagNode {
    private final String name;
    private String value = "";
    private final StringBuilder attributes;
    private List<TagNode> children;

    public TagNode(String name) {
        this.name = name;
        attributes = new StringBuilder();
        children = new ArrayList<>();
    }

    public void addValue(String value) {
        this.value = value;
    }

    public void addAttribute(String attribute, String value) {
        attributes.append(" ");
        attributes.append(attribute);
        attributes.append("='");
        attributes.append(value);
        attributes.append("'");
    }

    public void add(TagNode node) {
        children.add(node);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("<").append(name).append(attributes);
        if (isEmptyTag()) {
            result.append("/>");
        } else {
            result.append(">");
            children.forEach(result::append);
            result.append(value);
            result.append("</").append(name).append(">");
        }
        return result.toString();
    }

    private boolean isEmptyTag() {
        return value.isEmpty() && children.isEmpty();
    }
}
