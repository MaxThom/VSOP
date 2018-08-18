package CodeGeneration;


import VSOP.CodeGeneration.CODEBaseListener;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

import static VSOP.CodeGeneration.CODEParser.*;

public class CodeGenerationListener extends CODEBaseListener {


    private Map<String, ClassDefinition> classes;
    private ClassDefinition currentClass;
    private String fileName;
    private int lastInstructionId;
    private int lastGotoId;

    public StringBuilder llvmOutput;
    private StringBuilder indents;
    public ArrayList<String> errorOutput;



    public CodeGenerationListener(String fileName) {
        classes = new HashMap<>();
        errorOutput = new ArrayList<>();
        currentClass = null;
        this.fileName = fileName;
        llvmOutput = new StringBuilder();
        indents = new StringBuilder();
        addLibrary(addIOClasses());
    }

    public void addLibrary(ClassDefinition newClass) {
        classes.put(newClass.name, newClass);
    }

    private static ClassDefinition addIOClasses() {
        ClassDefinition ioClass = new ClassDefinition("IO", "Object");
        ioClass.isManuallyGenerated = true;
        ioClass.classInitialized = true;

        // READ
        MethodDefinition print = new MethodDefinition("print", "IO");
        print.formals.put("s", new FormalDefinition("s", "string", 0));
        ioClass.methods.put(print.name, print);

        MethodDefinition printBool = new MethodDefinition("printBool", "IO");
        printBool.formals.put("b", new FormalDefinition("b", "bool", 0));
        ioClass.methods.put(printBool.name, printBool);

        MethodDefinition printInt32 = new MethodDefinition("printInt32", "IO");
        printInt32.formals.put("i", new FormalDefinition("i", "int32", 0));
        ioClass.methods.put(printInt32.name, printInt32);

        MethodDefinition printlnInt32 = new MethodDefinition("printlnInt32", "IO");
        printlnInt32.formals.put("i", new FormalDefinition("i", "int32", 0));
        ioClass.methods.put(printlnInt32.name, printlnInt32);

        MethodDefinition printlnBool = new MethodDefinition("printlnBool", "IO");
        printlnBool.formals.put("b", new FormalDefinition("b", "bool", 0));
        ioClass.methods.put(printlnBool.name, printlnBool);

        MethodDefinition println = new MethodDefinition("println", "IO");
        println.formals.put("s", new FormalDefinition("s", "string", 0));
        ioClass.methods.put(println.name, println);

        // WRITE
        MethodDefinition inputLine = new MethodDefinition("inputLine", "string");
        ioClass.methods.put(inputLine.name, inputLine);

        MethodDefinition inputBool = new MethodDefinition("inputBool", "bool");
        ioClass.methods.put(inputBool.name, inputBool);

        MethodDefinition inputInt32 = new MethodDefinition("inputInt32", "int32");
        ioClass.methods.put(inputInt32.name, inputInt32);

        return ioClass;
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
                methodDef.formals.put(formalDef.name, formalDef);
            }

            classDef.methods.put(methodDef.name, methodDef);
        }

        int fieldPos = 1;
        for (FieldContext field: fields) {
            FieldDefinition fieldDef = new FieldDefinition(field.OBJECT_IDENTIFIER().getText(), field.varType().getText(), fieldPos++);
            classDef.fields.put(fieldDef.name, fieldDef);
        }

        classes.put(classDef.name, classDef);
    }

