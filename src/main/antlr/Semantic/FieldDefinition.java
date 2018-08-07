package Semantic;

import java.util.HashMap;

public class FieldDefinition<T> {
    public String name;
    public String type;
    public T value;

    public FieldDefinition(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public FieldDefinition(String name, String type, T value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

}
