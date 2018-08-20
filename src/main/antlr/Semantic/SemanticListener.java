package Semantic;


import VSOP.Semantic.SEMANTICBaseListener;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;
import java.util.stream.Collectors;

import static VSOP.Semantic.SEMANTICParser.*;

public class SemanticListener extends SEMANTICBaseListener {

    private Map<String, ClassDefinition> classes;
    private ClassDefinition currentClass;
    private String fileName;

    public StringBuilder treeOutput;
    public ArrayList<String> errorOutput;

    public SemanticListener(String fileName) {
        classes = new HashMap<>();
        errorOutput = new ArrayList<>();
        currentClass = null;
        this.fileName = fileName;
        treeOutput = new StringBuilder();
    }

    public void addLibrary(ClassDefinition newClass) {
        classes.put(newClass.name, newClass);
    }

    @Override
    public void exitProgram(ProgramContext ctx) {
        checkForMainClass(ctx);
        checkForInheritance(ctx);

        checkTypeCompileTime(ctx);

        //System.out.println(treeOutput.toString());
        //this.treeOutput = handleProgram(ctx);
    }

    @Override
    public void exitClassDefinition(ClassDefinitionContext ctx) {
        ClassDefinition classDef = new ClassDefinition();
        classDef.name = ctx.TYPE_IDENTIFIER(0).getText();
        classDef.extend = ctx.TYPE_IDENTIFIER(1) != null ? ctx.TYPE_IDENTIFIER(1).getText() : "Object";


        List<MethodDefinitionContext> methods = ctx.children.stream().filter(x -> x instanceof  MethodDefinitionContext).map(x -> (MethodDefinitionContext) x).collect(Collectors.toList());
        List<FieldContext> fields = ctx.children.stream().filter(x -> x instanceof  FieldContext).map(x -> (FieldContext) x).collect(Collectors.toList());

        for (MethodDefinitionContext method: methods) {
            MethodDefinition methodDef = new MethodDefinition(method.OBJECT_IDENTIFIER().getText(), method.varType().getText());

            int formalPos = 0;
            for (FormalContext formal : method.formal()) {
                FormalDefinition formalDef = new FormalDefinition(formal.OBJECT_IDENTIFIER().getText(), formal.varType().getText(), formalPos++);

                // Check for same formal name
                if (methodDef.formals.containsKey(formalDef.name)) {
                    errorOutput.add(fileName + ":" + formal.getStart().getLine() + ":" + (formal.getStart().getCharPositionInLine()+1) + ":" + " semantic error - formal '" + formalDef.name + "' is already defined.");
                }
                else
                    methodDef.formals.put(formalDef.name, formalDef);
            }

            // Check for same method name
            if (classDef.methods.containsKey(methodDef.name)) {
                errorOutput.add(fileName + ":" + method.getStart().getLine() + ":" + (method.getStart().getCharPositionInLine()+1) + ":" + " semantic error - method '" + methodDef.name + "' is already defined.");
            }
            else
                classDef.methods.put(methodDef.name, methodDef);
        }

        for (FieldContext field: fields) {

            FieldDefinition fieldDef = new FieldDefinition(field.OBJECT_IDENTIFIER().getText(), field.varType().getText());

            // Check for same field name
            if (classDef.fields.containsKey(fieldDef.name)) {
                errorOutput.add(fileName + ":" + field.getStart().getLine() + ":" + (field.getStart().getCharPositionInLine()+1) + ":" + " semantic error - field '" + fieldDef.name + "' is already defined.");
            }
            else
                classDef.fields.put(fieldDef.name, fieldDef);
        }


        // Check for same class name
        if (classes.containsKey(classDef.name)) {
            errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine()+1) + ":" + " semantic error - class '" + classDef.name + "' is already defined.");
        }
        else
            classes.put(classDef.name, classDef);
    }


