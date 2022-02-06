package legacyfigher.dietary.newproducts;

import java.util.Objects;

public class Description {

    private final String description;
    private final String longDescription;

    private Description(String description, String longDescription) {
        this.description = description;
        this.longDescription = longDescription;
    }

    static Description of(String description, String longDescription) {
        return new Description(description, longDescription);
    }

    Description replace(String oldValue, String newValue) {
        if (isInvalid()) {
            throw new IllegalStateException("null or empty desc");
        }
        return new Description(description.replace(oldValue, newValue), longDescription.replace(oldValue, newValue));
    }

    String formatted() {
        if (isInvalid()) {
            return "";
        }
        return description + " *** " + longDescription;
    }

    private boolean isInvalid() {
        return longDescription == null || longDescription.isEmpty() || description == null || description.isEmpty();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Description that = (Description) o;
        return Objects.equals(description, that.description) && Objects.equals(longDescription, that.longDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, longDescription);
    }

}
