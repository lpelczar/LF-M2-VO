package legacyfigher.dietary.newproducts;

import java.util.Objects;

public class Availability {

    private final Integer counter;

    private Availability(Integer counter) {
        if (counter == null) {
            throw new IllegalStateException("null counter");
        }

        this.counter = counter;
    }

    static Availability of(Integer counter) {
        return new Availability(counter);
    }

    boolean isAvailable() {
        return counter > 0;
    }

    Integer asInt() {
        return counter;
    }

    Availability decrement() {
        Availability availability = new Availability(counter - 1);
        if (availability.asInt() < 0) {
            throw new IllegalStateException("Negative counter");
        }
        return availability;
    }

    Availability increment() {
        if (counter + 1 < 0) {
            throw new IllegalStateException("Negative counter");
        }
        return new Availability(counter + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Availability that = (Availability) o;
        return Objects.equals(counter, that.counter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(counter);
    }
}
