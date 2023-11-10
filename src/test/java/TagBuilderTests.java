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
}
