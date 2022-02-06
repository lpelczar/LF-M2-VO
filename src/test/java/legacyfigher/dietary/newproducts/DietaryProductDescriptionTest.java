package legacyfigher.dietary.newproducts;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DietaryProductDescriptionTest {

    @Test
    void shouldFormatDescription() {
        // expect
        assertEquals(aProduct("Nicely crafted beans", "Coffee").formatDesc(), "Coffee *** Nicely crafted beans");
        assertEquals(aProduct("", "Coffee").formatDesc(), "");
        assertEquals(aProduct("Nicely crafted beans", "").formatDesc(), "");
        assertEquals(aProduct("Nicely crafted beans", null).formatDesc(), "");
        assertEquals(aProduct(null, "Coffee").formatDesc(), "");
        assertEquals(aProduct(null, null).formatDesc(), "");
        assertEquals(aProduct(null, "").formatDesc(), "");
        assertEquals(aProduct("", null).formatDesc(), "");
        assertEquals(aProduct("", "").formatDesc(), "");
    }

    @Test
    void shouldReplaceCharacterInDescription() {
        //given
        DietaryProduct product = aProduct("Nicely crafted Coffee", "Coffee");

        //when
        product.replaceCharFromDesc("Coffee", "Beans");

        //then
        assertEquals(product.formatDesc(), "Beans *** Nicely crafted Beans");
    }

    @Test
    void shouldFailReplacingCharacterInDescription() {
        //expect
        assertThrows(IllegalStateException.class,
                () -> aProduct("", "Coffee").replaceCharFromDesc("Coffee", "Beans"));
        assertThrows(IllegalStateException.class,
                () -> aProduct("Nicely crafted Coffee", "").replaceCharFromDesc("Coffee", "Beans"));
        assertThrows(IllegalStateException.class,
                () -> aProduct("", null).replaceCharFromDesc("Coffee", "Beans"));
        assertThrows(IllegalStateException.class,
                () -> aProduct(null, "").replaceCharFromDesc("Coffee", "Beans"));
        assertThrows(IllegalStateException.class,
                () -> aProduct(null, null).replaceCharFromDesc("Coffee", "Beans"));
        assertThrows(IllegalStateException.class,
                () -> aProduct("", "").replaceCharFromDesc("Coffee", "Beans"));
    }

    DietaryProduct aProduct(String longDesc, String desc) {
        return new DietaryProduct(new BigDecimal(1), desc, longDesc, 1);
    }

}