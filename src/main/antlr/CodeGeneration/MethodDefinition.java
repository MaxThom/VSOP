package CodeGeneration;

import java.util.HashMap;

/**
 * Represent a method in the vsop language
 */
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
