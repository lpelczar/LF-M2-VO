package legacyfigher.dietary.newproducts;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;


public class DietaryProduct {

    private UUID serialNumber = UUID.randomUUID();

    private Price price;

    private Description description;

    private Availability availability;

    public DietaryProduct(BigDecimal price, String desc, String longDesc, Integer counter) {
        this.price = Price.of(price);
        this.description = Description.of(desc, longDesc);
        this.availability = Availability.of(counter);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DietaryProduct that = (DietaryProduct) o;
        return Objects.equals(serialNumber, that.serialNumber) && Objects.equals(price, that.price) && Objects.equals(description, that.description) && Objects.equals(availability, that.availability);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber, price, description, availability);
    }
}