//region CHECK_TYPES

    private void checkTypeCompileTime(ProgramContext ctx) {
        treeOutput.append("[");

        for (ClassDefinitionContext classDef : ctx.classDefinition()) {
            // Class info
            treeOutput.append("Class(");
            treeOutput.append(classDef.TYPE_IDENTIFIER(0).getText());
            treeOutput.append(", ");
            treeOutput.append(classDef.TYPE_IDENTIFIER(1) != null ? classDef.TYPE_IDENTIFIER(1).getText() : "Object");

            currentClass = classes.get(classDef.TYPE_IDENTIFIER(0).getText());
            List<FieldContext> fields = classDef.children.stream().filter(x -> x instanceof  FieldContext).map(x -> (FieldContext) x).collect(Collectors.toList());
            List<MethodDefinitionContext> methods = classDef.children.stream().filter(x -> x instanceof  MethodDefinitionContext).map(x -> (MethodDefinitionContext) x).collect(Collectors.toList());

            // Fields
            treeOutput.append(", [");
            for (FieldContext field: fields) {
                checkFieldDefinition(field);
                treeOutput.append(", ");
            }
            if (classDef.field().size() > 0) treeOutput.delete(treeOutput.length()-2, treeOutput.length());
            treeOutput.append("]");

            currentClass.classInitialized = true;

            // Methods
            treeOutput.append(", [");
            for (MethodDefinitionContext method: methods) {
                checkMethodDefinition(method);
                treeOutput.append(", ");
            }
            if (classDef.methodDefinition().size() > 0) treeOutput.delete(treeOutput.length()-2, treeOutput.length());
            treeOutput.append("]");

            treeOutput.append(")");
            treeOutput.append(", ");
        }

        if ( ctx.classDefinition().size() > 0) treeOutput.delete(treeOutput.length()-2, treeOutput.length());
        treeOutput.append("]");
    }

    private void checkForMainClass(ProgramContext ctx) {
        if (!classes.containsKey("Main") || !classes.get("Main").methods.containsKey("main") || !classes.get("Main").methods.get("main").type.equals("int32") || !classes.get("Main").methods.get("main").formals.isEmpty()) {
            errorOutput.add(fileName + ":" + 1 + ":" + 1 + ":" + " semantic error - a vsop program must define a Main class with a main method of type int32 without any arguments");
        }
    }

    private void checkForInheritance(ProgramContext ctx) {
        for (ClassDefinition classDef : classes.values()) {
            if (!classDef.extend.equals("Object") && !classDef.name.equals("Object")) {

                ClassDefinitionContext err = ctx.classDefinition().stream().filter(x -> x.children.get(1).getText().equals(classDef.name)).findFirst().get();

                ClassDefinition classExtension = classDef;
                ArrayList<String> loopStack = new ArrayList<>();
                loopStack.add(classDef.name);

                int depth = 0;
                do {
                    depth++;
                    if (!classes.containsKey(classExtension.extend)) {
                        if (depth == 1) errorOutput.add(fileName + ":" + err.getStart().getLine() + ":" + (err.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - parent's class '" + classExtension.extend + "' does not exist.");
                        break;
                    }

                    classExtension = classes.get(classExtension.extend);


                    ClassDefinition finalClassExtension = classExtension;
                    List<String> matches = loopStack.stream().filter(it -> it.contains(finalClassExtension.name)).collect(Collectors.toList());
                    if (matches.size() > 0) {
                        errorOutput.add(fileName + ":" + err.getStart().getLine() + ":" + (err.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - classes '" + classDef.name + "' and '" + loopStack.get(loopStack.size()-1) + "' cannot extend each other. Cycle detected.");
                        break;
                    }
                    loopStack.add(classExtension.name);

                    // Check if field is already defined
                    for (FieldDefinition fieldDef : classDef.fields.values()) {
                        if (classExtension.fields.containsKey(fieldDef.name)) {
                            FieldContext errField = err.field().stream().filter(x -> x.OBJECT_IDENTIFIER().getText().equals(fieldDef.name)).findFirst().get();
                            errorOutput.add(fileName + ":" + errField.getStart().getLine() + ":" + (errField.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - field '" + fieldDef.name + "' is already defined in parent class '" + classExtension.name + "'.");
                        }
                    }

                    // Check if methods is already defined
                    for (MethodDefinition methodDef : classDef.methods.values()) {
                        if (classExtension.methods.containsKey(methodDef.name)) {
                            MethodDefinition parent = classExtension.methods.get(methodDef.name);
                            MethodDefinitionContext errMethod = err.methodDefinition().stream().filter(x -> x.OBJECT_IDENTIFIER().getText().equals(methodDef.name)).findFirst().get();

                            // Check same type
                            if (!parent.type.equals(methodDef.type)) {
                                errorOutput.add(fileName + ":" + errMethod.getStart().getLine() + ":" + (errMethod.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - method '" + methodDef.name + "' does not correctly override parent's method (Wrong return type)'");
                            }

                            // Check for formals
                            List<String> formalsType = methodDef.formals.values().stream().map(x -> x.type).collect(Collectors.toList());
                            Collections.sort(formalsType);
                            List<String> formalsTypeParent = parent.formals.values().stream().map(x -> x.type).collect(Collectors.toList());
                            Collections.sort(formalsTypeParent);

                            if (formalsType.size() != formalsTypeParent.size()) {
                                errorOutput.add(fileName + ":" + errMethod.getStart().getLine() + ":" + (errMethod.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - method '" + methodDef.name + "' does not correctly override parent's method (Different number of arguments)'");
                            } else {
                                for (int i = 0; i < formalsType.size(); i++) {
                                    if (!formalsType.get(i).equals(formalsTypeParent.get(i))) {
                                        errorOutput.add(fileName + ":" + errMethod.getStart().getLine() + ":" + (errMethod.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - method '" + methodDef.name + "' does not correctly override parent's method (Different arguments' type)'");
                                    }
                                }
                            }
                        }
                    }
                } while (!classExtension.extend.equals("Object"));
            }
        }
    }

    private void checkFieldDefinition(FieldContext ctx) {
        treeOutput.append("Field(");
        treeOutput.append(ctx.OBJECT_IDENTIFIER().getText());
        treeOutput.append(", ");
        treeOutput.append(ctx.varType().getText());


        ArrayList<Map<String, String>> variablesCache = new ArrayList<>();
        String fieldName = ctx.OBJECT_IDENTIFIER().getText();
        if (fieldName.equals("self")) {
            errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine()+1) + ":" + " semantic error - invalid field name. '" + fieldName + "' is a reserved keyword.");
        }


        String fieldType = ctx.varType().getText();

        // Check if class exist
        if (!isPrimitive(fieldType) && !classes.containsKey(fieldType))
            errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - class '" + fieldType + "' is not defined.");

        String typeFound = "";

        if (variablesCache != null) variablesCache.add(new HashMap<>());
        variablesCache.get(variablesCache.size()-1).put("self", currentClass.name);

        if (ctx.statement() != null) {
            treeOutput.append(", ");
            if (variablesCache != null) variablesCache.add(new HashMap<>());
            typeFound = checkStatementType(ctx.statement(), variablesCache);
            if (variablesCache != null) variablesCache.remove(variablesCache.size()-1);
        }
        else if (ctx.block() != null) {
            treeOutput.append(", ");
            typeFound = checkBlockType(ctx.block(), variablesCache);
        }
        else
            fieldType = "";

        if (variablesCache != null) variablesCache.remove(variablesCache.size()-1);

        if (!fieldType.equals("")) {
            if (isPrimitive(typeFound)) {
                if (!fieldType.equals(typeFound) && !typeFound.equals("") && !fieldType.equals(""))
                    errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - invalid type in initializer of field '" + ctx.OBJECT_IDENTIFIER() + "'. Expecting '" + fieldType + "', found '" + typeFound + "'.");
            } else if (!lookForInheritance(ctx, fieldType, typeFound)) {
                errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - invalid type in initializer of field '" + ctx.OBJECT_IDENTIFIER() + "'. Expecting '" + fieldType + "', found '" + typeFound + "'.");
            } else if (typeFound.equals(currentClass.name)) {
                errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - cannot initialize field '" + ctx.OBJECT_IDENTIFIER() + "' with self class. Object is not yet initialized.");
            }
        }

        treeOutput.append(")");
    }

    private void checkMethodDefinition(MethodDefinitionContext ctx) {
        //Method Info
        treeOutput.append("Method(");
        treeOutput.append(ctx.OBJECT_IDENTIFIER());
        treeOutput.append(", ");


        ArrayList<Map<String, String>> variablesCache = new ArrayList<>();
        String methodType = ctx.varType().getText();
        String typeFound = null;

        // Check if class exist
        if (!isPrimitive(methodType) && !classes.containsKey(methodType))
            errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - class '" + methodType + "' is not defined.");

        variablesCache.add(new HashMap<>());

        // Add Self
        variablesCache.get(variablesCache.size()-1).put("self", currentClass.name);

        // Add Fields
        ClassDefinition classToCheck = currentClass;
        while (true) {
            for (FieldDefinition field : classToCheck.fields.values()) {
                variablesCache.get(variablesCache.size()-1).put(field.name, field.type);
            }
            if (classToCheck.extend.equals("Object"))
                break;
            if (classes.containsKey(classToCheck.extend))
                classToCheck = classes.get(classToCheck.extend);
            else
                break;

        }

        // Add formals
        treeOutput.append("[");
        variablesCache.add(new HashMap<>());

        List<FormalDefinition> formals = new ArrayList<>(currentClass.methods.get(ctx.OBJECT_IDENTIFIER().getText()).formals.values());
        Collections.sort(formals, Comparator.comparingInt(FormalDefinition::getPosition));
        for (FormalDefinition formal : formals) {
            if (formal.name.equals("self"))
                errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine()+1) + ":" + " semantic error - invalid formal name. '" + formal.name + "' is a reserved keyword.");
            else if (!isPrimitive(formal.type) && !classes.containsKey(formal.type))
                errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - class '" + formal.type + "' is not defined.");

            variablesCache.get(variablesCache.size()-1).put(formal.name, formal.type);
            treeOutput.append(formal.name);
            treeOutput.append(" : ");
            treeOutput.append(formal.type);
            treeOutput.append(", ");
        }
        if (ctx.formal().size() > 0) treeOutput.delete(treeOutput.length()-2, treeOutput.length());
        treeOutput.append("]");

        treeOutput.append(", ");
        treeOutput.append(methodType);
        treeOutput.append(", ");

        if (ctx.block() != null) {
            typeFound = checkBlockType(ctx.block(), variablesCache);
        }

        treeOutput.append(")");

        variablesCache.remove(variablesCache.size()-1);
        variablesCache.remove(variablesCache.size()-1);

        //if (!methodType.equals(typeFound)) {
        //    errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine()+1) + ":" + " semantic error - invalid return type in method '" + ctx.OBJECT_IDENTIFIER() + "'. Expecting '" + methodType + "', found '" + typeFound + "'.");
        //}

        if (!methodType.equals("")) {
            if (isPrimitive(typeFound)) {
                if (!methodType.equals(typeFound) && !typeFound.equals("") && !methodType.equals(""))
                    errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - invalid type in initializer of method '" + ctx.OBJECT_IDENTIFIER() + "'. Expecting '" + methodType + "', found '" + typeFound + "'.");
            } else if (!lookForInheritance(ctx, methodType, typeFound)) {
                errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - invalid type in initializer of method '" + ctx.OBJECT_IDENTIFIER() + "'. Expecting '" + methodType + "', found '" + typeFound + "'.");
            }
        }
    }

    private String checkBlockType(BlockContext ctx, ArrayList<Map<String, String>> variablesCache) {
        if (ctx.children.size() > 3)
            treeOutput.append("[");

        String typeFound = "unit";
        if (variablesCache != null) variablesCache.add(new HashMap<>());

        for (int i = 0; i < ctx.children.size()-2 ; i++) {
            if (ctx.children.get(i) instanceof ParserRuleContext) {
                ParserRuleContext child = (ParserRuleContext) ctx.children.get(i);

                if (child instanceof BlockContext) {
                    checkBlockType((BlockContext) child, variablesCache);
                } else if (child instanceof IfStatementContext) {
                    checkIfStatementType((IfStatementContext) child, variablesCache, true);
                } else if (child instanceof WhileStatementContext) {
                    checkWhileStatementType((WhileStatementContext) child, variablesCache);
                } else if (child instanceof StatementContext) {
                    checkStatementType((StatementContext) child, variablesCache);
                }
                treeOutput.append(", ");
            }
        }

        // Check last statement
        for (int i = ctx.children.size()-1; i >= 0 ; i--) {
            if (ctx.children.get(i) instanceof ParserRuleContext) {
                ParserRuleContext child = (ParserRuleContext) ctx.children.get(i);

                if (child instanceof BlockContext) {
                    typeFound = checkBlockType((BlockContext) child, variablesCache);
                } else if (child instanceof StatementContext) {
                    typeFound = checkStatementType((StatementContext) child, variablesCache);
                }

                break;
            }
        }

        if (variablesCache != null) variablesCache.remove(variablesCache.size()-1);


        if (ctx.children.size() > 3) {
            treeOutput.append("] : " + typeFound);
        }

        return typeFound;
    }

    private String checkStatementType(StatementContext ctx, ArrayList<Map<String, String>> variablesCache) {
        String typeFound = null;

        if (ctx.assign() != null) {
            typeFound = checkAssignOperation(ctx.assign(), variablesCache);
        } else if (ctx.ifStatement() != null) {
            typeFound = checkIfStatementType(ctx.ifStatement(), variablesCache, true);
        } else if (ctx.whileStatement() != null) {
            typeFound = checkWhileStatementType(ctx.whileStatement(), variablesCache);
        } else if (ctx.let() != null) {
            typeFound = checkLetStatementType(ctx.let(), variablesCache);
        } else if (ctx.binaryOperation() != null) {
            typeFound = checkBinaryOperation(ctx.binaryOperation(), variablesCache);
        } else if (ctx.callMethod() != null) {
            typeFound = checkCallMethod(ctx.callMethod(), variablesCache);
        } else if (ctx.newObj() != null) {
            typeFound = checkNewOperator(ctx.newObj(), variablesCache);
        } else if (ctx.OBJECT_IDENTIFIER() != null) {
            typeFound = checkVariableCacheForIdentifier(ctx.OBJECT_IDENTIFIER(), variablesCache);
            treeOutput.append(ctx.OBJECT_IDENTIFIER().getText() + " : " + typeFound);
        } else if (ctx.statement() != null) {
            typeFound = checkStatementType(ctx.statement(), variablesCache);
        } else if (ctx.varValue() != null) {
            typeFound = checkVarValue(ctx.varValue(), variablesCache);
        }

        return typeFound;
    }

    private String checkIfStatementType(IfStatementContext ctx, ArrayList<Map<String, String>> variablesCache, boolean displayError) {
        treeOutput.append("If(");

        boolean onlyIf = false, onlyElse = false;
        String returnType = "";
        String typeIfBranch = "";
        String typeElseBranch = "";

        // Check if condition is a bool type
        if (ctx.ifStat().statement(0) != null) {
            String conditionType = checkStatementType(ctx.ifStat().statement(0), variablesCache);
            if (displayError && !conditionType.equals("bool")) {
                errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - invalid return type for conditional statement. Found '" + conditionType + "'. Required type is 'bool'.");
            }

            if (ctx.ifStat().statement(0).getText().equals("true"))
                onlyIf = true;
            else if (ctx.ifStat().statement(0).getText().equals("false"))
                onlyElse = true;
        }

        // Get If branch type
        if (variablesCache != null) variablesCache.add(new HashMap<>());
        if (ctx.ifStat().statement(1) != null) {
            treeOutput.append(", ");
            typeIfBranch = checkStatementType(ctx.ifStat().statement(1), variablesCache);
        } else if (ctx.ifStat().block() != null) {
            treeOutput.append(", ");
            typeIfBranch = checkBlockType(ctx.ifStat().block(), variablesCache);
        }
        if (variablesCache != null) variablesCache.remove(variablesCache.size() - 1);

        // Get Else branch type
        if (ctx.elseStat() != null) {
            treeOutput.append(", ");
            if (variablesCache != null) variablesCache.add(new HashMap<>());
            if (ctx.elseStat().statement() != null) {
                typeElseBranch = checkStatementType(ctx.elseStat().statement(), variablesCache);
            } else if (ctx.elseStat().block() != null) {
                typeElseBranch = checkBlockType(ctx.elseStat().block(), variablesCache);
            }
            if (variablesCache != null) variablesCache.remove(variablesCache.size() - 1);
        } else {
            typeElseBranch = "unit";
        }

        if (displayError && !typeIfBranch.equals(typeElseBranch) && (!typeIfBranch.equals("unit") && !typeElseBranch.equals("unit")) && !lookForInheritance(ctx, typeIfBranch, typeElseBranch) && !lookForInheritance(ctx, typeElseBranch, typeIfBranch)) {
            errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - invalid return type for conditional statement. Found '" + typeIfBranch + "' in if branch and '" + typeElseBranch + "' in else branch.");
        }

        if (!isPrimitive(typeIfBranch) && !isPrimitive(typeElseBranch) && lookForInheritance(ctx, typeIfBranch, typeElseBranch)) {
            returnType = typeIfBranch;
        }
        else if (!isPrimitive(typeIfBranch) && !isPrimitive(typeElseBranch) && lookForInheritance(ctx, typeElseBranch, typeIfBranch)) {
            returnType = typeElseBranch;
        }
        else if (typeIfBranch.equals("unit") || typeElseBranch.equals("unit")) {
            returnType = "unit";
        } else {
            returnType = typeIfBranch;
        }

        treeOutput.append(")");
        treeOutput.append(" : ");
        treeOutput.append(returnType);

        return returnType;
    }

    private String checkWhileStatementType(WhileStatementContext ctx, ArrayList<Map<String, String>> variablesCache) {
        treeOutput.append("While(");
        String returnType = "unit";

        if (ctx.statement(0) != null) {
            String conditionType = checkStatementType(ctx.statement(0), variablesCache);
            if (!conditionType.equals("bool")) {
                errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - invalid return type for conditional statement. Found '" + conditionType + "'. Required type is 'bool'.");
            }
        }

        if (variablesCache != null) variablesCache.add(new HashMap<>());
        if (ctx.statement(1) != null) {
            treeOutput.append(", ");
            checkStatementType(ctx.statement(1), variablesCache);
        } else if (ctx.block() != null) {
            treeOutput.append(", ");
            checkBlockType(ctx.block(), variablesCache);
        }
        if (variablesCache != null) variablesCache.remove(variablesCache.size()-1);

        treeOutput.append(") : unit");
        return returnType;
    }

    private String checkLetStatementType(LetContext ctx, ArrayList<Map<String, String>> variablesCache) {
        treeOutput.append("Let(");
        treeOutput.append(ctx.OBJECT_IDENTIFIER().getText());
        treeOutput.append(", ");
        treeOutput.append(ctx.varType().getText());
        treeOutput.append(", ");

        String fieldName = ctx.OBJECT_IDENTIFIER().getText();
        if (fieldName.equals("self")) {
            errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine()+1) + ":" + " semantic error - invalid variable name. '" + fieldName + "' is a reserved keyword.");
        }

        // Check if type exist
        String letType = ctx.varType().getText();
        if (!isPrimitive(ctx.varType().getText()) && !classes.containsKey(letType))
            errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - class '" + letType + "' is not defined.");

        String typeFound = "";

        // Initializer
        int statOffset = 0;
        if (ctx.statement().size() == 2 || (ctx.statement().size() == 1 && ctx.block() != null)) {
            if (variablesCache != null) variablesCache.add(new HashMap<>());
            if (variablesCache != null) variablesCache.get(variablesCache.size()-1).put(ctx.OBJECT_IDENTIFIER().getText(), letType);
            //if (variablesCache != null) variablesCache.get(variablesCache.size()-1).put("self", letType); // Add self TODO : Check later for behaviour
            typeFound = checkStatementType(ctx.statement(statOffset++), variablesCache);
            treeOutput.append(", ");

            if (isPrimitive(typeFound)) {
                if (!typeFound.equals(letType))
                    errorOutput.add(fileName + ":" + ctx.statement(0).getStart().getLine() + ":" + (ctx.statement(0).getStart().getCharPositionInLine() + 1) + ":" + " semantic error - invalid type in initializer of let statement. Found '" + typeFound + "'. Expected type is '" + letType + "'.");
            }  else if (!lookForInheritance(ctx, letType, typeFound)) {
                errorOutput.add(fileName + ":" + ctx.statement(0).getStart().getLine() + ":" + (ctx.statement(0).getStart().getCharPositionInLine() + 1) + ":" + " semantic error - invalid type in initializer of let statement. Found '" + typeFound + "'. Expected type is '" + letType + "'.");
            }

            if (variablesCache != null) variablesCache.remove(variablesCache.size()-1);
        }

        // Body
        if (variablesCache != null) variablesCache.add(new HashMap<>());
        if (variablesCache != null) variablesCache.get(variablesCache.size()-1).put(ctx.OBJECT_IDENTIFIER().getText(), letType);
        //if (variablesCache != null) variablesCache.get(variablesCache.size()-1).put("self", letType); // Add self TODO : Check later for behaviour
        if (ctx.statement(statOffset) != null) {
            typeFound = checkStatementType(ctx.statement(statOffset), variablesCache);
        } else if (ctx.block() != null) {
            typeFound = checkBlockType(ctx.block(), variablesCache);
        }
        if (variablesCache != null) variablesCache.remove(variablesCache.size()-1);

        /*if (isPrimitive(typeFound)) {
            if (!typeFound.equals(letType))
                errorOutput.add(fileName + ":" + ctx.statement(0).getStart().getLine() + ":" + (ctx.statement(0).getStart().getCharPositionInLine() + 1) + ":" + " semantic error - invalid type in body of let statement. Found '" + typeFound + "'. Expected type is '" + letType + "'.");
        }  else if (!lookForInheritance(ctx, letType, typeFound)) {
            errorOutput.add(fileName + ":" + ctx.statement(0).getStart().getLine() + ":" + (ctx.statement(0).getStart().getCharPositionInLine() + 1) + ":" + " semantic error - invalid type in body of let statement. Found '" + typeFound + "'. Expected type is '" + letType + "'.");
        }*/

        treeOutput.append(") : " + typeFound);
        return typeFound;
    }

    private String checkBinaryOperation(BinaryOperationContext binOp, ArrayList<Map<String, String>> variablesCache) {

        return handleExpr1(binOp.expr1(), variablesCache);
    }

    private String handleExpr1(Expr1Context expr1, ArrayList<Map<String, String>> variablesCache) {

        if (expr1.expr1() != null) {
            treeOutput.append("BinOp(");
            treeOutput.append(expr1.AND().getText());
            treeOutput.append(", ");
            String type1 = handleExpr1(expr1.expr1(), variablesCache);
            treeOutput.append(", ");
            String type2 = handleExpr2(expr1.expr2(), variablesCache);
            treeOutput.append(") : bool");

            if (!type1.equals("bool"))
                errorOutput.add(fileName + ":" + expr1.getStart().getLine() + ":" + (expr1.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - expecting 'bool' in and statement. Found '" + type1 + "' on left side.");
            if (!type2.equals("bool"))
                errorOutput.add(fileName + ":" + expr1.getStart().getLine() + ":" + (expr1.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - expecting 'bool' in and statement. Found '" + type2 + "' on right side.");
        } else
           return handleExpr2(expr1.expr2(), variablesCache);

        return "bool";
    }

    private String handleExpr2(Expr2Context expr2, ArrayList<Map<String, String>> variablesCache) {

        if (expr2.expr2() != null) {
            treeOutput.append("UnOp(");
            treeOutput.append(expr2.NOT().getText());
            treeOutput.append(", ");
            String type1 = handleExpr2(expr2.expr2(), variablesCache);
            treeOutput.append(") : bool");

            if (!type1.equals("bool"))
                errorOutput.add(fileName + ":" + expr2.getStart().getLine() + ":" + (expr2.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - expecting 'bool' in not statement. Found '" + type1 + "'.");
        } else
            return handleExpr3(expr2.expr3(), variablesCache);

        return "bool";
    }

    private String handleExpr3(Expr3Context expr3, ArrayList<Map<String, String>> variablesCache) {

        if (expr3.comparatorOperator() != null) {
            treeOutput.append("BinOp(");
            treeOutput.append(expr3.comparatorOperator().getText());
            treeOutput.append(", ");
            String type1 = handleExpr4(expr3.expr4(0), variablesCache);
            treeOutput.append(", ");
            String type2 = handleExpr4(expr3.expr4(1), variablesCache);
            treeOutput.append(") : bool");

            if (!type1.equals(type2))
                errorOutput.add(fileName + ":" + expr3.getStart().getLine() + ":" + (expr3.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - expecting same type on each side. Found '" + type1 + "' on left side and '" + type2 + "' on right side.");
        } else
           return handleExpr4(expr3.expr4(0), variablesCache);

        return "bool";
    }

    private String handleExpr4(Expr4Context expr4, ArrayList<Map<String, String>> variablesCache) {

        if (expr4.termOperator() != null) {
            treeOutput.append("BinOp(");
            treeOutput.append(expr4.termOperator().getText());
            treeOutput.append(", ");
            String type1 = handleExpr4(expr4.expr4(), variablesCache);
            treeOutput.append(", ");
            String type2 = handleExpr5(expr4.expr5(), variablesCache);
            treeOutput.append(") : int32");

            if (!type1.equals("int32"))
                errorOutput.add(fileName + ":" + expr4.getStart().getLine() + ":" + (expr4.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - expecting 'int32' in arithmetic statement. Found '" + type1 + "' on left side.");
            if (!type2.equals("int32"))
                errorOutput.add(fileName + ":" + expr4.getStart().getLine() + ":" + (expr4.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - expecting 'int32' in arithmetic statement. Found '" + type2 + "' on right side.");
        } else
            return handleExpr5(expr4.expr5(), variablesCache);

        return "int32";
    }

    private String handleExpr5(Expr5Context expr5, ArrayList<Map<String, String>> variablesCache) {

        if (expr5.factorOperator() != null) {
            treeOutput.append("BinOp(");
            treeOutput.append(expr5.factorOperator().getText());
            treeOutput.append(", ");
            String type1 = handleExpr5(expr5.expr5(), variablesCache);
            treeOutput.append(", ");
            String type2 = handleExpr6(expr5.expr6(), variablesCache);
            treeOutput.append(") : int32");

            if (!type1.equals("int32"))
                errorOutput.add(fileName + ":" + expr5.getStart().getLine() + ":" + (expr5.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - expecting 'int32' in arithmetic statement. Found '" + type1 + "' on left side.");
            if (!type2.equals("int32"))
                errorOutput.add(fileName + ":" + expr5.getStart().getLine() + ":" + (expr5.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - expecting 'int32' in arithmetic statement. Found '" + type2 + "' on right side.");
        } else
            return handleExpr6(expr5.expr6(), variablesCache);

        return "int32";
    }

    private String handleExpr6(Expr6Context expr6, ArrayList<Map<String, String>> variablesCache) {
        String returnType = "";

        if (expr6.expr6() != null) {
            String operator = expr6.MINUS() != null ? expr6.MINUS().getText() : expr6.ISNULL().getText();
            String type = "";
            returnType = expr6.MINUS() != null ? "int32" : "bool";
            treeOutput.append("UnOp(");
            treeOutput.append(operator);
            treeOutput.append(", ");
            type = handleExpr6(expr6.expr6(), variablesCache);
            treeOutput.append(") : " + returnType);


            if (operator.equals("isnull") && isPrimitive(type)) {
                errorOutput.add(fileName + ":" + expr6.getStart().getLine() + ":" + (expr6.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - expected type in isnull operator is 'Object'. Found '" + type + "'.");
            } else if (operator.equals("-") && !type.equals("int32")) {
                errorOutput.add(fileName + ":" + expr6.getStart().getLine() + ":" + (expr6.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - expected type in - operator is 'int32'. Found '" + type + "'.");
            }

        } else
            return handleExpr7(expr6.expr7(), variablesCache);

        return returnType;
    }

    private String handleExpr7(Expr7Context expr7, ArrayList<Map<String, String>> variablesCache) {

        if (expr7.POW() != null) {
            treeOutput.append("BinOp(");
            treeOutput.append(expr7.POW().getText());
            treeOutput.append(", ");
            String type1 = handleExpr8(expr7.expr8(), variablesCache);
            treeOutput.append(", ");
            String type2 = handleExpr7(expr7.expr7(), variablesCache);
            treeOutput.append(") : int32");

            if (!type1.equals("int32"))
                errorOutput.add(fileName + ":" + expr7.getStart().getLine() + ":" + (expr7.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - expecting 'int32' in arithmetic statement. Found '" + type1 + "' on left side.");
            if (!type2.equals("int32"))
                errorOutput.add(fileName + ":" + expr7.getStart().getLine() + ":" + (expr7.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - expecting 'int32' in arithmetic statement. Found '" + type2 + "' on right side.");
        } else
            return handleExpr8(expr7.expr8(), variablesCache);

        return "int32";
    }

    private String handleExpr8(Expr8Context expr8, ArrayList<Map<String, String>> variablesCache) {

        if (expr8.expr1() != null)
            return handleExpr1(expr8.expr1(), variablesCache);
        else if (expr8.callMethod() != null)
            return checkCallMethod(expr8.callMethod(), variablesCache);
        else if (expr8.varValue() != null)
            return checkVarValue(expr8.varValue(), variablesCache);
        else if (expr8.newObj() != null)
            return checkNewOperator(expr8.newObj(), variablesCache);
        else if (expr8.ifStatement() != null)
            return checkIfStatementType(expr8.ifStatement(), variablesCache, true);
        else if (expr8.OBJECT_IDENTIFIER() != null) {
            String typeFound = checkVariableCacheForIdentifier(expr8.OBJECT_IDENTIFIER(), variablesCache);
            treeOutput.append(expr8.OBJECT_IDENTIFIER().getText() + " : " + typeFound);
            return typeFound;
        }

        return "";


    }

    private String checkAssignOperation(AssignContext ctx, ArrayList<Map<String, String>> variablesCache) {
        String varType = checkVariableCacheForIdentifier(ctx.OBJECT_IDENTIFIER(), variablesCache);
        treeOutput.append("Assign(");
        treeOutput.append(ctx.OBJECT_IDENTIFIER().getText());
        treeOutput.append(", ");
        String typeFound = "";


        if (ctx.statement() != null) {
            typeFound = checkStatementType(ctx.statement(), variablesCache);
        }

        if (ctx.OBJECT_IDENTIFIER().getText().equals("self")) {
            errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - cannot assign to 'self' variable.");
        }
        else if (isPrimitive(typeFound)) {
            if (!varType.equals(typeFound) && !typeFound.equals("") && !varType.equals(""))
                errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - cannot assign '" + typeFound + "' to variable '" + ctx.OBJECT_IDENTIFIER().getText() + "' of type '" + varType + "'.");
        } else if (!lookForInheritance(ctx, varType, typeFound)) {
            errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - cannot assign '" + typeFound + "' to variable '" + ctx.OBJECT_IDENTIFIER().getText() + "' of type '" + varType + "'.");
        }

        treeOutput.append(")" + " : " + varType);
        return typeFound;
    }

    private String checkNewOperator(NewObjContext ctx, ArrayList<Map<String, String>> variablesCache) {
        treeOutput.append("New(");
        treeOutput.append(ctx.TYPE_IDENTIFIER().getText());
        treeOutput.append(") : ");
        treeOutput.append(ctx.TYPE_IDENTIFIER().getText());

        // Check if class exist
        if (!classes.containsKey(ctx.TYPE_IDENTIFIER().getText()) && !ctx.TYPE_IDENTIFIER().getText().equals("Object"))
            errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - class '" + ctx.TYPE_IDENTIFIER().getText() + "' is not defined.");

        return ctx.TYPE_IDENTIFIER().getText();
    }

    private String checkCallMethod(CallMethodContext ctx, ArrayList<Map<String, String>> variablesCache) {
        if (!(ctx.parent.parent instanceof BlockContext) && ctx.singleCallMethod().size() > 1) {
            treeOutput.append("[");
        }

        for (SingleCallMethodContext call : ctx.singleCallMethod()) {
            for (int i = 0; i < call.callFunction().size(); i++) {
                treeOutput.append("Call(");
            }
            for (int i = 0; i < call.caller().size(); i++) {
                //treeOutput.append("Call(");
            }
        }

        String lastCallerType = "";

        if (ctx.singleCallMethod(0).caller().size() == 0) {
            lastCallerType = currentClass.name;
            treeOutput.append("self : " + currentClass.name);
            if (!currentClass.classInitialized)
                errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - cannot use self or call it's own methods in field initializer since the object is not yet initialized.");
        } else if (ctx.singleCallMethod(0).caller(0).OBJECT_IDENTIFIER() != null) {
            lastCallerType = checkVariableCacheForIdentifier(ctx.singleCallMethod(0).caller(0).OBJECT_IDENTIFIER(), variablesCache);
            treeOutput.append(ctx.singleCallMethod(0).caller(0).OBJECT_IDENTIFIER().getText() + " : " + lastCallerType);
        } else if (ctx.singleCallMethod(0).caller(0).newObj() != null) {
            lastCallerType = checkNewOperator(ctx.singleCallMethod(0).caller(0).newObj(), variablesCache);
        } else if (ctx.singleCallMethod(0).caller(0).ifStatement() != null) {
            lastCallerType = checkIfStatementType(ctx.singleCallMethod(0).caller(0).ifStatement(), variablesCache, true);
        }

        int firstOffset = 1;
        for (SingleCallMethodContext call : ctx.singleCallMethod()) {
            lastCallerType = checkCaller(call, lastCallerType, firstOffset, variablesCache);
            treeOutput.append(", ");
            lastCallerType = checkCallFunction(call, lastCallerType, variablesCache);
            firstOffset = 0;
        }

        if (!(ctx.parent.parent instanceof BlockContext) && ctx.singleCallMethod().size() > 1) {
            treeOutput.append("]");
        }

        return lastCallerType;
    }

    private String checkCaller(SingleCallMethodContext ctx, String typeFoundForCaller, int firstOffset, ArrayList<Map<String, String>> variablesCache) {

        for (int i = firstOffset; i < ctx.caller().size(); i++) {
            treeOutput.append(".");
            // Grab next
            if (ctx.caller(i).OBJECT_IDENTIFIER() != null) {
                // TODO : Inheritance
                if (classes.containsKey(typeFoundForCaller) && classes.get(typeFoundForCaller).fields.containsKey(ctx.caller(i).OBJECT_IDENTIFIER().getText()))
                    typeFoundForCaller = classes.get(typeFoundForCaller).fields.get(ctx.caller(i).OBJECT_IDENTIFIER().getText()).type;
                else {
                    errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - field '" + ctx.caller(i).OBJECT_IDENTIFIER().getText() + "' does not exist in class '" + typeFoundForCaller + "'.");
                    break;
                }
                treeOutput.append(ctx.caller(i).OBJECT_IDENTIFIER().getText() + " : " + typeFoundForCaller);
            } else if (ctx.caller(i).newObj() != null) {
                typeFoundForCaller = checkNewOperator(ctx.caller(i).newObj(), variablesCache);
            } else if (ctx.caller(i).ifStatement() != null) {
                typeFoundForCaller = checkIfStatementType(ctx.caller(i).ifStatement(), variablesCache, true);
            }
        }
        //treeOutput.delete(treeOutput.length()-1, treeOutput.length());

        return typeFoundForCaller;
    }

    private String checkCallFunction(SingleCallMethodContext ctx, String lastCallerType, ArrayList<Map<String, String>> variablesCache) {
        for (int i = 0; i < ctx.callFunction().size(); i++) {
            treeOutput.append(ctx.callFunction(i).OBJECT_IDENTIFIER().getText());

            String classToCheck = lastCallerType;
            boolean isClassMethodFound = false;
            while(true) {

                if (classes.containsKey(classToCheck)) {
                    if (classes.get(classToCheck).methods.containsKey(ctx.callFunction(i).OBJECT_IDENTIFIER().getText())) {
                        isClassMethodFound = true;
                        break;
                    }
                    classToCheck = classes.get(classToCheck).extend;
                } else {
                    break;
                }
            }

            if (isClassMethodFound) {
                MethodDefinition methodToCheck = classes.get(classToCheck).methods.get(ctx.callFunction(i).OBJECT_IDENTIFIER().getText());
                lastCallerType = methodToCheck.type;
                //Check arguments
                if (methodToCheck.formals.values().size() != ctx.callFunction(i).argument().size()) {
                    errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - method call '" + methodToCheck.name + "()' has a different number of arguments then is definition. Expected '" + methodToCheck.formals.values().size() + ". Found '" + ctx.callFunction(i).argument().size() + "'.");
                    continue;
                }

                treeOutput.append(", [");

                List<FormalDefinition> formals = new ArrayList<>(methodToCheck.formals.values());
                Collections.sort(formals, Comparator.comparingInt(FormalDefinition::getPosition));
                int j = 0;
                for (FormalDefinition formal : formals) {
                    ArgumentContext arg = ctx.callFunction(i).argument(j++);
                    String argType = "";
                    argType = checkStatementType(arg.statement(), variablesCache);
                    /*if (arg.statement().binaryOperation() != null) {
                        argType = checkBinaryOperation(arg.statement().binaryOperation(), variablesCache);
                    } else if (arg.statement().callMethod() != null) {
                        argType = checkCallMethod(arg.statement().callMethod(), variablesCache);
                    } else if (arg.statement().newObj() != null) {
                        argType = checkNewOperator(arg.statement().newObj(), variablesCache);
                    } else if (arg.statement().OBJECT_IDENTIFIER() != null) {
                        argType = checkVariableCacheForIdentifier(arg.statement().OBJECT_IDENTIFIER(), variablesCache);
                        treeOutput.append(arg.statement().OBJECT_IDENTIFIER().getText() + " : " + argType);
                    } else if (arg.statement().varValue() != null) {
                        argType = checkVarValue(arg.statement().varValue(), variablesCache);
                    }*/


                    if (isPrimitive(argType)) {
                        if (!formal.type.equals(argType))
                            errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - method call '" + methodToCheck.name + "()' argument's #" + j + " is of type '" + argType + "'. Expecting '" + formal.type + "'.");
                    }
                    else if (!lookForInheritance(ctx, formal.type, argType)) {
                        errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - method call '" + methodToCheck.name + "()' argument's #" + j + " is of type '" + argType + "'. Expecting '" + formal.type + "'.");
                    }


                    treeOutput.append(", ");
                }
                if (methodToCheck.formals.values().size() > 0) treeOutput.delete(treeOutput.length()-2, treeOutput.length());
                treeOutput.append("]");

                treeOutput.append(") : " + methodToCheck.type + ", ");
            } else {
                errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - method '" + ctx.callFunction(i).OBJECT_IDENTIFIER().getText() + "' does not exist in class '" + lastCallerType + "'.");
                //break;
            }

        }
        treeOutput.delete(treeOutput.length()-2, treeOutput.length());

        return lastCallerType;
    }

    private String checkVarValue(VarValueContext ctx, ArrayList<Map<String, String>> variablesCache) {
        String typeFound = "";


        if (ctx.integer() != null) {
            typeFound = "int32";
        } else if (ctx.STRING() != null) {
            typeFound = "string";
        } else if (ctx.getText().equals("true") || ctx.getText().equals("false")) {
            typeFound = "bool";
        } else if (ctx.VOID_OPERATOR() != null) {
            typeFound = "unit";
        }

        treeOutput.append(ctx.getText() + " : " + typeFound);

        return typeFound;
    }

    private String checkVariableCacheForIdentifier(TerminalNode identifier, ArrayList<Map<String, String>> variablesCache) {
        String typeFound = "";

        if (variablesCache != null) {
            for (int i = variablesCache.size() - 1; i >= 0; i--) {
                if (variablesCache.get(i).containsKey(identifier.getText())) {
                    typeFound = variablesCache.get(i).get(identifier.getText());
                    break;
                }
            }
        }

        if (typeFound.equals(""))
            errorOutput.add(fileName + ":" + identifier.getSymbol().getLine() + ":" + (identifier.getSymbol().getCharPositionInLine() + 1) + ":" + " semantic error - variable '" + identifier.getText() + "' not defined.");

        return typeFound;
    }

    private boolean lookForInheritance(ParserRuleContext ctx, String parent, String child) {

            ClassDefinition classToCheck =  classes.get(child);
            if (classToCheck != null) {
                while (true) {

                    if (parent.equals(classToCheck.name) && !parent.equals("")) {
                        return true;
                    }

                    //if (classToCheck.extend.equals("Object"))
                    //    break;
                    // TODO : Check if empty extend of object make crash
                    if (classes.containsKey(classToCheck.extend))
                        classToCheck = classes.get(classToCheck.extend);
                    else if (classToCheck.extend.equals("")) {
                        break;
                    } else {
                        errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - class '" + child + "' is not defined.");
                        break;
                    }

                }
            } else {
                errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - class '" + child + "' is not defined.");
            }

        return false;
    }

    private boolean isPrimitive(String varType) {
        switch (varType) {
            case "int32":
                return true;
            case "unit":
                return true;
            case "bool":
                return true;
            case "string":
                return true;
            default:
                return false;
        }
    }

//endregion



}
