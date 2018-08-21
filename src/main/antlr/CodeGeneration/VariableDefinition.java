package CodeGeneration;

/**
 * Represent a variable in the vsop language
 */
public class VariableDefinition {

    public String name;
    public String alias;
    public String type;
    public String aliasAlocated;
    public String blockName;

    public VariableDefinition(String name, String alias, String type, String aliasAlocated) {
        this.name = name;
        this.alias = alias;
        this.type = type;
        this.aliasAlocated = aliasAlocated;
        this.blockName = "";
    }

    public VariableDefinition(String name, String alias, String type, String aliasAlocated, String blockName) {
        this.name = name;
        this.alias = alias;
        this.type = type;
        this.aliasAlocated = aliasAlocated;
        this.blockName = blockName;
    }
}
