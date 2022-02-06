package legacyfigher.dietary.newproducts;

import java.util.Objects;

public class Description {

    private String description;
    private String longDescription;

    public Description(String description, String longDescription) {
        this.description = description;
        this.longDescription = longDescription;
    }

    void replace(String oldValue, String newValue) {
        if (isInvalid()) {
            throw new IllegalStateException("null or empty desc");
        }
        longDescription = longDescription.replace(oldValue, newValue);
        description = description.replace(oldValue, newValue);
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
