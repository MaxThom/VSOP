package Semantic;

import java.util.HashMap;

/**
 * Represent a class in the vsop language
 */
public class ClassDefinition {
    public String name;
    public String extend;
    public boolean classInitialized;

    public HashMap<String, FieldDefinition> fields;
    public HashMap<String, MethodDefinition> methods;

    public ClassDefinition() {
        fields = new HashMap<>();
        methods = new HashMap<>();
        classInitialized = false;
    }

    public ClassDefinition(String name, String extend) {
        this.name = name;
        this.extend = extend;
        fields = new HashMap<>();
        methods = new HashMap<>();
    }
}
