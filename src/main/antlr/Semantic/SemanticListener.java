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
        } else if (ctx.unOperation() != null) {
            typeFound = checkUnOperation(ctx.unOperation(), variablesCache);
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

        //if (!onlyIf && !onlyElse) {
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
        /*} else {
            if (onlyIf)
                returnType = typeIfBranch;
            else if (onlyElse)
                returnType = typeElseBranch;
        }*/



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

    private String checkBinaryOperation(BinaryOperationContext ctx, ArrayList<Map<String, String>> variablesCache) {
        String typeFound = "";

        if (ctx.AND_OPERATOR().size() > 0)
            typeFound = "bool";
        else if (ctx.condition(0).CONDITIONAL_OPERATOR().size() > 0)
            typeFound = "bool";
        else if (ctx.condition(0) != null && ctx.condition(0).term(0) != null &&
                 ctx.condition(0).term(0).factor(0) != null && ctx.condition(0).term(0).factor(0).value(0) != null &&
                 ctx.condition(0).term(0).factor(0).value(0).unOperation() != null &&
                 !ctx.condition(0).term(0).factor(0).value(0).unOperation().getText().substring(0, 1).equals("-"))
            typeFound = "bool";
        else
            typeFound = "int32";

        handleBinaryOperation2(ctx, variablesCache);

        return typeFound;
    }

    private String handleBinaryOperation2(BinaryOperationContext binOp, ArrayList<Map<String, String>> variablesCache) {
        if (binOp.condition().size() == 1) {
            return handleCondition2(binOp.condition(0), variablesCache);
        } else {

            for (int i = binOp.AND_OPERATOR().size()-1 ; i >= 0; i--) {
                treeOutput.append("BinOp(");
                treeOutput.append(binOp.AND_OPERATOR(i).getText());
                treeOutput.append(", ");
            }

            String typeFound = handleCondition2(binOp.condition(0), variablesCache);
            if (!typeFound.equals("bool"))
                errorOutput.add(fileName + ":" + binOp.getStart().getLine() + ":" + (binOp.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - expecting 'bool' in compare statement. Found '" + typeFound + "'.");

            for (int j = 1 ; j < binOp.AND_OPERATOR().size(); j++) {
                treeOutput.append(", ");
                typeFound = handleCondition2(binOp.condition(j), variablesCache);
                if (!typeFound.equals("bool"))
                    errorOutput.add(fileName + ":" + binOp.getStart().getLine() + ":" + (binOp.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - expecting 'bool' in compare statement. Found '" + typeFound + "'.");
                treeOutput.append(") : bool");
            }

            treeOutput.append(", ");
            typeFound = handleCondition2(binOp.condition(binOp.AND_OPERATOR().size()), variablesCache);
            if (!typeFound.equals("bool"))
                errorOutput.add(fileName + ":" + binOp.getStart().getLine() + ":" + (binOp.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - expecting 'bool' in compare statement. Found '" + typeFound + "'.");
            treeOutput.append(") : bool");
        }

        return "bool";
    }

    private String handleCondition2(ConditionContext cond, ArrayList<Map<String, String>> variablesCache) {
        if (cond.term().size() == 1) {
            return handleTerm2(cond.term(0), variablesCache);
        } else {

            for (int i = cond.CONDITIONAL_OPERATOR().size()-1 ; i >= 0; i--) {
                treeOutput.append("BinOp(");
                treeOutput.append(cond.CONDITIONAL_OPERATOR(i).getText());
                treeOutput.append(", ");
            }

            String typeTerm1 = handleTerm2(cond.term(0), variablesCache);
            String typeTerm2 = "";
            //if (!typeFound.equals("bool"))
            //    errorOutput.add(fileName + ":" + cond.getStart().getLine() + ":" + (cond.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - expecting 'bool' in compare statement. Found '" + typeFound + "'.");

            for (int j = 1 ; j < cond.CONDITIONAL_OPERATOR().size(); j++) {
                treeOutput.append(", ");
                typeTerm2 = handleTerm2(cond.term(j), variablesCache);
                if (!typeTerm1.equals(typeTerm2))
                    errorOutput.add(fileName + ":" + cond.getStart().getLine() + ":" + (cond.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - expecting same type on each side. Found '" + typeTerm1 + "' and '" + typeTerm2 + "'.");
                treeOutput.append(") : bool");
            }

            treeOutput.append(", ");
            typeTerm2 = handleTerm2(cond.term(cond.CONDITIONAL_OPERATOR().size()), variablesCache);
            if (!typeTerm1.equals(typeTerm2))
                errorOutput.add(fileName + ":" + cond.getStart().getLine() + ":" + (cond.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - expecting same type on each side. Found '" + typeTerm1 + "' and '" + typeTerm2 + "'.");
            treeOutput.append(") : bool");
        }

        return "bool";
    }

    private String handleTerm2(TermContext term, ArrayList<Map<String, String>> variablesCache) {
        if (term.factor().size() == 1) {
            return handleFactor2(term.factor(0), variablesCache);
        } else {
            for (int i = term.termOperator().size()-1 ; i >= 0; i--) {
                treeOutput.append("BinOp(");
                treeOutput.append(term.termOperator(i).getText());
                treeOutput.append(", ");
            }

            String typeFound = handleFactor2(term.factor(0), variablesCache);
            if (!typeFound.equals("int32"))
                errorOutput.add(fileName + ":" + term.getStart().getLine() + ":" + (term.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - expecting 'int32' in arithmetic operation. Found '" + typeFound + "'.");

            for (int j = 1 ; j < term.termOperator().size(); j++) {
                treeOutput.append(", ");
                typeFound = handleFactor2(term.factor(j), variablesCache);
                if (!typeFound.equals("int32"))
                    errorOutput.add(fileName + ":" + term.getStart().getLine() + ":" + (term.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - expecting 'int32' in arithmetic operation. Found '" + typeFound + "'.");
                treeOutput.append(") : int32");
            }

            treeOutput.append(", ");
            typeFound = handleFactor2(term.factor(term.termOperator().size()), variablesCache);
            if (!typeFound.equals("int32"))
                errorOutput.add(fileName + ":" + term.getStart().getLine() + ":" + (term.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - expecting 'int32' in arithmetic operation. Found '" + typeFound + "'.");
            treeOutput.append(") : int32");
        }

        return "int32";
    }

    private String handleFactor2(FactorContext factor, ArrayList<Map<String, String>> variablesCache) {
        if (factor.value().size() == 1) {
            return handleValue2(factor.value(0), variablesCache);
        } else {

            for (int i = factor.FACTOR_OPERATOR().size()-1 ; i >= 0; i--) {
                treeOutput.append("BinOp(");
                treeOutput.append(factor.FACTOR_OPERATOR(i).getText());
                treeOutput.append(", ");
            }

            String typeFound = handleValue2(factor.value(0), variablesCache);
            if (!typeFound.equals("int32"))
                errorOutput.add(fileName + ":" + factor.getStart().getLine() + ":" + (factor.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - expecting 'int32' in arithmetic operation. Found '" + typeFound + "'.");

            for (int j = 1 ; j < factor.FACTOR_OPERATOR().size(); j++) {
                treeOutput.append(", ");
                typeFound = handleValue2(factor.value(j), variablesCache);
                if (!typeFound.equals("int32"))
                    errorOutput.add(fileName + ":" + factor.getStart().getLine() + ":" + (factor.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - expecting 'int32' in arithmetic operation. Found '" + typeFound + "'.");
                treeOutput.append(") : int32");
            }

            treeOutput.append(", ");
            typeFound = handleValue2(factor.value(factor.FACTOR_OPERATOR().size()), variablesCache);
            if (!typeFound.equals("int32"))
                errorOutput.add(fileName + ":" + factor.getStart().getLine() + ":" + (factor.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - expecting 'int32' in arithmetic operation. Found '" + typeFound + "'.");
            treeOutput.append(") : int32");
        }

        return "int32";
    }

    private String handleValue2(ValueContext value, ArrayList<Map<String, String>> variablesCache) {
        if (value.unOperation() != null)
            return checkUnOperation(value.unOperation(), variablesCache);
        else if (value.callMethod() != null)
            return checkCallMethod(value.callMethod(), variablesCache);
        else if (value.varValue() != null)
            return checkVarValue(value.varValue(), variablesCache);
        else if (value.newObj() != null)
            return checkNewOperator(value.newObj(), variablesCache);
        else if (value.ifStatement() != null)
            return checkIfStatementType(value.ifStatement(), variablesCache, true);
        else if (value.OBJECT_IDENTIFIER() != null) {
            String typeFound = checkVariableCacheForIdentifier(value.OBJECT_IDENTIFIER(), variablesCache);
            treeOutput.append(value.OBJECT_IDENTIFIER().getText() + " : " + typeFound);
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
                if (classes.containsKey(typeFoundForCaller) && classes.get(typeFoundForCaller).fields.containsKey(ctx.caller(i).OBJECT_IDENTIFIER().getText()))
                    typeFoundForCaller = classes.get(typeFoundForCaller).fields.get(ctx.caller(i).OBJECT_IDENTIFIER().getText()).type;
                else {
                    errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - field '" + ctx.caller(i).OBJECT_IDENTIFIER().getText() + "' does not exist in class '" + typeFoundForCaller + "'.");
                    break;
                }
                treeOutput.append(ctx.caller(i).OBJECT_IDENTIFIER().getText() + " : " + typeFoundForCaller);
            } else if (ctx.caller(i).newObj() != null) {
                typeFoundForCaller = checkNewOperator(ctx.caller(i).newObj(), variablesCache);
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
                    if (arg.binaryOperation() != null) {
                        argType = checkBinaryOperation(arg.binaryOperation(), variablesCache);
                    } else if (arg.callMethod() != null) {
                        argType = checkCallMethod(arg.callMethod(), variablesCache);
                    } else if (arg.newObj() != null) {
                        argType = checkNewOperator(arg.newObj(), variablesCache);
                    } else if (arg.OBJECT_IDENTIFIER() != null) {
                        argType = checkVariableCacheForIdentifier(arg.OBJECT_IDENTIFIER(), variablesCache);
                        treeOutput.append(arg.OBJECT_IDENTIFIER().getText() + " : " + argType);
                    } else if (arg.varValue() != null) {
                        argType = checkVarValue(arg.varValue(), variablesCache);
                    }


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

    private String checkUnOperation(UnOperationContext ctx, ArrayList<Map<String, String>> variablesCache) {
        String typeFound = "";
        treeOutput.append("UnOp(");
        treeOutput.append(ctx.unOperator().getText());
        treeOutput.append(", ");

        if (ctx.statement() != null)
            typeFound = checkStatementType(ctx.statement(), variablesCache);
        //else if (unOp.condition() != null)
        //    handleCondition2(unOp.condition(), variablesCache);

        if (ctx.unOperator().getText().equals("isnull") && isPrimitive(typeFound)) {
            errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - expected type in isnull operator is 'Object'. Found '" + typeFound + "'.");
        } else if (ctx.unOperator().getText().equals("-") && !typeFound.equals("int32")) {
            errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) + ":" + " semantic error - expected type in - operator is 'int32'. Found '" + typeFound + "'.");
        }

        if (ctx.unOperator().getText().equals("-"))
            typeFound = "int32";
        else
            typeFound = "bool";
        treeOutput.append(") : " + typeFound);

        return typeFound;
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

//region WRITE_ABSTRACT_TREE

    private StringBuilder handleProgram(ProgramContext ctx) {

        StringBuilder output = new StringBuilder();
        output.append("[");

        for (ClassDefinitionContext classDef : ctx.classDefinition()) {
            output.append(handleClass(classDef));
            output.append(", ");
        }
        if ( ctx.classDefinition().size() > 0) output.delete(output.length()-2, output.length());

        output.append("]");

        return output;
    }

    private StringBuilder handleClass(ClassDefinitionContext classDef) {

        // Class Info
        StringBuilder output = new StringBuilder();
        output.append("Class(");
        output.append(classDef.TYPE_IDENTIFIER(0).getText());
        output.append(", ");
        output.append(classDef.TYPE_IDENTIFIER(1) != null ? classDef.TYPE_IDENTIFIER(1).getText() : "Object");

        // Fields
        output.append(", [");
        for (FieldContext field : classDef.field()) {
            output.append(handleField(field));
            output.append(", ");
        }
        if (classDef.field().size() > 0) output.delete(output.length()-2, output.length());
        output.append("]");

        // Methods
        output.append(", [");
        for (MethodDefinitionContext method : classDef.methodDefinition()) {
            output.append(handleMethod(method));
            output.append(", ");
        }
        if (classDef.methodDefinition().size() > 0) output.delete(output.length()-2, output.length());
        output.append("]");
        output.append(")");

        return output;
    }

    private StringBuilder handleField(FieldContext field) {
        StringBuilder output = new StringBuilder();
        output.append("Field(");
        output.append(field.OBJECT_IDENTIFIER().getText());
        output.append(", ");
        output.append(field.varType().getText());

        if (field.statement() != null) {
            output.append(", ");
            output.append(handleStatement(field.statement()));
        }
        else if (field.block() != null) {
            output.append(", ");
            output.append(handleBlock(field.block()));
        } else {
            /*output.append(", ");
            output.append(defaultVarValue(field.varType().getText()));
            output.append(" : ");
            output.append(field.varType().getText());*/
        }

        output.append(")");
        return output;
    }

    private StringBuilder handleMethod(MethodDefinitionContext method) {
        StringBuilder output = new StringBuilder();
        //Method Info
        output.append("Method(");
        output.append(method.OBJECT_IDENTIFIER());
        output.append(", ");
        output.append("[");

        for (FormalContext formal : method.formal()) {
            output.append(handleFormal(formal));
            output.append(", ");
        }

        if (method.formal().size() > 0) output.delete(output.length()-2, output.length());
        output.append("]");

        output.append(", ");
        output.append(method.varType().getText());
        output.append(", ");
        output.append(handleBlock(method.block()));
        output.append(")");

        return output;
    }

    private StringBuilder handleFormal(FormalContext formal) {
        StringBuilder output = new StringBuilder();

        output.append(formal.OBJECT_IDENTIFIER().getText());
        output.append(" : ");
        output.append(formal.varType().getText());

        return output;
    }

    private StringBuilder handleBlock(BlockContext block) {
        StringBuilder output = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int countStat = 0;
        for (ParseTree child : block.children) {

            if (child instanceof ParserRuleContext) {
                countStat++;

                if (child instanceof StatementContext) {
                    temp.append(handleStatement((StatementContext) child));
                } else if (child instanceof IfStatementContext) {
                    temp.append(handleIfStatement((IfStatementContext) child));
                } else if (child instanceof WhileStatementContext) {
                    temp.append(handleWhileStatement((WhileStatementContext) child));
                }

                temp.append(", ");
            }
        }

        if (countStat > 1) {
            output.append("[");
            if (temp.length() > 1) temp.delete(temp.length()-2, temp.length());
            output.append(temp);
            output.append("]");
        } else {
            if (temp.length() > 1) temp.delete(temp.length()-2, temp.length());
            output.append(temp);
        }

        return output;
    }

    private StringBuilder handleStatement(StatementContext statement) {
        StringBuilder output = new StringBuilder();

        if (statement.assign() != null) {
            output.append(handleAssign(statement.assign()));
        } else if (statement.ifStatement() != null) {
            output.append(handleIfStatement(statement.ifStatement()));
        } else if (statement.whileStatement() != null) {
            output.append(handleWhileStatement(statement.whileStatement()));
        } else if (statement.let() != null) {
            output.append(handleLet(statement.let()));
        } else if (statement.unOperation() != null) {
            output.append(handleUnOperation(statement.unOperation()));
        } else if (statement.binaryOperation() != null) {
            output.append(handleBinaryOperation(statement.binaryOperation()));
        } else if (statement.callMethod() != null) {
            output.append(handleCallMethod(statement.callMethod()));
        } else if (statement.newObj() != null) {
            output.append(handleNewObj(statement.newObj()));
        } else if (statement.OBJECT_IDENTIFIER() != null) {
            output.append(statement.OBJECT_IDENTIFIER().getText());
        } else if (statement.varValue() != null) {
            output.append(handleVarValue(statement.varValue()));
        } else if (statement.statement() != null) {
            output.append(handleStatement(statement.statement()));
        }

        return output;
    }

    private StringBuilder handleIfStatement(IfStatementContext ifStatement) {
        StringBuilder output = new StringBuilder();
        output.append("If(");
        output.append(handleStatement(ifStatement.ifStat().statement(0)));


        if (ifStatement.ifStat().statement(1) != null) {
            output.append(", ");
            output.append(handleStatement(ifStatement.ifStat().statement(1)));
        } else if (ifStatement.ifStat().block() != null) {
            output.append(", ");
            output.append(handleBlock(ifStatement.ifStat().block()));
        }

        if (ifStatement.elseStat() != null) {
            output.append(", ");
            if (ifStatement.elseStat().statement() != null) {
                output.append(handleStatement(ifStatement.elseStat().statement()));
            } else if (ifStatement.elseStat().block() != null) {
                output.append(handleBlock(ifStatement.elseStat().block()));
            }
        }

        output.append(")");
        output.append(" : bool");
        //output.append(checkIfStatementType(ifStatement, null,false));

        return output;
    }

    private StringBuilder handleWhileStatement(WhileStatementContext whileStatement) {
        StringBuilder output = new StringBuilder();
        output.append("While(");
        output.append(handleStatement(whileStatement.statement(0)));


        if (whileStatement.statement(1) != null) {
            output.append(", ");
            output.append(handleStatement(whileStatement.statement(1)));
        } else if (whileStatement.block() != null) {
            output.append(", ");
            output.append(handleBlock(whileStatement.block()));
        }

        output.append(") : unit");
        return output;
    }

    private StringBuilder handleAssign(AssignContext assign) {
        StringBuilder output = new StringBuilder();
        output.append("Assign(");
        output.append(assign.OBJECT_IDENTIFIER().getText());
        output.append(", ");

        if (assign.statement() != null) {
            output.append(handleStatement(assign.statement()));
        }

        output.append(")");
        return output;
    }

    private StringBuilder handleLet(LetContext let) {
        StringBuilder output = new StringBuilder();
        output.append("Let(");
        output.append(let.OBJECT_IDENTIFIER().getText());
        output.append(", ");
        output.append(let.varType().getText());
        output.append(", ");

        int statOffset = 0;
        if (let.statement().size() == 2 || (let.block() != null && let.statement().size() == 1)) {
            output.append(handleStatement(let.statement(statOffset++)));
            output.append(", ");
        }

        if (let.block() != null) {
            output.append(handleBlock(let.block()));
        } else {
            output.append(handleStatement(let.statement(statOffset)));
        }


        output.append(") : " + let.varType().getText());
        return output;
    }

    private StringBuilder handleUnOperation(UnOperationContext unOp) {
        StringBuilder output = new StringBuilder();
        output.append("UnOp(");
        output.append(unOp.unOperator().getText());
        output.append(", ");

        if (unOp.statement() != null)
            output.append(handleStatement(unOp.statement()));
        //else if (unOp.condition() != null)
        //    output.append(handleCondition(unOp.condition()));

        output.append(")");

        return output;
    }

    private StringBuilder handleNewObj(NewObjContext obj) {
        StringBuilder output = new StringBuilder();
        output.append("New(");
        output.append(obj.TYPE_IDENTIFIER().getText());
        output.append(")");

        return output;
    }

    private StringBuilder handleCallMethod(CallMethodContext call) {
        StringBuilder output = new StringBuilder();

        if (!(call.parent.parent instanceof BlockContext) && call.singleCallMethod().size() > 1) {
            output.append("[");
        }

        for (int i = 0; i < call.singleCallMethod().size(); i++) {
            output.append(handleSingleCallMethod(call.singleCallMethod(i)));
            output.append(", ");
        }
        output.delete(output.length()-2, output.length());

        if (!(call.parent.parent instanceof BlockContext) && call.singleCallMethod().size() > 1) {
            output.append("]");
        }

        return output;
    }

    private StringBuilder handleSingleCallMethod(SingleCallMethodContext singleCall) {
        StringBuilder output = new StringBuilder();

        for (int i = singleCall.callFunction().size()-1; i >= 0 ; i--) {
            output.append("Call(");
        }

        if (singleCall.caller().size() == 0) {
            output.append("self, ");
        }
        else {
            for (int i = 0; i < singleCall.caller().size() ; i++) {
                output.append(handleCaller(singleCall.caller(i)) + ".");
            }

            output.delete(output.length()-1, output.length());
            output.append(", ");
        }

        for (int i = 0; i < singleCall.callFunction().size() ; i++) {
            output.append(handleCallFunction(singleCall.callFunction(i)));
            output.append("), ");
        }
        output.delete(output.length()-2, output.length());

        return output;
    }

    private StringBuilder handleCallFunction(CallFunctionContext callFunc) {
        StringBuilder output = new StringBuilder();

        output.append(callFunc.OBJECT_IDENTIFIER().getText());
        output.append(", [");

        for (ArgumentContext arg : callFunc.argument()) {
            output.append(handleArgument(arg));
            output.append(", ");
        }

        if (callFunc.argument().size() > 0) output.delete(output.length()-2, output.length());
        output.append("]");

        return output;
    }

    private StringBuilder handleCaller(CallerContext caller) {
        StringBuilder output = new StringBuilder();

        if (caller.newObj() != null) {
            output.append(handleNewObj(caller.newObj()));
        } else if (caller.OBJECT_IDENTIFIER() != null) {
            output.append(caller.OBJECT_IDENTIFIER().getText());
        }

        return output;
    }

    private StringBuilder handleArgument(ArgumentContext arg) {
        StringBuilder output = new StringBuilder();

        if (arg.callMethod() != null) {
            output.append(handleCallMethod(arg.callMethod()));
        } else if (arg.newObj() != null) {
            output.append(handleNewObj(arg.newObj()));
        } else if (arg.OBJECT_IDENTIFIER() != null) {
            output.append(arg.OBJECT_IDENTIFIER().getText());
        } else if (arg.varValue() != null) {
            output.append(arg.varValue().getText());
        }  else if (arg.binaryOperation() != null) {
            output.append(handleBinaryOperation(arg.binaryOperation()));
        }

        return output;
    }

    private StringBuilder handleBinaryOperation(BinaryOperationContext binOp) {
        StringBuilder output = new StringBuilder();

        if (binOp.condition().size() == 1) {
            output.append(handleCondition(binOp.condition(0)));
        } else {

            for (int i = binOp.AND_OPERATOR().size()-1 ; i >= 0; i--) {
                output.append("BinOp(");
                output.append(binOp.AND_OPERATOR(i).getText());
                output.append(", ");
            }

            output.append(handleCondition(binOp.condition(0)));

            for (int j = 1 ; j < binOp.AND_OPERATOR().size(); j++) {
                output.append(", ");
                output.append(handleCondition(binOp.condition(j)));
                output.append(") : bool");
            }

            output.append(", ");
            output.append(handleCondition(binOp.condition(binOp.AND_OPERATOR().size())));
            output.append(") : bool");
        }

        return output;
    }

    private StringBuilder handleCondition(ConditionContext cond) {
        StringBuilder output = new StringBuilder();

        if (cond.term().size() == 1) {
            output.append(handleTerm(cond.term(0)));
        } else {

            for (int i = cond.CONDITIONAL_OPERATOR().size()-1 ; i >= 0; i--) {
                output.append("BinOp(");
                output.append(cond.CONDITIONAL_OPERATOR(i).getText());
                output.append(", ");
            }

            output.append(handleTerm(cond.term(0)));

            for (int j = 1 ; j < cond.CONDITIONAL_OPERATOR().size(); j++) {
                output.append(", ");
                output.append(handleTerm(cond.term(j)));
                output.append(") : bool");
            }

            output.append(", ");
            output.append(handleTerm(cond.term(cond.CONDITIONAL_OPERATOR().size())));
            output.append(") : bool");
        }

        return output;
    }

    private StringBuilder handleTerm(TermContext term) {
        StringBuilder output = new StringBuilder();

        if (term.factor().size() == 1) {
            output.append(handleFactor(term.factor(0)));
        } else {
            for (int i = term.termOperator().size()-1 ; i >= 0; i--) {
                output.append("BinOp(");
                output.append(term.termOperator(i).getText());
                output.append(", ");
            }

            output.append(handleFactor(term.factor(0)));

            for (int j = 1 ; j < term.termOperator().size(); j++) {
                output.append(", ");
                output.append(handleFactor(term.factor(j)));
                output.append(") : int32");
            }

            output.append(", ");
            output.append(handleFactor(term.factor(term.termOperator().size())));
            output.append(") : int32");
        }

        return output;
    }

    private StringBuilder handleFactor(FactorContext factor) {
        StringBuilder output = new StringBuilder();

        if (factor.value().size() == 1) {
            output.append(handleValue(factor.value(0)));
        } else {

            for (int i = factor.FACTOR_OPERATOR().size()-1 ; i >= 0; i--) {
                output.append("BinOp(");
                output.append(factor.FACTOR_OPERATOR(i).getText());
                output.append(", ");
            }

            output.append(handleValue(factor.value(0)));

            for (int j = 1 ; j < factor.FACTOR_OPERATOR().size(); j++) {
                output.append(", ");
                output.append(handleValue(factor.value(j)));
                output.append(") : int32");
            }

            output.append(", ");
            output.append(handleValue(factor.value(factor.FACTOR_OPERATOR().size())));
            output.append(") : int32");
        }

        return output;
    }

    private StringBuilder handleValue(ValueContext value) {
        StringBuilder output = new StringBuilder();

        if (value.unOperation() != null)
            output.append(handleUnOperation(value.unOperation()));
        else if (value.callMethod() != null)
            output.append(handleCallMethod(value.callMethod()));
        else if (value.varValue() != null)
            output.append(handleVarValue(value.varValue()));
        else
            output.append(value.getChild(0).getText());

        return output;
    }

    private StringBuilder handleVarValue(VarValueContext varValue) {
        StringBuilder output = new StringBuilder();
        output.append(varValue.getText());

        if (varValue.STRING() != null)
            output.append(" : string");
        else if (varValue.integer() != null)
            output.append(" : int32");
        else if (varValue.VOID_OPERATOR() != null)
            output.append(" : unit");
        else
            output.append(" : bool");

        return output;
    }

    private StringBuilder handleObjectIdentifier(ValueContext value) {
        StringBuilder output = new StringBuilder();


        return output;
    }

//endregion

}
