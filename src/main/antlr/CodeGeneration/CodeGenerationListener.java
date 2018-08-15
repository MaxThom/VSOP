package CodeGeneration;


import VSOP.CodeGeneration.CODEBaseListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static VSOP.CodeGeneration.CODEParser.*;

public class CodeGenerationListener extends CODEBaseListener {


    private Map<String, ClassDefinition> classes;
    private ClassDefinition currentClass;
    private String fileName;

    public StringBuilder llvmOutput;
    public ArrayList<String> errorOutput;



    public CodeGenerationListener(String fileName) {
        classes = new HashMap<>();
        errorOutput = new ArrayList<>();
        currentClass = null;
        this.fileName = fileName;
        llvmOutput = new StringBuilder();
    }

    public void addLibrary(ClassDefinition newClass) {
        classes.put(newClass.name, newClass);
    }

    @Override
    public void exitProgram(ProgramContext ctx) {
        //System.out.println(ctx.getText());

        generateProgram(ctx);
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
                //if (methodDef.formals.containsKey(formalDef.name)) {
                //    errorOutput.add(fileName + ":" + formal.getStart().getLine() + ":" + (formal.getStart().getCharPositionInLine()+1) + ":" + " semantic error - formal '" + formalDef.name + "' is already defined.");
               // }
                //else
                    methodDef.formals.put(formalDef.name, formalDef);
            }

            // Check for same method name
            //if (classDef.methods.containsKey(methodDef.name)) {
            //    errorOutput.add(fileName + ":" + method.getStart().getLine() + ":" + (method.getStart().getCharPositionInLine()+1) + ":" + " semantic error - method '" + methodDef.name + "' is already defined.");
            //}
           // else
                classDef.methods.put(methodDef.name, methodDef);
        }

        for (FieldContext field: fields) {

            FieldDefinition fieldDef = new FieldDefinition(field.OBJECT_IDENTIFIER().getText(), field.varType().getText());

            // Check for same field name
          //  if (classDef.fields.containsKey(fieldDef.name)) {
            //    errorOutput.add(fileName + ":" + field.getStart().getLine() + ":" + (field.getStart().getCharPositionInLine()+1) + ":" + " semantic error - field '" + fieldDef.name + "' is already defined.");
           // }
           //else
                classDef.fields.put(fieldDef.name, fieldDef);
        }


        // Check for same class name
        //if (classes.containsKey(classDef.name)) {
         //   errorOutput.add(fileName + ":" + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine()+1) + ":" + " semantic error - class '" + classDef.name + "' is already defined.");
       // }
        //else
            classes.put(classDef.name, classDef);
    }

//region GENERATE_LLVM

    private void generateProgram(ProgramContext ctx) {

    }

//endregion

}
