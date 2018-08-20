package CodeGeneration;

/**
 * Represent a variable in the vsop language
 */
public class VariableDefinition {

    public String name;
    public String alias;
    public String type;
    public String aliasAlocated;

    public VariableDefinition(String name, String alias, String type, String aliasAlocated) {
        this.name = name;
        this.alias = alias;
        this.type = type;
        this.aliasAlocated = aliasAlocated;
    }
}
