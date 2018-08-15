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
        llvmOutput.append("@.printInt = private constant [3 x i8] c\"%d\\00\"\n" +
                "@.printStr = private constant [3 x i8] c\"%s\\00\"\n" +
                "@.printlnInt = private constant [4 x i8] c\"%d\\0A\\00\"\n" +
                "@.printlnStr = private constant [4 x i8] c\"%s\\0A\\00\"\n" +
                "\n" +
                "declare i32 @printf(i8*, ...)\n" +
                "\n" +
                "define i32 @main() {\n" +
                "    entry:\n" +
                "        %x = alloca i32\n" +
                "        store i32 0, i32* %x\n" +
                "\n" +
                "        %x_load = load i32, i32* %x\n" +
                "        %cond = icmp ne i32 %x_load, 5\n" +
                "        br i1 %cond, label %while, label %end_while\n" +
                "\n" +
                "\n" +
                "    while:\n" +
                "        %x2_load = load i32, i32* %x\n" +
                "        %x2_add = add i32 1, %x2_load\n" +
                "        store i32 %x2_add, i32* %x\n" +
                "        call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.printlnInt, i32 0, i32 0), i32 %x2_add)\n" +
                "\n" +
                "        %cond2 = icmp ne i32 %x2_add, 5        \n" +
                "        br i1 %cond2, label %while, label %end_while\n" +
                "        \n" +
                "\n" +
                "    end_while:\n" +
                "        %str2 = alloca [10 x i8]\n" +
                "        store [10 x i8] c\"end while\\00\", [10 x i8]* %str2\n" +
                "        %tmp2 = bitcast [10 x i8]* %str2 to i8*\n" +
                "        call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.printlnStr, i32 0, i32 0), i8* %tmp2)\n" +
                "        br label %end\n" +
                "\n" +
                "\n" +
                "    end:\n" +
                "        ret i32 0\n" +
                "}");
    }

//endregion

}
