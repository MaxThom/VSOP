package CodeGeneration;

public class FieldDefinition {
    public String name;
    public String type;
    public int position;
    public boolean isInitialized;

    public FieldDefinition(String name, String type, int position) {
        this.name = name;
        this.type = type;
        this.position = position;
        this.isInitialized = false;
    }
}
