package CodeGeneration;

import java.util.HashMap;

public class MethodDefinition {
    public String name;
    public String type;

    public HashMap<String, FormalDefinition> formals;

    public MethodDefinition(String name, String type) {
        this.name = name;
        this.type = type;
        formals = new HashMap<>();
    }
}
