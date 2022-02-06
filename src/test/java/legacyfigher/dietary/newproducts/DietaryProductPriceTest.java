package legacyfigher.dietary.newproducts;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static legacyfigher.dietary.newproducts.Fixtures.aProductWithPriceAndCounter;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DietaryProductPriceTest {

    @Test
    void shouldChangePrice() {
        // given
        DietaryProduct dietaryProduct = aProductWithPriceAndCounter(new BigDecimal(1), 1);

        // when
        dietaryProduct.changePriceTo(new BigDecimal(8));

        // then
        assertEquals(dietaryProduct.getPrice(), new BigDecimal(8));
    }

    @Test
    void shouldNotChangePrice() {
        // given
        DietaryProduct dietaryProduct = aProductWithPriceAndCounter(new BigDecimal(1), 0);

        // when
        dietaryProduct.changePriceTo(new BigDecimal(8));

        // then
        assertEquals(dietaryProduct.getPrice(), new BigDecimal(1));
    }

    @Test
    void shouldFailWhenInvalidCounter() {
        // expect
        assertThrows(IllegalStateException.class,
                () -> aProductWithPriceAndCounter(new BigDecimal(1), null).changePriceTo(new BigDecimal(8)));
    }

    @Test
    void shouldFailWhenInvalidNewPrice() {
        // expect
        assertThrows(IllegalStateException.class,
                () -> aProductWithPriceAndCounter(new BigDecimal(1), 1).changePriceTo(null));
    }

}