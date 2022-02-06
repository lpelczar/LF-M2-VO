package legacyfigher.dietary.newproducts;

import java.math.BigDecimal;
import java.util.UUID;


public class DietaryProduct {

    private UUID serialNumber = UUID.randomUUID();

    private Price price;

    private Description description;

    private Availability availability;

    public DietaryProduct(BigDecimal price, Description description, Integer counter) {
        this.price = new Price(price);
        this.description = description;
        this.availability = new Availability(counter);
    }

    void decrementCounter() {
        this.availability = availability.decrement();
    }

    void incrementCounter() {
        this.availability = availability.increment();
    }

    void changePriceTo(BigDecimal newPrice) {
        if (availability.isAvailable()) {
            this.price = price.changeTo(newPrice);
        }
    }

    BigDecimal getPrice() {
        return price.asBigDecimal();
    }

    Integer getCounter() {
        return availability.asInt();
    }

    void replaceCharFromDesc(String charToReplace, String replaceWith) {
        this.description = description.replace(charToReplace, replaceWith);
    }

    String formatDesc() {
        return description.formatted();
    }


}
