package legacyfigher.dietary.newproducts;

public class Availability {

    private final Integer counter;

    public Availability(Integer counter) {
        if (counter == null) {
            throw new IllegalStateException("null counter");
        }

        this.counter = counter;
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

}
