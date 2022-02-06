package legacyfigher.dietary.newproducts;

import java.math.BigDecimal;
import java.util.Objects;

public class Price {

    private final BigDecimal value;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Objects.equals(value, price.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
