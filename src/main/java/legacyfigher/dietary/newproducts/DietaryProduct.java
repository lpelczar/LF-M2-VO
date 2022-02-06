package legacyfigher.dietary.newproducts;

import java.math.BigDecimal;
import java.util.UUID;


public class DietaryProduct {

    private UUID serialNumber = UUID.randomUUID();

    private Price price;

    private Description description;

    private Integer counter;

    public DietaryProduct(BigDecimal price, Description description, Integer counter) {
        this.price = new Price(price);
        this.description = description;
        this.counter = counter;
    }

    void decrementCounter() {
        if
        (counter == null) {
            throw new IllegalStateException("null counter");
        }
        counter = counter - 1;
        if (counter < 0) {
            throw new IllegalStateException("Negative counter");
        }
    }

    void incrementCounter() {
        if (counter == null) {
            throw new IllegalStateException("null counter");
        }
        if (counter + 1 < 0) {
            throw new IllegalStateException("Negative counter");
        }
        counter = counter + 1;
    }

    void changePriceTo(BigDecimal newPrice) {
        if (counter == null) {
            throw new IllegalStateException("null counter");
        }
        if
        (counter > 0) {
            this.price = price.changeTo(newPrice);
        }
    }

    BigDecimal getPrice() {
        return price.asBigDecimal();
    }

    Integer getCounter() {
        return counter;
    }

    void replaceCharFromDesc(String charToReplace, String replaceWith) {
        this.description = description.replace(charToReplace, replaceWith);
    }

    String formatDesc() {
        return description.formatted();
    }


}
