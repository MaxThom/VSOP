package Semantic;

public class FormalDefinition {
    public String name;
    public String type;
    public int position;

    public FormalDefinition(String name, String type, int position) {
        this.name = name;
        this.type = type;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
