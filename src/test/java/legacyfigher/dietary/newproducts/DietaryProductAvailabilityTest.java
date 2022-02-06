package legacyfigher.dietary.newproducts;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static legacyfigher.dietary.newproducts.Fixtures.aProductWithPriceAndCounter;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DietaryProductAvailabilityTest {

    @Test
    void shouldFailToIncrementCounter() {
        //expect
        assertThrows(IllegalStateException.class, () -> aProductWithPriceAndCounter(null, 1).incrementCounter());
        assertThrows(IllegalStateException.class, () -> aProductWithPriceAndCounter(new BigDecimal(0), 1).incrementCounter());
        assertThrows(IllegalStateException.class, () -> aProductWithPriceAndCounter(new BigDecimal(-1), 1).incrementCounter());
        assertThrows(IllegalStateException.class, () -> aProductWithPriceAndCounter(new BigDecimal(1), null).incrementCounter());
        assertThrows(IllegalStateException.class, () -> aProductWithPriceAndCounter(new BigDecimal(1), -2).incrementCounter());
    }

    @Test
    void shouldIncrementCounter() {
        //given
        DietaryProduct dietaryProduct = aProductWithPriceAndCounter(new BigDecimal(1), -1);

        //when
        dietaryProduct.incrementCounter();

        //then
        assertEquals(dietaryProduct.getCounter(), 0);
    }

    @Test
    void shouldFailToDecrementCounter() {
        //expect
        assertThrows(IllegalStateException.class, () -> aProductWithPriceAndCounter(null, 1).decrementCounter());
        assertThrows(IllegalStateException.class, () -> aProductWithPriceAndCounter(new BigDecimal(0), 1).decrementCounter());
        assertThrows(IllegalStateException.class, () -> aProductWithPriceAndCounter(new BigDecimal(-1), 1).decrementCounter());
        assertThrows(IllegalStateException.class, () -> aProductWithPriceAndCounter(new BigDecimal(1), null).decrementCounter());
        assertThrows(IllegalStateException.class, () -> aProductWithPriceAndCounter(new BigDecimal(1), 0).decrementCounter());
    }

    @Test
    void shouldDecrementCounter() {
        //given
        DietaryProduct dietaryProduct = aProductWithPriceAndCounter(new BigDecimal(1), 1);

        //when
        dietaryProduct.decrementCounter();

        //then
        assertEquals(dietaryProduct.getCounter(), 0);
    }

}