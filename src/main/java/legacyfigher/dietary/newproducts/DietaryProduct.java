package legacyfigher.dietary.newproducts;

import java.math.BigDecimal;
import java.util.UUID;


public class DietaryProduct {

    private UUID serialNumber = UUID.randomUUID();

    private BigDecimal price;

    private Description description;

    private Integer counter;

    public DietaryProduct(BigDecimal price, Description description, Integer counter) {
        this.price = price;
        this.description = description;
        this.counter = counter;
    }

    void decrementCounter() {
        if (price != null && price.signum() > 0) {

            if
            (counter == null) {
                throw new IllegalStateException("null counter");
            }
            counter = counter - 1;
            if (counter < 0) {
                throw new IllegalStateException("Negative counter");
            }
        } else {
            throw new IllegalStateException("Invalid price");

        }

    }

    void incrementCounter() {
        if (price != null && price.signum() > 0) {
            if (counter == null) {
                throw new IllegalStateException("null counter");
            }
            if (counter +1 < 0) {
                throw new IllegalStateException("Negative counter");
            }
            counter = counter + 1;

        }
        else {
            throw new IllegalStateException("Invalid price");

        }
    }

    void changePriceTo(BigDecimal newPrice) {
        if (counter == null) {
            throw new IllegalStateException("null counter");
        }
        if
        (counter > 0) {
            if (newPrice == null) {
                throw new IllegalStateException("new price null");
            }
            this.price = newPrice;
        }
    }

    void replaceCharFromDesc(String charToReplace, String replaceWith) {
        this.description.replace(charToReplace, replaceWith);
    }

    String formatDesc() {
        return description.formatted();
    }


}
