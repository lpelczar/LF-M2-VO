package legacyfigher.dietary.newproducts;

import org.junit.jupiter.api.Test;

import static legacyfigher.dietary.newproducts.Fixtures.aProductWithDescription;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DietaryProductDescriptionTest {

    @Test
    void shouldFormatDescription() {
        // expect
        assertEquals(aProductWithDescription("Nicely crafted beans", "Coffee").formatDesc(), "Coffee *** Nicely crafted beans");
        assertEquals(aProductWithDescription("", "Coffee").formatDesc(), "");
        assertEquals(aProductWithDescription("Nicely crafted beans", "").formatDesc(), "");
        assertEquals(aProductWithDescription("Nicely crafted beans", null).formatDesc(), "");
        assertEquals(aProductWithDescription(null, "Coffee").formatDesc(), "");
        assertEquals(aProductWithDescription(null, null).formatDesc(), "");
        assertEquals(aProductWithDescription(null, "").formatDesc(), "");
        assertEquals(aProductWithDescription("", null).formatDesc(), "");
        assertEquals(aProductWithDescription("", "").formatDesc(), "");
    }

    @Test
    void shouldReplaceCharacterInDescription() {
        //given
        DietaryProduct product = aProductWithDescription("Nicely crafted Coffee", "Coffee");

        //when
        product.replaceCharFromDesc("Coffee", "Beans");

        //then
        assertEquals(product.formatDesc(), "Beans *** Nicely crafted Beans");
    }

    @Test
    void shouldFailReplacingCharacterInDescription() {
        //expect
        assertThrows(IllegalStateException.class,
                () -> aProductWithDescription("", "Coffee").replaceCharFromDesc("Coffee", "Beans"));
        assertThrows(IllegalStateException.class,
                () -> aProductWithDescription("Nicely crafted Coffee", "").replaceCharFromDesc("Coffee", "Beans"));
        assertThrows(IllegalStateException.class,
                () -> aProductWithDescription("", null).replaceCharFromDesc("Coffee", "Beans"));
        assertThrows(IllegalStateException.class,
                () -> aProductWithDescription(null, "").replaceCharFromDesc("Coffee", "Beans"));
        assertThrows(IllegalStateException.class,
                () -> aProductWithDescription(null, null).replaceCharFromDesc("Coffee", "Beans"));
        assertThrows(IllegalStateException.class,
                () -> aProductWithDescription("", "").replaceCharFromDesc("Coffee", "Beans"));
    }

}