//region GENERATE_LLVM

    private void generateProgram(ProgramContext ctx) {
        generateHeader();
        generateStructuresFromClasses();

        for (ClassDefinitionContext classDef : ctx.classDefinition()) {
                currentClass = classes.get(classDef.TYPE_IDENTIFIER(0).getText());
                appendSectionHeader(classDef.TYPE_IDENTIFIER(0).getText().toUpperCase());
                generateStructuresAllocationFromClass(classDef);
                generateStructuresInitializerFromClass(classDef);
                generateMethodsFromClass(classDef);
                llvmOutput.append(indents).append("\n");
        }

        generateIOClass();
    }

    private void generateHeader() {
        llvmOutput.append("; ModuleID = '").append(fileName).append("'\n");
        //llvmOutput.append("source_filename = \"").append(fileName).append("\"\n\n");

        appendSectionHeader("DECLARATION");
        llvmOutput.append("declare noalias i8* @malloc(i64) #1").append("\n");
        llvmOutput.append("declare i32 @printf(i8*, ...)").append("\n");
        llvmOutput.append("declare double @pow(double, double) #1").append("\n");
        llvmOutput.append("declare i32 @strcmp(i8*, i8*) #1").append("\n");
        llvmOutput.append("declare i32 @__isoc99_scanf(i8*, ...) #1");
        llvmOutput.append("declare void @exit(i32) #1");
        llvmOutput.append("@.str.empty = private unnamed_addr constant [1 x i8] zeroinitializer, align 1").append("\n");

        llvmOutput.append("\n");
    }

    private void generateIOClass() {
        appendSectionHeader("IO Class\n");

        llvmOutput.append(indents).append("; Allocation\n" +
                "define %struct.IO* @IO_new() #0 {\n" +
                "\t%1 = alloca %struct.IO*\n" +
                "\t%2 = call noalias i8* @malloc(i64 0) #3\n" +
                "\t%3 = bitcast i8* %2 to %struct.IO*\n" +
                "\tstore %struct.IO* %3, %struct.IO** %1\n" +
                "\t%4 = load %struct.IO*, %struct.IO** %1\n" +
                "\tret %struct.IO* %4\n" +
                "}").append("\n\n");

        llvmOutput.append(indents).append("; Initializer\ndefine void @IO_init(%struct.IO*) #0 { ret void }").append("\n\n");

        llvmOutput.append(indents).append("@IO.printInt = private constant [3 x i8] c\"%d\\00\"").append("\n");
        llvmOutput.append(indents).append("@IO.printStr = private constant [3 x i8] c\"%s\\00\"").append("\n");
        llvmOutput.append(indents).append("@IO.printBool = private constant [3 x i8] c\"%d\\00\"").append("\n");
        llvmOutput.append(indents).append("@IO.printlnInt = private constant [4 x i8] c\"%d\\0A\\00\"").append("\n");
        llvmOutput.append(indents).append("@IO.printlnStr = private constant [4 x i8] c\"%s\\0A\\00\"").append("\n");
        llvmOutput.append(indents).append("@IO.printlnBool = private constant [4 x i8] c\"%d\\0A\\00\"").append("\n");
        llvmOutput.append(indents).append("@IO.inputInt = private constant [3 x i8] c\"%d\\00\"").append("\n");
        llvmOutput.append(indents).append("@IO.inputStr = private constant [3 x i8] c\"%s\\00\"").append("\n");
        llvmOutput.append("\n");

        llvmOutput.append(indents).append("define %struct.IO* @printInt32(%struct.IO*, i32) {\n" +
                "\t%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @IO.printInt, i32 0, i32 0), i32 %1)\n" +
                "\tret %struct.IO* %0\n" +
                "}").append("\n");
        llvmOutput.append(indents).append("define %struct.IO* @printBool(%struct.IO*, i1) {\n" +
                "\t%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @IO.printBool, i32 0, i32 0), i1 %1)\n" +
                "\tret %struct.IO* %0\n" +
                "}").append("\n");
        llvmOutput.append(indents).append("define %struct.IO* @print(%struct.IO*, i8*) {\n" +
                "\t%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @IO.printStr, i32 0, i32 0), i8* %1)\n" +
                "\tret %struct.IO* %0\n" +
                "}").append("\n");
        llvmOutput.append(indents).append("define %struct.IO* @printlnInt32(%struct.IO*, i32) {\n" +
                "\t%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @IO.printlnInt, i32 0, i32 0), i32 %1)\n" +
                "\tret %struct.IO* %0\n" +
                "}").append("\n");
        llvmOutput.append(indents).append("define %struct.IO* @printlnBool(%struct.IO*, i1) {\n" +
                "\t%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @IO.printlnBool, i32 0, i32 0), i1 %1)\n" +
                "\tret %struct.IO* %0\n" +
                "}").append("\n");
        llvmOutput.append(indents).append("define %struct.IO* @println(%struct.IO*, i8*) {\n" +
                "\t%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @IO.printlnStr, i32 0, i32 0), i8* %1)\n" +
                "\tret %struct.IO* %0\n" +
                "}").append("\n");

        llvmOutput.append(indents).append("define i32 @inputInt32(%struct.IO*) {\n" +
                "    %2 = alloca i32, align 4\n" +
                "    %3 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @IO.inputInt, i32 0, i32 0), i32* %2)\n" +
                "    %4 = load i32, i32* %2\n" +
                "\n" +
                "    %5 = icmp eq i32 %3, 0\n" +
                "    br i1 %5, label %exit, label %end\n" +
                "\n" +
                "    exit:\n" +
                "        %msg = alloca [40 x i8]\n" +
                "        store [40 x i8] c\"Error : invalid input. Expecting int32.\\00\", [40 x i8]* %msg\n" +
                "        %loadedMsg = bitcast [40 x i8]* %msg to i8*\n" +
                "        call %struct.IO* @println(%struct.IO* %0, i8* %loadedMsg)\n" +
                "        call void @exit(i32 1) #3\n" +
                "        br label %end\n" +
                "\n" +
                "    end:\n" +
                "\t    ret i32 %4\n" +
                "}").append("\n");
        llvmOutput.append(indents).append("define i1 @inputBool(%struct.IO*) {\n" +
                "    %2 = alloca i32, align 4\n" +
                "    %3 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @IO.inputInt, i32 0, i32 0), i32* %2)\n" +
                "    %4 = load i32, i32* %2\n" +
                "\n" +
                "    %5 = icmp eq i32 %3, 0\n" +
                "    br i1 %5, label %exit, label %end\n" +
                "\n" +
                "    exit:\n" +
                "        %msg = alloca [49 x i8]\n" +
                "        store [49 x i8] c\"Error : invalid input. Expecting boolean 1 or 0.\\00\", [49 x i8]* %msg\n" +
                "        %loadedMsg = bitcast [49 x i8]* %msg to i8*\n" +
                "        call %struct.IO* @println(%struct.IO* %0, i8* %loadedMsg)\n" +
                "        call void @exit(i32 1) #3\n" +
                "        br label %end\n" +
                "\n" +
                "    end:\n" +
                "        %7 = icmp ne i32 %4, 0\n" +
                "\t    ret i1 %7\n" +
                "}").append("\n");
        llvmOutput.append(indents).append("define i8* @inputLine(%struct.IO*) {\n" +
                "    %2 = alloca i8*\n" +
                "    %3 = load i8*, i8** %2\n" +
                "    \n" +
                "    %4 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @IO.inputStr, i32 0, i32 0), i8* %3)\n" +
                "    %5 = load i8*, i8** %2\n" +
                "\n" +
                "    ret i8* %5\n" +
                "}\n").append("\n");

        llvmOutput.append("\n");
    }

    private void generateStructuresFromClasses() {
        appendSectionHeader("STRUCTURES");

        // Add object structure
        llvmOutput.append(indents).append("%struct.").append("Object").append(" = type { }\n");

        for (ClassDefinition cl: classes.values()) {
            //if (!cl.isManuallyGenerated) {
            //llvmOutput.append(indents).append("%struct.IO = type { }").append("\n\n");
                llvmOutput.append(indents).append("%struct.").append(cl.name).append(" = type {\n");

                if (!cl.extend.equals("Object"))
                    llvmOutput.append(indents).append("\t%struct.").append(cl.extend).append(",\n");
                else
                    llvmOutput.append(indents).append("\t%struct.").append("Object").append(",\n");

                List<FieldDefinition> fields = new ArrayList<>(cl.fields.values());
                Collections.sort(fields, Comparator.comparingInt(FieldDefinition::getPosition));
                for (FieldDefinition field : fields) {
                    llvmOutput.append(indents).append("\t").append(vsopTypeToLlvmType(field.type)).append(",\n");

                }
                llvmOutput.delete(llvmOutput.length() - 2, llvmOutput.length());
                llvmOutput.append(indents).append("\n}\n");
           // }
        }

        llvmOutput.append(indents).append("\n");
    }

    private void generateStructuresAllocationFromClass(ClassDefinitionContext ctx) {
        llvmOutput.append(indents).append("\n; Allocation\n");
        ClassDefinition cl = classes.get(ctx.TYPE_IDENTIFIER(0).getText());

        // TODO : Add Alignment
        llvmOutput.append(indents).append("define %struct.").append(cl.name).append("* @").append(cl.name).append("_new() #0 {\n");
        llvmOutput.append(indents).append("\t").append("%size_as_ptr = getelementptr %struct.").append(cl.name).append(", %struct.").append(cl.name).append("* null, i32 1").append("\n");
        llvmOutput.append(indents).append("\t").append("%size_as_i64 = ptrtoint %struct.").append(cl.name).append("* %size_as_ptr to i64").append("\n\n");
        llvmOutput.append(indents).append("\t").append("%1 = alloca %struct.").append(cl.name).append("*").append("\n");
        llvmOutput.append(indents).append("\t").append("%2 = call noalias i8* @malloc(i64 %size_as_i64) #3").append("\n");
        llvmOutput.append(indents).append("\t").append("%3 = bitcast i8* %2 to %struct.").append(cl.name).append("*").append("\n");
        llvmOutput.append(indents).append("\t").append("store %struct.").append(cl.name).append("* %3, %struct.").append(cl.name).append("** %1").append("\n\n");
        llvmOutput.append(indents).append("\t").append("%4 = load %struct.").append(cl.name).append("*, %struct.").append(cl.name).append("** %1").append("\n");
        llvmOutput.append(indents).append("\t").append("call void @").append(cl.name).append("_init(%struct.").append(cl.name).append("* %4)").append("\n\n");
        llvmOutput.append(indents).append("\t").append("%5 = load %struct.").append(cl.name).append("*, %struct.").append(cl.name).append("** %1").append("\n");
        llvmOutput.append(indents).append("\t").append("ret %struct.").append(cl.name).append("* %5").append("\n");
        llvmOutput.append(indents).append("}\n");

    }

    private void generateStructuresInitializerFromClass(ClassDefinitionContext ctx) {
        llvmOutput.append(indents).append("\n; Initializer\n");
        ClassDefinition cl = classes.get(ctx.TYPE_IDENTIFIER(0).getText());
        List<FieldContext> fields = ctx.children.stream().filter(x -> x instanceof  FieldContext).map(x -> (FieldContext) x).collect(Collectors.toList());

        llvmOutput.append(indents).append("define void @").append(cl.name).append("_init(%struct.").append(cl.name).append("*) #0 {\n");
        llvmOutput.append(indents).append("\t").append("%2 = alloca %struct.").append(cl.name).append("*").append("\n");
        llvmOutput.append(indents).append("\t").append("store %struct.").append(cl.name).append("* %0, %struct.").append(cl.name).append("** %2").append("\n\n");


        int i = 3, j = 0;
        if (!cl.extend.equals("Object")) {
            llvmOutput.append(indents).append("\t").append("%").append(i).append(" = load %struct.").append(cl.name).append("*, %struct.").append(cl.name).append("** %2").append("\n");
            llvmOutput.append(indents).append("\t").append("%").append(i+1).append(" = getelementptr inbounds %struct.").append(cl.name).append(", %struct.").append(cl.name).append("* %").append(i).append(", i32 0, i32 ").append(j).append("\n");
            llvmOutput.append(indents).append("\t").append("call void @").append(cl.extend).append("_init(%struct.").append(cl.extend).append("* %").append(i+1).append(")").append("\n\n");
            i += 2;
        }
        this.lastInstructionId = i-1;
        j = 1;
        for (FieldContext field : fields) {
            int whereToStore = ++lastInstructionId;
            llvmOutput.append(indents).append("\t").append("%").append(whereToStore).append(" = load %struct.").append(cl.name).append("*, %struct.").append(cl.name).append("** %2").append("\n");
            llvmOutput.append(indents).append("\t").append("%").append(++lastInstructionId).append(" = getelementptr inbounds %struct.").append(cl.name).append(", %struct.").append(cl.name).append("* %").append(lastInstructionId-1).append(", i32 0, i32 ").append(j).append("\n");
            //if (isPrimitive(field.type))
            ArrayList<Map<String, VariableDefinition>> variablesCache = new ArrayList<>();
            variablesCache.add(new HashMap<>());
            if (field.statement() != null) {
                this.indents.append("\t");
                variablesCache.add(new HashMap<>());
                generateStatement(field.statement(), variablesCache);
                variablesCache.remove(variablesCache.size()-1);
                llvmOutput.append(indents).append("store ").append(vsopTypeToLlvmType(field.varType().getText())).append(" %").append(lastInstructionId).append(", ").append(vsopTypeToLlvmType(field.varType().getText())).append("* %").append(whereToStore+1).append("\n\n");
                this.indents.delete(this.indents.length()-1, this.indents.length());
            } else if (field.block() != null) {
                generateBlock(field.block(), variablesCache);
            } else
                llvmOutput.append(indents).append("\t").append("store ").append(vsopTypeToLlvmType(field.varType().getText())).append(" ").append(getDefaultValue(field.varType().getText())).append(", ").append(vsopTypeToLlvmType(field.varType().getText())).append("* %").append(whereToStore+1).append("\n\n");

            //else
                //llvmOutput.append(indents).append("\t").append("call void @").append(field.type).append("_init(%struct.").append(field.type).append("* %").append(i+1).append(")").append("\n\n");

            i += 2;
            j += 1;
        }

        llvmOutput.delete(llvmOutput.length()-1, llvmOutput.length());
        llvmOutput.append(indents).append("\n\tret void\n}\n");

    }

    private void generateMethodsFromClass(ClassDefinitionContext ctx) {
        List<MethodDefinitionContext> methods = ctx.children.stream().filter(x -> x instanceof  MethodDefinitionContext).map(x -> (MethodDefinitionContext) x).collect(Collectors.toList());
        String classType = ctx.TYPE_IDENTIFIER(0).getText();

        for (MethodDefinitionContext method: methods) {
            ArrayList<Map<String, VariableDefinition>> variablesCache = new ArrayList<>();
            llvmOutput.append(indents).append("\n; Method ").append(method.OBJECT_IDENTIFIER()).append("\n");
            llvmOutput.append(indents).append("define ").append(vsopTypeToLlvmType(method.varType().getText())).append(" @").append(method.OBJECT_IDENTIFIER()).append("(");


            // Add Fields
            /*variablesCache.add(new HashMap<>());
            ClassDefinition classToCheck = currentClass;
            while (true) {
                for (FieldDefinition field : classToCheck.fields.values()) {
                    variablesCache.get(variablesCache.size()-1).put(field.name, new VariableDefinition(field.name, "%struct.".concat(classToCheck.name), field.type));
                }
                if (classToCheck.extend.equals("Object"))
                    break;
                if (classes.containsKey(classToCheck.extend))
                    classToCheck = classes.get(classToCheck.extend);
                else
                    break;

            }*/

            // Add self structure
            llvmOutput.append(indents).append(vsopTypeToLlvmType(classType)).append(", ");

            // Formals
            variablesCache.add(new HashMap<>());
            List<FormalDefinition> formals = new ArrayList<>(currentClass.methods.get(method.OBJECT_IDENTIFIER().getText()).formals.values());
            Collections.sort(formals, Comparator.comparingInt(FormalDefinition::getPosition));
            for (FormalDefinition formal : formals) {
                llvmOutput.append(indents).append(vsopTypeToLlvmType(formal.type)).append(", ");
            }
            llvmOutput.delete(llvmOutput.length()-2, llvmOutput.length());
            llvmOutput.append(indents).append(") #0 {\n");

            if (method.block() != null) {
                this.indents.append("\t");
                this.lastInstructionId = formals.size()+1;
                this.lastGotoId = 0;

                // Add self structure
                llvmOutput.append(indents).append("; Formals\n");
                llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = alloca ").append(vsopTypeToLlvmType(classType)).append("\n");
                if (classType.equals("Main") && method.OBJECT_IDENTIFIER().getText().equals("main")) {
                    // If main, add initializer else it's already created with the new before the call
                    llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = call ").append(vsopTypeToLlvmType(classType)).append(" @").append(classType).append("_new()\n");
                    llvmOutput.append(indents).append("store ").append(vsopTypeToLlvmType(classType)).append(" %").append(lastInstructionId).append(", ").append(vsopTypeToLlvmType(classType)).append("* %").append(lastInstructionId - 1).append("\n");
                    variablesCache.get(variablesCache.size()-1).put("self", new VariableDefinition("self", "%".concat(String.valueOf(lastInstructionId-1)), classType, ""));
                } else {
                    llvmOutput.append(indents).append("store ").append(vsopTypeToLlvmType(classType)).append(" %0").append(", ").append(vsopTypeToLlvmType(classType)).append("* %").append(lastInstructionId).append("\n");
                    variablesCache.get(variablesCache.size()-1).put("self", new VariableDefinition("self", "%".concat(String.valueOf(lastInstructionId)), classType, ""));
                }


                // Add formals as first instructions
                for (FormalDefinition formal : formals) {
                    llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = alloca ").append(vsopTypeToLlvmType(formal.type)).append("\n");
                    llvmOutput.append(indents).append("store ").append(vsopTypeToLlvmType(formal.type)).append(" %".concat(String.valueOf(formal.position+1))).append(", ").append(vsopTypeToLlvmType(formal.type)).append("* %").append(lastInstructionId).append("\n");
                    variablesCache.get(variablesCache.size()-1).put(formal.name, new VariableDefinition(formal.name, "%".concat(String.valueOf(lastInstructionId)), formal.type, ""));
                }
                llvmOutput.append(indents).append("\n");

                this.indents.delete(this.indents.length()-1, this.indents.length());
                generateBlock(method.block(), variablesCache);
            }

            llvmOutput.append(indents).append("\tret ").append(vsopTypeToLlvmType(method.varType().getText())).append(" %").append(lastInstructionId).append("\n");
            llvmOutput.append(indents).append("}\n");
        }

    }

    private void generateBlock(BlockContext ctx, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        this.indents.append("\t");

        variablesCache.add(new HashMap<>());

        for (int i = 0; i < ctx.children.size()-2 ; i++) {
            if (ctx.children.get(i) instanceof ParserRuleContext) {
                ParserRuleContext child = (ParserRuleContext) ctx.children.get(i);

                if (child instanceof BlockContext) {
                    generateBlock((BlockContext) child, variablesCache);
                } else if (child instanceof IfStatementContext) {
                    generateIfStatement((IfStatementContext) child, variablesCache);
                } else if (child instanceof WhileStatementContext) {
                    generateWhileStatement((WhileStatementContext) child, variablesCache);
                } else if (child instanceof StatementContext) {
                    generateStatement((StatementContext) child, variablesCache);
                }
            }
        }

        // Check last statement
        for (int i = ctx.children.size()-1; i >= 0 ; i--) {
            if (ctx.children.get(i) instanceof ParserRuleContext) {
                ParserRuleContext child = (ParserRuleContext) ctx.children.get(i);

                if (child instanceof BlockContext) {
                    generateBlock((BlockContext) child, variablesCache);
                } else if (child instanceof StatementContext) {
                    generateStatement((StatementContext) child, variablesCache);
                }

                break;
            }
        }

        variablesCache.remove(variablesCache.size()-1);
        this.indents.delete(this.indents.length()-1, this.indents.length());
    }

    private VariableDefinition generateStatement(StatementContext ctx, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        if (ctx.assign() != null) {
            generateAssign(ctx.assign(), variablesCache);
        } else if (ctx.ifStatement() != null) {
            return generateIfStatement(ctx.ifStatement(), variablesCache);
        } else if (ctx.whileStatement() != null) {
            generateWhileStatement(ctx.whileStatement(), variablesCache);
        } else if (ctx.let() != null) {
            generateLet(ctx.let(), variablesCache);
        } else if (ctx.binaryOperation() != null) {
            return generateBinaryOperation(ctx.binaryOperation(), variablesCache);
        } else if (ctx.callMethod() != null) {
            generateCallMethod(ctx.callMethod(), variablesCache); // TODO
        } else if (ctx.newObj() != null) {
            return generateNewObj(ctx.newObj(), variablesCache);
        } else if (ctx.OBJECT_IDENTIFIER() != null) {
            return generateObjectIdentifier(ctx.OBJECT_IDENTIFIER(), variablesCache);
        } else if (ctx.statement() != null) {
            return generateStatement(ctx.statement(), variablesCache);
        } else if (ctx.varValue() != null) {
            return generateVarValue(ctx.varValue(), variablesCache);
        }

        return new VariableDefinition("", "", "", "");
    }

    private VariableDefinition generateIfStatement(IfStatementContext ctx, ArrayList<Map<String, VariableDefinition>> variablesCache) {

        int ifGoto = ++lastGotoId;
        llvmOutput.append(indents).append("; If\n");
        if (ctx.ifStat().statement(0) != null) {
            generateStatement(ctx.ifStat().statement(0), variablesCache);
            llvmOutput.append(indents).append("br i1 %").append(lastInstructionId).append(", label %condIf").append(ifGoto);
            if (ctx.elseStat() != null) {
                llvmOutput.append(", label %condElse").append(ifGoto);
            } else {
                llvmOutput.append(", label %condEnd").append(ifGoto);
            }
            llvmOutput.append(indents).append("\n\n");
        }


        // Get If branch type
        variablesCache.add(new HashMap<>());
        llvmOutput.append(indents).append("condIf").append(ifGoto).append(":").append("\n");

        if (ctx.ifStat().statement(1) != null) {
            this.indents.append("\t");
            generateStatement(ctx.ifStat().statement(1), variablesCache);
            this.indents.delete(this.indents.length()-1, this.indents.length());
        } else if (ctx.ifStat().block() != null) {
            generateBlock(ctx.ifStat().block(), variablesCache);
        }
        llvmOutput.append(indents).append("\tbr label %condEnd").append(ifGoto).append("\n\n");
        variablesCache.remove(variablesCache.size()-1);


        // Get Else branch type
        if (ctx.elseStat() != null) {
            variablesCache.add(new HashMap<>());
            llvmOutput.append(indents).append("condElse").append(ifGoto).append(":").append("\n");

            if (ctx.elseStat().statement() != null) {
                this.indents.append("\t");
                generateStatement(ctx.elseStat().statement(), variablesCache);
                this.indents.delete(this.indents.length()-1, this.indents.length());
            } else if (ctx.elseStat().block() != null) {
                 generateBlock(ctx.elseStat().block(), variablesCache);
            }
            llvmOutput.append(indents).append("\tbr label %condEnd").append(ifGoto).append("\n\n");
            variablesCache.remove(variablesCache.size()-1);
        }

        llvmOutput.append(indents).append("condEnd").append(ifGoto).append(":").append("\n");

        return new VariableDefinition("", "", "", "");
    }

    private void generateWhileStatement(WhileStatementContext ctx, ArrayList<Map<String, VariableDefinition>> variablesCache) {

        int whileGoto = ++lastGotoId;
        llvmOutput.append(indents).append("; While\n");

        if (ctx.statement(0) != null) {
            llvmOutput.append(indents).append("br label %whileCond").append(whileGoto).append("\n");
            llvmOutput.append(indents).append("whileCond").append(whileGoto).append(":").append("\n");
            this.indents.append("\t");
            generateStatement(ctx.statement(0), variablesCache);
            llvmOutput.append(indents).append("br i1 %").append(lastInstructionId).append(", label %while").append(whileGoto).append(", label %whileEnd").append(whileGoto).append("\n\n");
            variablesCache.remove(variablesCache.size()-1);
            this.indents.delete(this.indents.length()-1, this.indents.length());
        }

        variablesCache.add(new HashMap<>());
        llvmOutput.append(indents).append("while").append(whileGoto).append(":").append("\n");

        if (ctx.statement(1) != null) {
            this.indents.append("\t");
            generateStatement(ctx.statement(1), variablesCache);
            this.indents.delete(this.indents.length()-1, this.indents.length());
        } else if (ctx.block() != null) {
            generateBlock(ctx.block(), variablesCache);
        }
        llvmOutput.append(indents).append("\tbr label %whileCond").append(whileGoto).append("\n\n");

        variablesCache.remove(variablesCache.size()-1);

        llvmOutput.append(indents).append("whileEnd").append(whileGoto).append(":").append("\n");
    }

    private void  generateLet(LetContext ctx, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        int letId = ++lastInstructionId;
        llvmOutput.append(indents).append("; Let\n");
        llvmOutput.append(indents).append("%").append(letId).append(" = alloca ").append(vsopTypeToLlvmType(ctx.varType().getText())).append("\n");

        // Initializer
        int statOffset = 0;
        if (ctx.statement().size() == 2 || (ctx.statement().size() == 1 && ctx.block() != null)) {
            variablesCache.add(new HashMap<>());
            variablesCache.get(variablesCache.size()-1).put(ctx.OBJECT_IDENTIFIER().getText(), new VariableDefinition(ctx.OBJECT_IDENTIFIER().getText(), "%".concat(String.valueOf(letId)), ctx.varType().getText(), ""));
            generateStatement(ctx.statement(statOffset++), variablesCache);
            variablesCache.remove(variablesCache.size()-1);
        } else
            llvmOutput.append(indents).append("").append("store ").append(vsopTypeToLlvmType(ctx.varType().getText())).append(" ").append(getDefaultValue(ctx.varType().getText())).append(", ").append(vsopTypeToLlvmType(ctx.varType().getText())).append("* %").append(lastInstructionId).append("\n");

        // Body
        variablesCache.add(new HashMap<>());
        variablesCache.get(variablesCache.size()-1).put(ctx.OBJECT_IDENTIFIER().getText(), new VariableDefinition(ctx.OBJECT_IDENTIFIER().getText(), "%".concat(String.valueOf(letId)), ctx.varType().getText(), ""));
        if (ctx.statement(statOffset) != null) {
            generateStatement(ctx.statement(statOffset), variablesCache);
        } else if (ctx.block() != null) {
            generateBlock(ctx.block(), variablesCache);
        }
        variablesCache.remove(variablesCache.size()-1);
        llvmOutput.append(indents).append("\n");
    }

    private void  generateAssign(AssignContext ctx, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        VariableDefinition var = generateObjectIdentifier(ctx.OBJECT_IDENTIFIER(), variablesCache);
        generateStatement(ctx.statement(), variablesCache);

        llvmOutput.append(indents).append("; Assign\n");
        if (!var.name.equals("self"))
            llvmOutput.append(indents).append("store ").append(vsopTypeToLlvmType(var.type)).append(" %").append(lastInstructionId).append(", ").append(vsopTypeToLlvmType(var.type)).append("* %").append(var.aliasAlocated).append("\n");
        else
            llvmOutput.append(indents).append("store ").append(vsopTypeToLlvmType(var.type)).append(" %").append(lastInstructionId).append(", ").append(vsopTypeToLlvmType(var.type)).append("* %").append(Integer.parseInt(var.alias)-1).append("\n");

        llvmOutput.append(indents).append("\n");
    }

    private VariableDefinition generateObjectIdentifier(TerminalNode ctx, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        VariableDefinition var = checkVariableCacheForIdentifier(ctx.getText(), variablesCache);
        String varTypeFinal = var.type;
        String varType = vsopTypeToLlvmType(varTypeFinal);
        llvmOutput.append(indents).append("; ObjectIdentifier\n");
        String name = "";

        if (!isPrimitive(var.type)) {
            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = load ").append(varType).append(", ").append(varType).append("* ").append(var.alias).append("\n");

            FieldDefinition fieldToCheck = null;
            String tmpVarType = var.type;
            do {
                fieldToCheck = classes.get(tmpVarType).fields.get(ctx.getText());
                if (fieldToCheck == null) {
                    tmpVarType = classes.get(tmpVarType).extend;
                    if (tmpVarType.equals("Object") || tmpVarType.equals(""))
                        break;
                    llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = getelementptr inbounds ").append(varType.substring(0, varType.length()-1)).append(", ").append(varType).append(" %").append(lastInstructionId-1).append(", i32 0, i32 ").append(0).append("\n");
                    varTypeFinal = classes.get(tmpVarType).name;
                    varType = vsopTypeToLlvmType(varTypeFinal);
                }
            } while (fieldToCheck == null);


            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = getelementptr inbounds ").append(varType.substring(0, varType.length()-1)).append(", ").append(varType).append(" %").append(lastInstructionId-1).append(", i32 0, i32 ").append(fieldToCheck.position).append("\n");
            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = load ").append(vsopTypeToLlvmType(fieldToCheck.type)).append(", ").append(vsopTypeToLlvmType(fieldToCheck.type)).append("* %").append(lastInstructionId-1).append("\n");
            varTypeFinal = fieldToCheck.type;
            name = "self";
        } else
            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = load ").append(varType).append(", ").append(varType).append("* ").append(var.alias).append("\n");


        llvmOutput.append("\n");
        return new VariableDefinition(name, String.valueOf(lastInstructionId), varTypeFinal, var.alias.substring(1));
    }

    private VariableDefinition generateVarValue(VarValueContext ctx, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        String typeFound = "";
        String text = ctx.getText();

        if (ctx.integer() != null) {
            typeFound = "int32";
        } else if (ctx.STRING() != null) {
            typeFound = "string";
        } else if (ctx.getText().equals("true") || ctx.getText().equals("false")) {
            typeFound = "bool";
        } else if (ctx.VOID_OPERATOR() != null) {
            typeFound = "unit";
        }

        if (ctx.getText().equals("true")) {
            text = "1";
        } else if (ctx.getText().equals("false")) {
            text = "0";
        }

        int varId = ++lastInstructionId;
        llvmOutput.append(indents).append("; VarValue\n");

        if (ctx.STRING() != null) {
            int strLength = ctx.STRING().getText().length() - 1;
            String str = ctx.STRING().getText().substring(1, strLength);
            llvmOutput.append(indents).append("%").append(varId).append(" = alloca ").append("[").append(strLength).append(" x i8]").append("\n");
            llvmOutput.append(indents).append("store [").append(strLength).append(" x i8] c\"").append(str).append("\\00\", ").append("[").append(strLength).append(" x i8]* %").append(varId).append("\n");
            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = bitcast [").append(strLength).append(" x i8]* %").append(varId).append(" to i8*").append("\n");

        } else {

            llvmOutput.append(indents).append("%").append(varId).append(" = alloca ").append(vsopTypeToLlvmType(typeFound)).append("\n");
            llvmOutput.append(indents).append("").append("store ").append(vsopTypeToLlvmType(typeFound)).append(" ").append(text).append(", ").append(vsopTypeToLlvmType(typeFound)).append("* %").append(varId).append("\n");
            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = load ").append(vsopTypeToLlvmType(typeFound)).append(", ").append(vsopTypeToLlvmType(typeFound)).append("* %").append(varId).append("\n");
        }


        llvmOutput.append(indents).append("\n");
        return new VariableDefinition("", String.valueOf(lastInstructionId), typeFound, "");

    }

    private VariableDefinition generateNewObj(NewObjContext ctx, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        String objType = ctx.TYPE_IDENTIFIER().getText();
        llvmOutput.append(indents).append("; New").append("\n");
        llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = alloca ").append(vsopTypeToLlvmType(objType)).append("\n");
        llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = call ").append(vsopTypeToLlvmType(objType)).append(" @").append(objType).append("_new()").append("\n");
        llvmOutput.append(indents).append("store ").append(vsopTypeToLlvmType(objType)).append(" %").append(lastInstructionId).append(", ").append(vsopTypeToLlvmType(objType)).append("* %").append(lastInstructionId-1).append("\n");

        llvmOutput.append("\n");
        return new VariableDefinition("", String.valueOf(lastInstructionId), objType, "");
    }

    private VariableDefinition generateCallMethod(CallMethodContext ctx, ArrayList<Map<String, VariableDefinition>> variablesCache) {

        for (SingleCallMethodContext call : ctx.singleCallMethod()) {
            generateSingleCallMethod(call, variablesCache);
        }


        return new VariableDefinition("", "", "", "");
    }

    private VariableDefinition generateSingleCallMethod(SingleCallMethodContext ctx, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        VariableDefinition lastCaller = null;
        String classType = "";
        int firstCaller = 0;

        llvmOutput.append(indents).append("; Call Method\n");

        if (ctx.caller().size() == 0) {

            lastCaller = checkVariableCacheForIdentifier("self", variablesCache);
            String varType = vsopTypeToLlvmType(lastCaller.type);
            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = load ").append(varType).append(", ").append(varType).append("* ").append(lastCaller.alias).append("\n");

            MethodDefinition methodToCheck = null;
            classType = lastCaller.type;
            do {
                methodToCheck = classes.get(classType).methods.get(ctx.callFunction(0).OBJECT_IDENTIFIER().getText());
                if (methodToCheck == null) {
                    classType = classes.get(classType).extend;
                    if (classType.equals("Object") || classType.equals(""))
                        break;
                    llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = getelementptr inbounds ").append(varType.substring(0, varType.length()-1)).append(", ").append(varType).append(" %").append(lastInstructionId-1).append(", i32 0, i32 ").append(0).append("\n");
                    varType = vsopTypeToLlvmType(classes.get(classType).name);
                }
            } while (methodToCheck == null);

            firstCaller = lastInstructionId;
        } else {
            for (CallerContext caller : ctx.caller()) {

            }
        }

        for (CallFunctionContext callFunction : ctx.callFunction()) {
            generateCallFunction(callFunction, firstCaller, classType, variablesCache);
        }

        llvmOutput.append("\n");
        return new VariableDefinition("", "", "", "");
    }

    private VariableDefinition generateCaller(CallerContext ctx, ArrayList<Map<String, VariableDefinition>> variablesCache) {

        return new VariableDefinition("", "", "", "");
    }

    private VariableDefinition generateCallFunction(CallFunctionContext ctx, int selfId, String selfType, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        MethodDefinition methodToCheck = classes.get(selfType).methods.get(ctx.OBJECT_IDENTIFIER().getText());
        StringBuilder formalStr = new StringBuilder();
        // Formals
        List<FormalDefinition> formals = new ArrayList<>(methodToCheck.formals.values());
        Collections.sort(formals, Comparator.comparingInt(FormalDefinition::getPosition));
        int j = 0;
        if (formals.size() > 0) llvmOutput.append(indents).append("; Arguments").append("\n");
        for (FormalDefinition formal : formals) {
            ArgumentContext arg = ctx.argument(j++);
            VariableDefinition argType = new VariableDefinition("", "", "", "");
            if (arg.binaryOperation() != null) {
                argType = generateBinaryOperation(arg.binaryOperation(), variablesCache);
            } else if (arg.callMethod() != null) {
                argType = generateCallMethod(arg.callMethod(), variablesCache);
            } else if (arg.newObj() != null) {
                argType = generateNewObj(arg.newObj(), variablesCache);
            } else if (arg.OBJECT_IDENTIFIER() != null) {
                argType = generateObjectIdentifier(arg.OBJECT_IDENTIFIER(), variablesCache);
            } else if (arg.varValue() != null) {
                argType = generateVarValue(arg.varValue(), variablesCache);
            }

            formalStr.append(", ").append(vsopTypeToLlvmType(argType.type)).append(" %").append(argType.alias);
        }

        // Find function to get type


        llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = call ").append(vsopTypeToLlvmType(methodToCheck.type)).append(" @").append(methodToCheck.name).append("(").append(vsopTypeToLlvmType(selfType)).append(" %").append(selfId).append(formalStr).append(")").append("\n");
        //%testCall2 = call i32 @main3(%struct.Object* %objInMainStruct2)

        return new VariableDefinition("", "", "", "");
    }

    private VariableDefinition generateBinaryOperation(BinaryOperationContext ctx, ArrayList<Map<String, VariableDefinition>> variablesCache) {

        return handleExpr1(ctx.expr1(), variablesCache);
    }

    private VariableDefinition handleExpr1(Expr1Context expr1, ArrayList<Map<String, VariableDefinition>> variablesCache) {

        if (expr1.expr1() != null) {
            VariableDefinition var1 = handleExpr1(expr1.expr1(), variablesCache);
            VariableDefinition var2 = handleExpr2(expr1.expr2(), variablesCache);

            llvmOutput.append(indents).append("; And\n");
            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = and i1 %").append(var1.alias).append(", %").append(var2.alias).append("\n");
            llvmOutput.append("\n");
        } else
            return handleExpr2(expr1.expr2(), variablesCache);

        return new VariableDefinition("", String.valueOf(lastInstructionId), "bool", "");
    }

    private VariableDefinition handleExpr2(Expr2Context expr2, ArrayList<Map<String, VariableDefinition>> variablesCache) {

        if (expr2.expr2() != null) {
            VariableDefinition var1 = handleExpr2(expr2.expr2(), variablesCache);
            int notTrue = ++lastGotoId;
            int notFalse = ++lastGotoId;
            int notEnd = ++lastGotoId;

            llvmOutput.append(indents).append("; Not\n");
            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = alloca i1").append("\n");
            llvmOutput.append(indents).append("br i1 %").append(var1.alias).append(", label %notTrue").append(notTrue).append(" , label %notFalse").append(notFalse).append("\n");
            llvmOutput.append(indents).append("notTrue").append(notTrue).append(":").append("\n");
            indents.append("\t");
            llvmOutput.append(indents).append("store i1 0, i1* %").append(lastInstructionId).append("\n");
            llvmOutput.append(indents).append("br label %notEnd").append(notEnd).append("\n");
            this.indents.delete(this.indents.length()-1, this.indents.length());
            llvmOutput.append(indents).append("notFalse").append(notFalse).append(":").append("\n");
            indents.append("\t");
            llvmOutput.append(indents).append("store i1 1, i1* %").append(lastInstructionId).append("\n");
            llvmOutput.append(indents).append("br label %notEnd").append(notEnd).append("\n");
            this.indents.delete(this.indents.length()-1, this.indents.length());
            llvmOutput.append(indents).append("notEnd").append(notEnd).append(":").append("\n");
            indents.append("\t");
            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = load i1, i1* %").append(lastInstructionId-1).append("\n");
            this.indents.delete(this.indents.length()-1, this.indents.length());

            llvmOutput.append("\n");
        } else
            return handleExpr3(expr2.expr3(), variablesCache);

        return new VariableDefinition("", String.valueOf(lastInstructionId), "bool", "");
    }

    private VariableDefinition handleExpr3(Expr3Context expr3, ArrayList<Map<String, VariableDefinition>> variablesCache) {

        if (expr3.comparatorOperator() != null) {

            VariableDefinition id1 = handleExpr4(expr3.expr4(0), variablesCache);
            VariableDefinition id2 = handleExpr4(expr3.expr4(1), variablesCache);

            String type = "i32";
            String alias1 = "%" + id1.alias;
            String alias2 = "%" + id2.alias;

            String operator = "";
            switch (expr3.comparatorOperator().getText()) {
                case "<":
                    llvmOutput.append(indents).append("; Lower\n");
                    operator = "slt";
                    break;
                case "<=":
                    llvmOutput.append(indents).append("; Lower or Equal\n");
                    operator = "sle";
                    break;
                case ">":
                    llvmOutput.append(indents).append("; Greater\n");
                    operator = "sgt";
                    break;
                case ">=":
                    llvmOutput.append(indents).append("; Greater or Equal\n");
                    operator = "sge";
                    break;
                case "=":
                    llvmOutput.append(indents).append("; Equal\n");
                    operator = "eq";
                    break;
                case "!=":
                    llvmOutput.append(indents).append("; Different\n");
                    operator = "ne";
                    break;
            }

            // TODO : Check addresses for objects
            if (expr3.comparatorOperator().getText().equals("=") || expr3.comparatorOperator().getText().equals("!=")) {
                if (id1.type.equals("bool")) {
                    llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = zext i1 %").append(id1.alias).append(" to i32").append("\n");
                    alias1 = "%" + String.valueOf(lastInstructionId);
                    llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = zext i1 %").append(id2.alias).append(" to i32").append("\n");
                    alias2 = "%" + String.valueOf(lastInstructionId);
                } else if (id1.type.equals("string")) {
                    llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = call i32 @strcmp(i8* ").append(alias1).append(", i8* ").append(alias2).append(") #2").append("\n");
                    alias1 = "%" + lastInstructionId;
                    alias2 = "0";
                }
            }

            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = icmp ").append(operator).append(" ").append(type).append(" ").append(alias1).append(", ").append(alias2).append("\n");
            llvmOutput.append("\n");

        } else
            return handleExpr4(expr3.expr4(0), variablesCache);

        return new VariableDefinition("", String.valueOf(lastInstructionId), "bool", "");
    }

    private VariableDefinition handleExpr4(Expr4Context expr4, ArrayList<Map<String, VariableDefinition>> variablesCache) {

        if (expr4.termOperator() != null) {
            VariableDefinition id1 = handleExpr4(expr4.expr4(), variablesCache);
            VariableDefinition id2 = handleExpr5(expr4.expr5(), variablesCache);
            switch (expr4.termOperator().getText()) {
                case "+":
                    llvmOutput.append(indents).append("; Addition\n");
                    llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = add nsw i32 %").append(id1.alias).append(", %").append(id2.alias).append("\n");
                    break;
                case "-":
                    llvmOutput.append(indents).append("; Subtraction\n");
                    llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = sub nsw i32 %").append(id1.alias).append(", %").append(id2.alias).append("\n");
                    break;
            }

            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = alloca i32").append("\n");
            llvmOutput.append(indents).append("store ").append("i32").append(" %").append(lastInstructionId-1).append(", ").append("i32* %").append(lastInstructionId).append("\n");
            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = load i32, i32* %").append(lastInstructionId-1).append("\n");
            llvmOutput.append("\n");
        } else
            return handleExpr5(expr4.expr5(), variablesCache);

        return new VariableDefinition("", String.valueOf(lastInstructionId), "int32", "");
    }

    private VariableDefinition handleExpr5(Expr5Context expr5, ArrayList<Map<String, VariableDefinition>> variablesCache) {

        if (expr5.factorOperator() != null) {
            VariableDefinition id1 = handleExpr5(expr5.expr5(), variablesCache);
            VariableDefinition id2 = handleExpr6(expr5.expr6(), variablesCache);
            switch (expr5.factorOperator().getText()) {
                case "*":
                    llvmOutput.append(indents).append("; Multiplication\n");
                    llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = mul nsw i32 %").append(id1.alias).append(", %").append(id2.alias).append("\n");
                    break;
                case "/":
                    llvmOutput.append(indents).append("; Division\n");
                    llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = sdiv i32 %").append(id1.alias).append(", %").append(id2.alias).append("\n");
                    break;
            }

            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = alloca i32").append("\n");
            llvmOutput.append(indents).append("store ").append("i32").append(" %").append(lastInstructionId-1).append(", ").append("i32* %").append(lastInstructionId).append("\n");
            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = load i32, i32* %").append(lastInstructionId-1).append("\n");
            llvmOutput.append("\n");
        } else
            return handleExpr6(expr5.expr6(), variablesCache);

        return new VariableDefinition("", String.valueOf(lastInstructionId), "int32", "");
    }

    private VariableDefinition handleExpr6(Expr6Context expr6, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        String returnType = "";

        if (expr6.expr6() != null) {
            String operator = expr6.MINUS() != null ? expr6.MINUS().getText() : expr6.ISNULL().getText();
            VariableDefinition varId = handleExpr6(expr6.expr6(), variablesCache);

            if (operator.equals("isnull")) {
                llvmOutput.append(indents).append("; IsNull\n");
                returnType = "bool";
                // TODO : Null operation
            } else if (operator.equals("-")) {
                returnType = "int32";
                llvmOutput.append(indents).append("; Negative\n");
                llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = sub nsw i32 0, %").append(varId.alias).append("\n");
                llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = alloca i32").append("\n");
                llvmOutput.append(indents).append("store ").append("i32").append(" %").append(lastInstructionId-1).append(", ").append("i32* %").append(lastInstructionId).append("\n");
                llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = load i32, i32* %").append(lastInstructionId-1).append("\n");
            }

            llvmOutput.append("\n");
        } else
            return handleExpr7(expr6.expr7(), variablesCache);

        return new VariableDefinition("", String.valueOf(lastInstructionId), returnType, "");
    }

    private VariableDefinition handleExpr7(Expr7Context expr7, ArrayList<Map<String, VariableDefinition>> variablesCache) {

        if (expr7.POW() != null) {
            VariableDefinition id1 = handleExpr8(expr7.expr8(), variablesCache);
            VariableDefinition id2 = handleExpr7(expr7.expr7(), variablesCache);

            llvmOutput.append(indents).append("; Pow\n");
            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = sitofp i32 %").append(id1.alias).append(" to double").append("\n");
            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = sitofp i32 %").append(id2.alias).append(" to double").append("\n");
            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = call double @pow(double %").append(lastInstructionId-2).append(", double %").append(lastInstructionId-1).append(") #3\n");

            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = fptosi double %").append(lastInstructionId-1).append(" to i32").append("\n");
            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = alloca i32").append("\n");
            llvmOutput.append(indents).append("store ").append("i32").append(" %").append(lastInstructionId-1).append(", ").append("i32* %").append(lastInstructionId).append("\n");
            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = load i32, i32* %").append(lastInstructionId-1).append("\n");
            llvmOutput.append("\n");

        } else
            return handleExpr8(expr7.expr8(), variablesCache);

        return new VariableDefinition("", String.valueOf(lastInstructionId), "int32", "");
    }

    private VariableDefinition handleExpr8(Expr8Context expr8, ArrayList<Map<String, VariableDefinition>> variablesCache) {

        if (expr8.expr1() != null)
            return handleExpr1(expr8.expr1(), variablesCache);
        else if (expr8.callMethod() != null)
            return generateCallMethod(expr8.callMethod(), variablesCache);
        else if (expr8.varValue() != null)
            return generateVarValue(expr8.varValue(), variablesCache);
        else if (expr8.newObj() != null)
            return generateNewObj(expr8.newObj(), variablesCache);
        else if (expr8.ifStatement() != null)
            return generateIfStatement(expr8.ifStatement(), variablesCache);
        else if (expr8.OBJECT_IDENTIFIER() != null) {
            return generateObjectIdentifier(expr8.OBJECT_IDENTIFIER(), variablesCache);
        }

        return new VariableDefinition("", "", "", "");
    }



    private String vsopTypeToLlvmType(String type) {
        switch (type) {
            case "int32":
                return "i32";
            case "unit":
                return "void";
            case "bool":
                return "i1";
            case "string":
                return "i8*";
            default:
                return "%struct." + type + "*";
        }
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

    private String getDefaultValue(String type) {
        switch (type) {
            case "int32":
                return "0";
            case "unit":
                return "()";
            case "bool":
                return "0";
            case "string":
                return "getelementptr inbounds ([1 x i8], [1 x i8]* @.str.empty, i32 0, i32 0)";
            default:
                return "null";
        }
    }

    private void appendSectionHeader(String title) {
        llvmOutput.append(indents).append("; \n");
        llvmOutput.append(indents).append("; ").append(title).append("\n");
        llvmOutput.append(indents).append("; \n");
    }

    private VariableDefinition checkVariableCacheForIdentifier(String identifier, ArrayList<Map<String, VariableDefinition>> variablesCache)  {
        VariableDefinition varFound = null;

        if (variablesCache != null) {
            for (int i = variablesCache.size() - 1; i >= 0; i--) {
                if (variablesCache.get(i).containsKey(identifier)) {
                    varFound = variablesCache.get(i).get(identifier);
                    break;
                }
            }
        }

        if (varFound == null) {
            if (variablesCache != null) {
                for (int i = variablesCache.size() - 1; i >= 0; i--) {
                    if (variablesCache.get(i).containsKey("self")) {
                        varFound = variablesCache.get(i).get("self");
                        break;
                    }
                }
            }
        }

        return varFound;
    }
//endregion

}
