package days.day4;

public class PropertyValidation{
    public String name;
    public Validation validationMethod;

    public PropertyValidation(String name, Validation validation) {
        this.name = name;
        this.validationMethod = validation;
    }
}
