package legacyfigher.dietary.newproducts;

import java.math.BigDecimal;

public class Fixtures {

    static DietaryProduct aProductWithDescription(String longDesc, String desc) {
        return new DietaryProduct(new BigDecimal(1), desc, longDesc, 1);
    }

    static DietaryProduct aProductWithPriceAndCounter(BigDecimal price, Integer counter) {
        return new DietaryProduct(price, "Coffee", "Nicely crafted beans", counter);
    }

}
