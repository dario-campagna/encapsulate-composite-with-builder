import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import sdm.shop.TagBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TagBuilderTests {

    @Test
    void buildOneNode() {
        String expectedXml = "<flavors/>";
        String actualXml = new TagBuilder("flavors").toXml();
        assertEquals(expectedXml, actualXml);
    }

    @Test
    void buildOneChild() {
        String expectedXml =
                "<flavors>" +
                    "<flavor/>" +
                "</flavors>";
        TagBuilder builder = new TagBuilder("flavors");
        builder.addChild("flavor");
        assertEquals(expectedXml, builder.toXml());
    }

    @Test
    void buildChildrenOfChildren() {
        String expectedXml =
                "<flavors>" +
                    "<flavor>" +
                        "<requirements>" +
                            "<requirement/>" +
                        "</requirements>" +
                    "</flavor>" +
                "</flavors>";
        TagBuilder builder = new TagBuilder("flavors");
        builder.addChild("flavor");
        builder.addChild("requirements");
        builder.addChild("requirement");
        assertEquals(expectedXml, builder.toXml());
    }

    @Test
    void buildSibling() {
        String expectedXml =
                "<flavors>" +
                    "<flavor1/>" +
                    "<flavor2/>" +
                "</flavors>";
        TagBuilder builder = new TagBuilder("flavors");
        builder.addChild("flavor1");
        builder.addSibling("flavor2");
        assertEquals(expectedXml, builder.toXml());
    }

    @Test
    void buildChildrenOfSibling() {
        String expectedXml =
                "<flavors>" +
                        "<flavor1/>" +
                        "<flavor2>" +
                            "<requirements/>" +
                        "</flavor2>" +
                "</flavors>";
        TagBuilder builder = new TagBuilder("flavors");
        builder.addChild("flavor1");
        builder.addSibling("flavor2");
        builder.addChild("requirements");
        assertEquals(expectedXml, builder.toXml());
    }
}
