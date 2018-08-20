package Semantic;

/**
 * Represent a field in the vsop language
 */
public class FieldDefinition {
    public String name;
    public String type;

    public FieldDefinition(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
