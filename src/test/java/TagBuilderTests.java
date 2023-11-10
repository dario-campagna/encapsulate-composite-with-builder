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
}
