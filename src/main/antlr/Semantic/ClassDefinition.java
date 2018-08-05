package Semantic;

import java.util.HashMap;

public class ClassDefinition {
    public String name;
    public String extend;

    public HashMap<String, FieldDefinition> fields;
    public HashMap<String, MethodDefinition> methods;

    public ClassDefinition() {
        fields = new HashMap<>();
        methods = new HashMap<>();
    }

    public ClassDefinition(String name, String extend) {
        this.name = name;
        this.extend = extend;
        fields = new HashMap<>();
        methods = new HashMap<>();
    }
}
