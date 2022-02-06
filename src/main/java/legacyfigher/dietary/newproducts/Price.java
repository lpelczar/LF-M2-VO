package legacyfigher.dietary.newproducts;

import java.math.BigDecimal;

public class Price {

    private BigDecimal value;

    public Price(BigDecimal value) {
        if (value == null || value.signum() <= 0) {
            throw new IllegalStateException("Invalid price");
        }

        this.value = value;
    }

    Price changeTo(BigDecimal newPrice) {
        return new Price(newPrice);
    }

    BigDecimal asBigDecimal() {
        return value;
    }
}
