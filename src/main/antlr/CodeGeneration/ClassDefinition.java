package CodeGeneration;

import java.util.HashMap;

public class ClassDefinition {
    public String name;
    public String extend;
    public boolean classInitialized;
    public boolean isManuallyGenerated;

    public HashMap<String, FieldDefinition> fields;
    public HashMap<String, MethodDefinition> methods;

    public ClassDefinition() {
        fields = new HashMap<>();
        methods = new HashMap<>();
        classInitialized = false;
        isManuallyGenerated = false;
    }

    public ClassDefinition(String name, String extend) {
        this.name = name;
        this.extend = extend;
        fields = new HashMap<>();
        methods = new HashMap<>();
        isManuallyGenerated = false;
    }
}
