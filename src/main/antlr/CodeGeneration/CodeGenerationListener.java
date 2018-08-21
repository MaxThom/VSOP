package CodeGeneration;

import VSOP.CodeGeneration.CODEBaseListener;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;
import java.util.stream.Collectors;

import static VSOP.CodeGeneration.CODEParser.*;

/**
 * Class overriding the default listener of antlr. Each hit on a token generate two methods. One enter and one exit. Exit when everything under the node has been looked.
 */
public class CodeGenerationListener extends CODEBaseListener {


    private Map<String, ClassDefinition> classes;
    private ClassDefinition currentClass;
    private String fileName;
    private int lastInstructionId;
    private int lastGotoId;

    public StringBuilder llvmOutput;
    private StringBuilder indents;
    public ArrayList<String> errorOutput;

    private boolean isInFieldInitializer;


    public CodeGenerationListener(String fileName) {
        classes = new HashMap<>();
        errorOutput = new ArrayList<>();
        currentClass = null;
        this.fileName = fileName;
        llvmOutput = new StringBuilder();
        indents = new StringBuilder();
        addLibrary(addIOClasses());
    }

    /**
     * Add extern library like IO or Object
     * @param newClass
     */
    public void addLibrary(ClassDefinition newClass) {
        classes.put(newClass.name, newClass);
    }

    /**
     * Add IO Class
     * @return
     */
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

    /**
     * After parser is complete, start semantic check
     * @param ctx
     */
    @Override
    public void exitProgram(ProgramContext ctx) {
        generateProgram(ctx);
    }

    /**
     * Add classes to class dictionary to use later. Check for same names as well
     * @param ctx
     */
    @Override
    public void exitClassDefinition(ClassDefinitionContext ctx) {
        ClassDefinition classDef = new ClassDefinition();
        classDef.name = ctx.TYPE_IDENTIFIER(0).getText();
        classDef.extend = ctx.TYPE_IDENTIFIER(1) != null ? ctx.TYPE_IDENTIFIER(1).getText() : "Object";

        // Get every methods and fields
        List<MethodDefinitionContext> methods = ctx.children.stream().filter(x -> x instanceof  MethodDefinitionContext)
                .map(x -> (MethodDefinitionContext) x).collect(Collectors.toList());
        List<FieldContext> fields = ctx.children.stream().filter(x -> x instanceof  FieldContext)
                .map(x -> (FieldContext) x).collect(Collectors.toList());

        // Start with checking every methods a class has
        for (MethodDefinitionContext method: methods) {
            MethodDefinition methodDef = new MethodDefinition(method.OBJECT_IDENTIFIER().getText(), method.varType().getText());

            int formalPos = 0;
            for (FormalContext formal : method.formal()) {
                FormalDefinition formalDef = new FormalDefinition(formal.OBJECT_IDENTIFIER().getText(), formal.varType().getText(), formalPos++);
                methodDef.formals.put(formalDef.name, formalDef);
            }

            classDef.methods.put(methodDef.name, methodDef);
        }

        // Check every fields
        int fieldPos = 1;
        for (FieldContext field: fields) {
            FieldDefinition fieldDef = new FieldDefinition(field.OBJECT_IDENTIFIER().getText(), field.varType().getText(), fieldPos++);
            classDef.fields.put(fieldDef.name, fieldDef);
        }

        classes.put(classDef.name, classDef);
    }

//region GENERATE_LLVM

    /**
     * Generate LLVM IR using the AST of vsop
     * @param ctx
     */
    private void generateProgram(ProgramContext ctx) {
        generateHeader();
        generateStructuresFromClasses();
        generateIOClass();

        // Foir every class
        for (ClassDefinitionContext classDef : ctx.classDefinition()) {
            currentClass = classes.get(classDef.TYPE_IDENTIFIER(0).getText());
            appendSectionHeader(classDef.TYPE_IDENTIFIER(0).getText().toUpperCase());
            generateStructuresAllocationFromClass(classDef);
            generateStructuresInitializerFromClass(classDef);
            generateMethodsFromClass(classDef);
            llvmOutput.append(indents).append("\n");
        }
    }

    /**
     * Generate the header with some declaration
     */
    private void generateHeader() {
        llvmOutput.append("; ModuleID = '").append(fileName).append("'\n");
        //llvmOutput.append("source_filename = \"").append(fileName).append("\"\n\n");

        appendSectionHeader("DECLARATION");
        llvmOutput.append("declare noalias i8* @malloc(i64) #1").append("\n");
        llvmOutput.append("declare i32 @printf(i8*, ...)").append("\n");
        llvmOutput.append("declare double @pow(double, double) #1").append("\n");
        llvmOutput.append("declare i32 @strcmp(i8*, i8*) #1").append("\n");
        llvmOutput.append("declare i32 @__isoc99_scanf(i8*, ...) #1").append("\n");
        llvmOutput.append("declare void @exit(i32) #1").append("\n");
        llvmOutput.append("@.str.empty = private unnamed_addr constant [1 x i8] zeroinitializer, align 1").append("\n");

        llvmOutput.append("\n");
    }

    /**
     * Generate the IO class in llvm ir. I added 3 extra methods with automatic end of line (println, printlnInt32 and printlnBool)
     */
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

        llvmOutput.append(indents).append("define %struct.IO* @IO_printInt32(%struct.IO*, i32) {\n" +
                "\t%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @IO.printInt, i32 0, i32 0), i32 %1)\n" +
                "\tret %struct.IO* %0\n" +
                "}").append("\n");
        llvmOutput.append(indents).append("define %struct.IO* @IO_printBool(%struct.IO*, i1) {\n" +
                "\t%3 = icmp eq i1 %1, 0\n" +
                "\tbr i1 %3, label %false, label %true\t\n" +
                "\n" +
                "    true:\n" +
                "        %msg = alloca [5 x i8]\n" +
                "        store [5 x i8] c\"true\\00\", [5 x i8]* %msg\n" +
                "        %loadedMsg = bitcast [5 x i8]* %msg to i8*\n" +
                "        call %struct.IO* @IO_print(%struct.IO* %0, i8* %loadedMsg)\n" +
                "        br label %end\n" +
                "\n" +
                "    false:\n" +
                "        %msg2 = alloca [6 x i8]\n" +
                "        store [6 x i8] c\"false\\00\", [6 x i8]* %msg2\n" +
                "        %loadedMsg2 = bitcast [6 x i8]* %msg2 to i8*\n" +
                "        call %struct.IO* @IO_print(%struct.IO* %0, i8* %loadedMsg2)\n" +
                "        br label %end\n" +
                "\n" +
                "\tend:\n" +
                "\t    ret %struct.IO* %0\n" +
                "}").append("\n");
        llvmOutput.append(indents).append("define %struct.IO* @IO_print(%struct.IO*, i8*) {\n" +
                "\t%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @IO.printStr, i32 0, i32 0), i8* %1)\n" +
                "\tret %struct.IO* %0\n" +
                "}").append("\n");
        llvmOutput.append(indents).append("define %struct.IO* @IO_printlnInt32(%struct.IO*, i32) {\n" +
                "\t%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @IO.printlnInt, i32 0, i32 0), i32 %1)\n" +
                "\tret %struct.IO* %0\n" +
                "}").append("\n");
        llvmOutput.append(indents).append("define %struct.IO* @IO_printlnBool(%struct.IO*, i1) {\n" +
                "\t%3 = icmp eq i1 %1, 0\n" +
                "\tbr i1 %3, label %false, label %true\t\n" +
                "\n" +
                "    true:\n" +
                "        %msg = alloca [5 x i8]\n" +
                "        store [5 x i8] c\"true\\00\", [5 x i8]* %msg\n" +
                "        %loadedMsg = bitcast [5 x i8]* %msg to i8*\n" +
                "        call %struct.IO* @IO_println(%struct.IO* %0, i8* %loadedMsg)\n" +
                "        br label %end\n" +
                "\n" +
                "    false:\n" +
                "        %msg2 = alloca [6 x i8]\n" +
                "        store [6 x i8] c\"false\\00\", [6 x i8]* %msg2\n" +
                "        %loadedMsg2 = bitcast [6 x i8]* %msg2 to i8*\n" +
                "        call %struct.IO* @IO_println(%struct.IO* %0, i8* %loadedMsg2)\n" +
                "        br label %end\n" +
                "\n" +
                "\tend:\n" +
                "\t    ret %struct.IO* %0\n" +
                "}").append("\n");
        llvmOutput.append(indents).append("define %struct.IO* @IO_println(%struct.IO*, i8*) {\n" +
                "\t%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @IO.printlnStr, i32 0, i32 0), i8* %1)\n" +
                "\tret %struct.IO* %0\n" +
                "}").append("\n");

        llvmOutput.append(indents).append("define i32 @IO_inputInt32(%struct.IO*) {\n" +
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
                "        call %struct.IO* @IO_println(%struct.IO* %0, i8* %loadedMsg)\n" +
                "        call void @exit(i32 1) #3\n" +
                "        br label %end\n" +
                "\n" +
                "    end:\n" +
                "\t    ret i32 %4\n" +
                "}").append("\n");
        llvmOutput.append(indents).append("define i1 @IO_inputBool(%struct.IO*) {\n" +
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
                "        call %struct.IO* @IO_println(%struct.IO* %0, i8* %loadedMsg)\n" +
                "        call void @exit(i32 1) #3\n" +
                "        br label %end\n" +
                "\n" +
                "    end:\n" +
                "        %7 = icmp ne i32 %4, 0\n" +
                "\t    ret i1 %7\n" +
                "}").append("\n");
        llvmOutput.append(indents).append("define i8* @IO_inputLine(%struct.IO*) {\n" +
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

    /**
     * Generate structure for every class
     */
    private void generateStructuresFromClasses() {
        appendSectionHeader("STRUCTURES");

        // Add object structure
        llvmOutput.append(indents).append("%struct.").append("Object").append(" = type { }\n");

        // For inheritance, Ive chosen to have the parent structure in the child class
        for (ClassDefinition cl: classes.values()) {
            llvmOutput.append(indents).append("%struct.").append(cl.name).append(" = type {\n");

            if (!cl.extend.equals("Object"))
                llvmOutput.append(indents).append("\t%struct.").append(cl.extend).append(",\n");
            else
                llvmOutput.append(indents).append("\t%struct.").append("Object").append(",\n");

            // Add fields
            List<FieldDefinition> fields = new ArrayList<>(cl.fields.values());
            Collections.sort(fields, Comparator.comparingInt(FieldDefinition::getPosition));
            for (FieldDefinition field : fields) {
                llvmOutput.append(indents).append("\t").append(vsopTypeToLlvmType(field.type)).append(",\n");
            }
            llvmOutput.delete(llvmOutput.length() - 2, llvmOutput.length());
            llvmOutput.append(indents).append("\n}\n");
        }

        llvmOutput.append(indents).append("\n");
    }

    /**
     * Generation new for every structure
     * @param ctx
     */
    private void generateStructuresAllocationFromClass(ClassDefinitionContext ctx) {
        llvmOutput.append(indents).append("\n; Allocation\n");
        ClassDefinition cl = classes.get(ctx.TYPE_IDENTIFIER(0).getText());

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

    /**
     * Generate init for every structure
     * @param ctx
     */
    private void generateStructuresInitializerFromClass(ClassDefinitionContext ctx) {
        llvmOutput.append(indents).append("\n; Initializer\n");
        ClassDefinition cl = classes.get(ctx.TYPE_IDENTIFIER(0).getText());
        List<FieldContext> fields = ctx.children.stream().filter(x -> x instanceof  FieldContext).map(x -> (FieldContext) x).collect(Collectors.toList());

        llvmOutput.append(indents).append("define void @").append(cl.name).append("_init(%struct.").append(cl.name).append("*) #0 {\n");
        llvmOutput.append(indents).append("\t").append("%2 = alloca %struct.").append(cl.name).append("*").append("\n");
        llvmOutput.append(indents).append("\t").append("store %struct.").append(cl.name).append("* %0, %struct.").append(cl.name).append("** %2").append("\n\n");

        int i = 3, j = 0;
        // Call init for super class
        if (!cl.extend.equals("Object")) {
            llvmOutput.append(indents).append("\t").append("%").append(i).append(" = load %struct.").append(cl.name)
                    .append("*, %struct.").append(cl.name).append("** %2").append("\n");
            llvmOutput.append(indents).append("\t").append("%").append(i+1).append(" = getelementptr inbounds %struct.")
                    .append(cl.name).append(", %struct.").append(cl.name).append("* %").append(i).append(", i32 0, i32 ").append(j).append("\n");
            llvmOutput.append(indents).append("\t").append("call void @").append(cl.extend).append("_init(%struct.")
                    .append(cl.extend).append("* %").append(i+1).append(")").append("\n\n");
            i += 2;
        }
        this.lastInstructionId = i-1;
        j = 1;
        // Initialize every field
        this.isInFieldInitializer = true;
        for (FieldContext field : fields) {
            int whereToStore = ++lastInstructionId;
            llvmOutput.append(indents).append("\t").append("%").append(whereToStore).append(" = load %struct.")
                    .append(cl.name).append("*, %struct.").append(cl.name).append("** %2").append("\n");
            llvmOutput.append(indents).append("\t").append("%").append(++lastInstructionId).append(" = getelementptr inbounds %struct.")
                    .append(cl.name).append(", %struct.").append(cl.name).append("* %").append(lastInstructionId-1).append(", i32 0, i32 ").append(j).append("\n");
            ArrayList<Map<String, VariableDefinition>> variablesCache = new ArrayList<>();
            variablesCache.add(new HashMap<>());
            if (field.statement() != null) {
                this.indents.append("\t");
                variablesCache.add(new HashMap<>());
                VariableDefinition var = generateStatement(field.statement(), variablesCache);
                variablesCache.remove(variablesCache.size()-1);

                llvmOutput.append(indents).append("store ").append(vsopTypeToLlvmType(var.type)).append(isPrimitive(var.type) ? "" : "")
                        .append(" %").append(var.alias).append(", ").append(vsopTypeToLlvmType(var.type)).append(isPrimitive(var.type) ? "" : "")
                        .append("* %").append(whereToStore+1).append("\n");
                this.indents.delete(this.indents.length()-1, this.indents.length());
            } else if (field.block() != null) {
                VariableDefinition var = generateBlock(field.block(), variablesCache);
                llvmOutput.append(indents).append("; Assign\n");
                llvmOutput.append(indents).append("store ").append(vsopTypeToLlvmType(var.type)).append(isPrimitive(var.type) ? "" : "")
                        .append(" %").append(lastInstructionId).append(", ").append(vsopTypeToLlvmType(var.type)).append(isPrimitive(var.type) ? "" : "")
                        .append("* %").append(var.aliasAlocated).append("\n");
            } else {
                if (isPrimitive(field.varType().getText()))
                    llvmOutput.append(indents).append("\t").append("store ").append(vsopTypeToLlvmType(field.varType().getText()))
                            .append(" ").append(getDefaultValue(field.varType().getText())).append(", ").append(vsopTypeToLlvmType(field.varType().getText()))
                            .append("* %").append(whereToStore + 1).append("\n\n");
            }

            i += 2;
            j += 1;
        }
        this.isInFieldInitializer = false;

        llvmOutput.delete(llvmOutput.length()-1, llvmOutput.length());
        llvmOutput.append(indents).append("\n\tret void\n}\n");
    }

    /**
     * Generate methods for the class
     * @param ctx
     */
    private void generateMethodsFromClass(ClassDefinitionContext ctx) {
        List<MethodDefinitionContext> methods = ctx.children.stream().filter(x -> x instanceof  MethodDefinitionContext)
                .map(x -> (MethodDefinitionContext) x).collect(Collectors.toList());
        String classType = ctx.TYPE_IDENTIFIER(0).getText();

        for (MethodDefinitionContext method: methods) {
            ArrayList<Map<String, VariableDefinition>> variablesCache = new ArrayList<>();
            // Add definition
            llvmOutput.append(indents).append("\n; Method ").append(method.OBJECT_IDENTIFIER()).append("\n");
            if (classType.equals("Main") && method.OBJECT_IDENTIFIER().getText().equals("main"))
                llvmOutput.append(indents).append("define ").append(vsopTypeToLlvmType(method.varType().getText()))
                        .append((isPrimitive(method.varType().getText()) ? " @" :"* @")).append(method.OBJECT_IDENTIFIER()).append("(");
            else
                llvmOutput.append(indents).append("define ").append(vsopTypeToLlvmType(method.varType().getText()))
                        .append((isPrimitive(method.varType().getText()) ? " @" :"* @")).append(classType).append("_").append(method.OBJECT_IDENTIFIER()).append("(");

            // Add self structure
            llvmOutput.append(indents).append(vsopTypeToLlvmType(classType)).append("*, ");

            // Formals
            variablesCache.add(new HashMap<>());
            List<FormalDefinition> formals = new ArrayList<>(currentClass.methods.get(method.OBJECT_IDENTIFIER().getText()).formals.values());
            Collections.sort(formals, Comparator.comparingInt(FormalDefinition::getPosition));
            for (FormalDefinition formal : formals) {
                if (isPrimitive(formal.type))
                    llvmOutput.append(indents).append(vsopTypeToLlvmType(formal.type)).append(", ");
                else
                    llvmOutput.append(indents).append(vsopTypeToLlvmType(formal.type)).append("*, ");
            }
            llvmOutput.delete(llvmOutput.length()-2, llvmOutput.length());
            llvmOutput.append(indents).append(") #0 {\n");

            if (method.block() != null) {
                this.indents.append("\t");
                this.lastInstructionId = formals.size()+1;
                this.lastGotoId = 0;

                // Add self structure
                llvmOutput.append(indents).append("; Formals\n");
                llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = alloca ")
                        .append(vsopTypeToLlvmType(classType)).append("*").append("\n");
                if (classType.equals("Main") && method.OBJECT_IDENTIFIER().getText().equals("main")) {
                    // If main, add initializer else it's already created with the new before the call
                    llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = call ")
                            .append(vsopTypeToLlvmType(classType)).append("* @").append(classType).append("_new()\n");
                    llvmOutput.append(indents).append("store ").append(vsopTypeToLlvmType(classType)).append("* %")
                            .append(lastInstructionId).append(", ").append(vsopTypeToLlvmType(classType)).append("** %")
                            .append(lastInstructionId - 1).append("\n");
                    variablesCache.get(variablesCache.size()-1).put("self", new VariableDefinition("self", ""
                            .concat(String.valueOf(lastInstructionId-1)), classType, ""));
                } else {
                    llvmOutput.append(indents).append("store ").append(vsopTypeToLlvmType(classType)).append("* %0")
                            .append(", ").append(vsopTypeToLlvmType(classType)).append("** %").append(lastInstructionId).append("\n");
                    variablesCache.get(variablesCache.size()-1).put("self", new VariableDefinition("self", ""
                            .concat(String.valueOf(lastInstructionId)), classType, ""));
                }


                // Add formals as first instructions
                for (FormalDefinition formal : formals) {
                    llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = alloca ").append(vsopTypeToLlvmType(formal.type)
                    ).append(isPrimitive(formal.type) ? "" : "*").append("\n");
                    llvmOutput.append(indents).append("store ").append(vsopTypeToLlvmType(formal.type)).append(isPrimitive(formal.type) ? "" : "*")
                            .append(" %".concat(String.valueOf(formal.position+1))).append(", ").append(vsopTypeToLlvmType(formal.type))
                            .append(isPrimitive(formal.type) ? "" : "*").append("* %").append(lastInstructionId).append("\n");
                    variablesCache.get(variablesCache.size()-1).put(formal.name, new VariableDefinition(formal.name, "".concat(String.valueOf(lastInstructionId)), formal.type, ""));
                }
                llvmOutput.append(indents).append("\n");

                this.indents.delete(this.indents.length()-1, this.indents.length());
                generateBlock(method.block(), variablesCache);
            }

            if (method.varType().getText().equals("unit"))
                llvmOutput.append(indents).append("\tret void").append("\n");
            else
                llvmOutput.append(indents).append("\tret ").append(vsopTypeToLlvmType(method.varType().getText()))
                        .append(isPrimitive(method.varType().getText()) ? "" : "*").append(" %").append(lastInstructionId).append("\n");
            llvmOutput.append(indents).append("}\n");
        }
    }

    /**
     * Generate block
     * @param ctx
     * @param variablesCache
     * @return
     */
    private VariableDefinition generateBlock(BlockContext ctx, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        VariableDefinition returnVar = null;
        this.indents.append("\t");
        String lastBlock = "";
        variablesCache.add(new HashMap<>());

        // For every instructions
        for (int i = 0; i < ctx.children.size()-2 ; i++) {
            if (ctx.children.get(i) instanceof ParserRuleContext) {
                ParserRuleContext child = (ParserRuleContext) ctx.children.get(i);

                if (child instanceof BlockContext) {
                    generateBlock((BlockContext) child, variablesCache);
                } else if (child instanceof IfStatementContext) {
                    lastBlock = generateIfStatement((IfStatementContext) child, variablesCache).blockName;
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
                    returnVar = generateBlock((BlockContext) child, variablesCache);
                } else if (child instanceof StatementContext) {
                    returnVar = generateStatement((StatementContext) child, variablesCache);
                }

                break;
            }
        }

        variablesCache.remove(variablesCache.size()-1);
        this.indents.delete(this.indents.length()-1, this.indents.length());

        if (returnVar.blockName.equals(""))
            returnVar.blockName = lastBlock;
        return returnVar;
    }

    /**
     * Generate statement
     * @param ctx
     * @param variablesCache
     * @return
     */
    private VariableDefinition generateStatement(StatementContext ctx, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        if (ctx.assign() != null) {
            return generateAssign(ctx.assign(), variablesCache);
        } else if (ctx.ifStatement() != null) {
            return generateIfStatement(ctx.ifStatement(), variablesCache);
        } else if (ctx.whileStatement() != null) {
            generateWhileStatement(ctx.whileStatement(), variablesCache);
        } else if (ctx.let() != null) {
            generateLet(ctx.let(), variablesCache);
        } else if (ctx.binaryOperation() != null) {
            return generateBinaryOperation(ctx.binaryOperation(), variablesCache);
        } else if (ctx.callMethod() != null) {
            return generateCallMethod(ctx.callMethod(), variablesCache);
        } else if (ctx.newObj() != null) {
            return generateNewObj(ctx.newObj(), variablesCache);
        } else if (ctx.OBJECT_IDENTIFIER() != null) {
            return generateObjectIdentifier(ctx.OBJECT_IDENTIFIER(), variablesCache);
        } else if (ctx.statement() != null) {
            return generateStatement(ctx.statement(), variablesCache);
        } else if (ctx.varValue() != null) {
            return generateVarValue(ctx.varValue(), variablesCache);
        }

        return new VariableDefinition("", "", "", "", "");
    }

    /**
     * Generate if statement
     * @param ctx
     * @param variablesCache
     * @return
     */
    private VariableDefinition generateIfStatement(IfStatementContext ctx, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        VariableDefinition returnIf = null;
        VariableDefinition returnElse = null;

        // For label id
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
            returnIf = generateStatement(ctx.ifStat().statement(1), variablesCache);
            this.indents.delete(this.indents.length()-1, this.indents.length());
        } else if (ctx.ifStat().block() != null) {
            returnIf = generateBlock(ctx.ifStat().block(), variablesCache);
        }
        llvmOutput.append(indents).append("\tbr label %condEnd").append(ifGoto).append("\n\n");
        variablesCache.remove(variablesCache.size()-1);

        // Get Else branch type
        if (ctx.elseStat() != null) {
            variablesCache.add(new HashMap<>());
            llvmOutput.append(indents).append("condElse").append(ifGoto).append(":").append("\n");

            if (ctx.elseStat().statement() != null) {
                this.indents.append("\t");
                returnElse = generateStatement(ctx.elseStat().statement(), variablesCache);
                this.indents.delete(this.indents.length()-1, this.indents.length());
            } else if (ctx.elseStat().block() != null) {
                 returnElse = generateBlock(ctx.elseStat().block(), variablesCache);
            }
            llvmOutput.append(indents).append("\tbr label %condEnd").append(ifGoto).append("\n\n");
            variablesCache.remove(variablesCache.size()-1);
        }

        llvmOutput.append(indents).append("condEnd").append(ifGoto).append(":").append("\n");

        // Add cast in case of inheritance
        String returnType = "";
        String idIf = "", idElse = "";
        if (returnIf != null && returnElse != null && !returnIf.type.equals("") && !returnElse.type.equals("")) {
            String labelIf = (returnIf.blockName.equals("")) ? "%condIf" + ifGoto :returnIf.blockName;
            String labelElse = (returnElse.blockName.equals("")) ? "%condElse" + ifGoto :returnElse.blockName;


            if (!isPrimitive(returnIf.type) && !isPrimitive(returnElse.type) && !returnIf.type.equals(returnElse.type)) {
                int whereToAdd = 0;
                String whatToAdd = "";

                if (lookForInheritance(returnIf.type, returnElse.type)) {
                    returnType = returnIf.type;
                    idIf = returnIf.aliasAlocated;
                    //Add cast in else

                    whereToAdd = llvmOutput.indexOf(indents.toString() + "\tbr label %condEnd" + ifGoto);
                    whereToAdd = llvmOutput.indexOf(indents.toString() + "\tbr label %condEnd" + ifGoto, whereToAdd + 5);
                    whatToAdd = indents.toString() + "\t%cast" + ifGoto + " = bitcast " + vsopTypeToLlvmType(returnElse.type)
                            + "* %" + returnElse.aliasAlocated + " to " + vsopTypeToLlvmType(returnType) + "*" + "\n";
                    idElse = "cast" + ifGoto;

                } else if (lookForInheritance(returnElse.type, returnIf.type)) {
                    returnType = returnElse.type;
                    idElse = returnIf.aliasAlocated;
                    // Add cast in if

                    whereToAdd = llvmOutput.indexOf(indents.toString() + "\tbr label %condEnd" + ifGoto);
                    whatToAdd = indents.toString() + "\t%cast" + ifGoto + " = bitcast " + vsopTypeToLlvmType(returnIf.type)
                            + "* %" + returnIf.aliasAlocated + " to " + vsopTypeToLlvmType(returnType) + "*" + "\n";
                    idIf = "cast" + ifGoto;
                }

                llvmOutput.insert(whereToAdd, whatToAdd);
                //llvmOutput.append(indents).append("\t%").append(++lastInstructionId).append(" = phi ").append(vsopTypeToLlvmType(returnType))
                //        .append("*").append(" [%").append(idIf).append(", %condIf").append(ifGoto).append("], [%").append(idElse).append(", %condElse").append(ifGoto).append("]").append("\n\n");
                llvmOutput.append(indents).append("\t%").append(++lastInstructionId).append(" = phi ").append(vsopTypeToLlvmType(returnType))
                        .append("*").append(" [%").append(idIf).append(", ").append(labelIf).append("], [%").append(idElse).append(", ").append(labelElse).append("]").append("\n\n");
            } else if (!returnIf.type.equals("unit") && !returnElse.type.equals("unit")) {
                returnType = returnIf.type;
                //llvmOutput.append(indents).append("\t%").append(++lastInstructionId).append(" = phi ").append(vsopTypeToLlvmType(returnType))
                //        .append(isPrimitive(returnIf.type) ? "" : "*").append(" [%").append(returnIf.alias).append(", %condIf").append(ifGoto).append("], [%").append(returnElse.alias).append(", %condElse").append(ifGoto).append("]").append("\n\n");
                llvmOutput.append(indents).append("\t%").append(++lastInstructionId).append(" = phi ").append(vsopTypeToLlvmType(returnType))
                        .append(isPrimitive(returnIf.type) ? "" : "*").append(" [%").append(returnIf.alias).append(", ").append(labelIf).append("], [%").append(returnElse.alias).append(", ").append(labelElse).append("]").append("\n\n");
            }
        }

        return new VariableDefinition("", String.valueOf(lastInstructionId), returnType, "", "%condEnd" + ifGoto);
    }

    /**
     * Generate while statement
     * @param ctx
     * @param variablesCache
     * @return
     */
    private void generateWhileStatement(WhileStatementContext ctx, ArrayList<Map<String, VariableDefinition>> variablesCache) {

        int whileGoto = ++lastGotoId;
        llvmOutput.append(indents).append("; While\n");

        // Handle condition
        if (ctx.statement(0) != null) {
            llvmOutput.append(indents).append("br label %whileCond").append(whileGoto).append("\n");
            llvmOutput.append(indents).append("whileCond").append(whileGoto).append(":").append("\n");
            this.indents.append("\t");
            generateStatement(ctx.statement(0), variablesCache);
            llvmOutput.append(indents).append("br i1 %").append(lastInstructionId).append(", label %while").append(whileGoto)
                    .append(", label %whileEnd").append(whileGoto).append("\n\n");
            variablesCache.remove(variablesCache.size()-1);
            this.indents.delete(this.indents.length()-1, this.indents.length());
        }

        variablesCache.add(new HashMap<>());
        llvmOutput.append(indents).append("while").append(whileGoto).append(":").append("\n");

        // Generate block or statement
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

    /**
     * Generate let statement
     * @param ctx
     * @param variablesCache
     * @return
     */
    private void  generateLet(LetContext ctx, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        int letId = ++lastInstructionId;
        String vsopType = vsopTypeToLlvmType(ctx.varType().getText());
        llvmOutput.append(indents).append("; Let\n");
        llvmOutput.append(indents).append("%").append(letId).append(" = alloca ").append(vsopType)
                .append(isPrimitive(ctx.varType().getText()) ? "" : "*").append("\n");

        // Add variable in let scope
        variablesCache.add(new HashMap<>());
        variablesCache.get(variablesCache.size()-1).put(ctx.OBJECT_IDENTIFIER().getText(), new VariableDefinition(ctx.OBJECT_IDENTIFIER().getText(), String.valueOf(letId), ctx.varType().getText(), ""));

        // Initializer
        int statOffset = 0;
        if (ctx.statement().size() == 2 || (ctx.statement().size() == 1 && ctx.block() != null)) {
            generateStatement(ctx.statement(statOffset++), variablesCache);
            llvmOutput.append(indents).append("store ").append(vsopType).append(isPrimitive(ctx.varType().getText()) ? "" : "*")
                    .append(" %").append(lastInstructionId).append(", ").append(vsopType).append(isPrimitive(ctx.varType().getText()) ? "" : "*").append("* %").append(letId).append("\n");
        } else
            llvmOutput.append(indents).append("store ").append(vsopTypeToLlvmType(ctx.varType().getText()))
                    .append(isPrimitive(ctx.varType().getText()) ? "" : "*").append(" ").append(getDefaultValue(ctx.varType().getText()))
                    .append(", ").append(vsopTypeToLlvmType(ctx.varType().getText())).append(isPrimitive(ctx.varType().getText()) ? "" : "*").append("* %")
                    .append(lastInstructionId).append("\n");

        // Generate body
        if (ctx.statement(statOffset) != null) {
            generateStatement(ctx.statement(statOffset), variablesCache);
        } else if (ctx.block() != null) {
            generateBlock(ctx.block(), variablesCache);
        }
        llvmOutput.append(indents).append("\n");

        variablesCache.remove(variablesCache.size()-1);
    }

    /**
     * Generate assign
     * @param ctx
     * @param variablesCache
     * @return
     */
    private VariableDefinition generateAssign(AssignContext ctx, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        VariableDefinition var = generateObjectIdentifier(ctx.OBJECT_IDENTIFIER(), variablesCache);
        generateStatement(ctx.statement(), variablesCache);

        // Add store instruction for assign and get the variable for next use
        llvmOutput.append(indents).append("; Assign\n");
        if (!var.name.equals("self"))
            llvmOutput.append(indents).append("store ").append(vsopTypeToLlvmType(var.type)).append(isPrimitive(var.type) ? "" : "*")
                    .append(" %").append(lastInstructionId).append(", ").append(vsopTypeToLlvmType(var.type)).append(isPrimitive(var.type) ? "" : "*")
                    .append("* %").append(var.aliasAlocated).append("\n");
        else
            llvmOutput.append(indents).append("store ").append(vsopTypeToLlvmType(var.type)).append(isPrimitive(var.type) ? "" : "")
                    .append(" %").append(lastInstructionId).append(", ").append(vsopTypeToLlvmType(var.type)).append(isPrimitive(var.type) ? "" : "")
                    .append("* %").append(var.aliasAlocated).append("\n");

        llvmOutput.append(indents).append("\n");
        var = generateObjectIdentifier(ctx.OBJECT_IDENTIFIER(), variablesCache);
        return var;
    }

    /**
     * Generate object identifier
     * @param ctx
     * @param variablesCache
     * @return
     */
    private VariableDefinition generateObjectIdentifier(TerminalNode ctx, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        VariableDefinition var = checkVariableCacheForIdentifier(ctx.getText(), variablesCache);
        String varTypeFinal = var.type;
        String varAllocFinal = var.aliasAlocated;
        String varType = vsopTypeToLlvmType(varTypeFinal);
        llvmOutput.append(indents).append("; ObjectIdentifier\n");
        String name = "";

        // If a call to self
        if (ctx.getText().equals("self")) {
            // Get first formal
            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = load ").append(varType)
                    .append("*, ").append(varType).append("** %").append(var.alias).append("\n");
            String heritageType = "";
            ParserRuleContext parentNode = (ParserRuleContext) ctx.getParent();
            while (!(parentNode instanceof LetContext) && !(parentNode instanceof MethodDefinitionContext) ) {
                parentNode = parentNode.getParent();
            }

            if (parentNode instanceof  LetContext) {
                heritageType = ((LetContext) parentNode).varType().getText();
            }
            else if (parentNode instanceof MethodDefinitionContext) {
                heritageType = ((MethodDefinitionContext) parentNode).varType().getText();
            }

            // Add getelementptr inbounds if variable is in parent
            String tmpVarType = var.type;
            while (!tmpVarType.equals(heritageType)) {
                tmpVarType = classes.get(tmpVarType).extend;
                if (tmpVarType.equals("Object") || tmpVarType.equals(""))
                    break;
                llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = getelementptr inbounds ")
                        .append(varType).append(", ").append(varType).append("* %").append(lastInstructionId-1).append(", i32 0, i32 ").append(0).append("\n");
                varTypeFinal = classes.get(tmpVarType).name;
                varType = vsopTypeToLlvmType(varTypeFinal);

            }

            varAllocFinal = String.valueOf(lastInstructionId);
        }
        // If variable is a field
        else if (var.name.equals("self")) {
            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = load ").append(varType)
                    .append("*, ").append(varType).append("** %").append(var.alias).append("\n");

            // Get field in class or parent
            FieldDefinition fieldToCheck = null;
            String tmpVarType = var.type;
            do {
                fieldToCheck = classes.get(tmpVarType).fields.get(ctx.getText());
                if (fieldToCheck == null) {
                    tmpVarType = classes.get(tmpVarType).extend;
                    if (tmpVarType.equals("Object") || tmpVarType.equals(""))
                        break;
                    llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = getelementptr inbounds ")
                            .append(varType).append(", ").append(varType).append("* %").append(lastInstructionId-1).append(", i32 0, i32 ").append(0).append("\n");
                    varTypeFinal = classes.get(tmpVarType).name;
                    varType = vsopTypeToLlvmType(varTypeFinal);
                }
            } while (fieldToCheck == null);

            // Load the field
            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = getelementptr inbounds ")
                    .append(varType).append(", ").append(varType).append("* %").append(lastInstructionId-1).append(", i32 0, i32 ")
                    .append(fieldToCheck.position).append("\n");
            varAllocFinal = String.valueOf(lastInstructionId);
            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = load ").append(vsopTypeToLlvmType(fieldToCheck.type))
                    .append(", ").append(vsopTypeToLlvmType(fieldToCheck.type)).append("* %").append(lastInstructionId-1).append("\n");
            varTypeFinal = fieldToCheck.type;
            name = "self";

        } else {
            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = load ").append(varType)
                    .append(isPrimitive(varTypeFinal) ? "" : "*").append(", ").append(varType).append(isPrimitive(varTypeFinal) ? "" : "*").append("* %").append(var.alias).append("\n");
            varAllocFinal = var.alias;
        }

        llvmOutput.append("\n");
        return new VariableDefinition(name, String.valueOf(lastInstructionId), varTypeFinal, varAllocFinal);
    }

    /**
     * Generate var value
     * @param ctx
     * @param variablesCache
     * @return
     */
    private VariableDefinition generateVarValue(VarValueContext ctx, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        VariableDefinition returnVar = new VariableDefinition("", "", "", "");
        String typeFound = "";
        String text = ctx.getText();
        int returnInstruction = -1;

        if (ctx.integer() != null) {
            typeFound = "int32";
        } else if (ctx.STRING() != null) {
            typeFound = "string";
        } else if (ctx.getText().equals("true") || ctx.getText().equals("false")) {
            typeFound = "bool";
        } else if (ctx.VOID_OPERATOR() != null) {
            typeFound = "unit";
            return new VariableDefinition("", String.valueOf(lastInstructionId), typeFound, "");
        }

        // For boolean
        if (ctx.getText().equals("true")) {
            text = "1";
        } else if (ctx.getText().equals("false")) {
            text = "0";
        }

        int varId = ++lastInstructionId;
        llvmOutput.append(indents).append("; VarValue\n");

        // Need more instructions for string
        if (ctx.STRING() != null) {
            int strLength = ctx.STRING().getText().length() - 1;
            String str = ctx.STRING().getText().substring(1, strLength);
            strLength = countRemovedSpecialChar(str) + 1;
            str = removeSpecialChar(str);

            if (this.isInFieldInitializer) {
                // Put on heap
                llvmOutput.append(indents).append("%").append(varId).append(" = call noalias i8* @malloc(i64 ").append(strLength).append(") #3").append("\n");
                llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = bitcast i8* %").append(varId).append(" to [").append(strLength).append(" x i8]*").append("\n");
                llvmOutput.append(indents).append("store [").append(strLength).append(" x i8] c\"").append(str).append("\\00\"").append(", [").append(strLength).append(" x i8]* %").append(lastInstructionId).append("\n");
                returnInstruction = varId;

            } else {
                // Put on stack
                llvmOutput.append(indents).append("%").append(varId).append(" = alloca ").append("[").append(strLength)
                        .append(" x i8]").append("\n");
                llvmOutput.append(indents).append("store [").append(strLength).append(" x i8] c\"").append(str).append("\\00\", ")
                        .append("[").append(strLength).append(" x i8]* %").append(varId).append("\n");
                llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = bitcast [").append(strLength)
                        .append(" x i8]* %").append(varId).append(" to i8*").append("\n");
                returnInstruction = lastInstructionId;
            }

        } else {
            llvmOutput.append(indents).append("%").append(varId).append(" = alloca ").append(vsopTypeToLlvmType(typeFound))
                    .append(isPrimitive(typeFound) ? "" : "*").append("\n");
            llvmOutput.append(indents).append("store ").append(vsopTypeToLlvmType(typeFound)).append(isPrimitive(typeFound) ? "" : "*")
                    .append(" ").append(text).append(", ").append(vsopTypeToLlvmType(typeFound)).append(isPrimitive(typeFound) ? "" : "*")
                    .append("* %").append(varId).append("\n");
            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = load ").append(vsopTypeToLlvmType(typeFound))
                    .append(isPrimitive(typeFound) ? "" : "*").append(", ").append(vsopTypeToLlvmType(typeFound))
                    .append(isPrimitive(typeFound) ? "" : "*").append("* %").append(varId).append("\n");
            returnInstruction = lastInstructionId;
        }

        llvmOutput.append(indents).append("\n");

        returnVar.value = text;
        returnVar.type = typeFound;
        returnVar.alias = String.valueOf(returnInstruction);
        return returnVar;
    }

    /**
     * Generate new obj
     * @param ctx
     * @param variablesCache
     * @return
     */
    private VariableDefinition generateNewObj(NewObjContext ctx, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        String objType = ctx.TYPE_IDENTIFIER().getText();
        llvmOutput.append(indents).append("; New").append("\n");
        llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = alloca ").append(vsopTypeToLlvmType(objType))
                .append("*").append("\n");
        llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = call ").append(vsopTypeToLlvmType(objType))
                .append("* @").append(objType).append("_new()").append("\n");
        llvmOutput.append(indents).append("store ").append(vsopTypeToLlvmType(objType)).append("* %").append(lastInstructionId)
                .append(", ").append(vsopTypeToLlvmType(objType)).append("** %").append(lastInstructionId-1).append("\n");
        llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = load ").append(vsopTypeToLlvmType(objType))
                .append(", ").append(vsopTypeToLlvmType(objType)).append("* %").append(lastInstructionId-1);

        //%7 = load %struct.MightyClass, %struct.MightyClass* %6
        llvmOutput.append("\n");
        return new VariableDefinition("", String.valueOf(lastInstructionId), objType, String.valueOf(lastInstructionId-1));
    }

    /**
     * Generate call method
     * @param ctx
     * @param variablesCache
     * @return
     */
    private VariableDefinition generateCallMethod(CallMethodContext ctx, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        VariableDefinition returnVar = null;
        for (SingleCallMethodContext call : ctx.singleCallMethod()) {
            returnVar = generateSingleCallMethod(call, variablesCache);
        }

        return returnVar;
    }

    /**
     * Generate every subcall
     * @param ctx
     * @param variablesCache
     * @return
     */
    private VariableDefinition generateSingleCallMethod(SingleCallMethodContext ctx, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        VariableDefinition returnCall = null;
        String classType = "";
        String firstCaller = "";

        llvmOutput.append(indents).append("; Call Method\n");

        // If there is no caller or caller is self, mean method is in self or super
        if (ctx.caller().size() == 0 || (ctx.caller().size() == 1
                &&  ctx.caller(0).OBJECT_IDENTIFIER() != null
                && ctx.caller(0).OBJECT_IDENTIFIER().getText().equals("self"))) {
            VariableDefinition lastCaller = checkVariableCacheForIdentifier("self", variablesCache);
            String varType = vsopTypeToLlvmType(lastCaller.type);
            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = load ").append(varType)
                    .append(isPrimitive(lastCaller.type) ? "" : "*").append(", ").append(varType).append(isPrimitive(lastCaller.type) ? "" : "*")
                    .append("* %").append(lastCaller.alias).append("\n");

            // Find method in self or parent
            MethodDefinition methodToCheck = null;
            classType = lastCaller.type;
            do {
                methodToCheck = classes.get(classType).methods.get(ctx.callFunction(0).OBJECT_IDENTIFIER().getText());
                if (methodToCheck == null) {
                    classType = classes.get(classType).extend;
                    if (classType.equals("Object") || classType.equals(""))
                        break;
                    llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = getelementptr inbounds ")
                            .append(varType).append(", ").append(varType).append("* %").append(lastInstructionId-1).append(", i32 0, i32 ").append(0).append("\n");
                    varType = vsopTypeToLlvmType(classes.get(classType).name);
                }
            } while (methodToCheck == null);

            firstCaller = String.valueOf(lastInstructionId);
        } else {
            // If multiple caller
            VariableDefinition lastCaller = null;
            for (CallerContext caller : ctx.caller()) {
                lastCaller = generateCaller(caller, lastCaller, variablesCache);
            }

            firstCaller = lastCaller.alias;
            classType = lastCaller.type;
        }

        // Generate every call function. Last call is the return type
        for (CallFunctionContext callFunction : ctx.callFunction()) {
            returnCall = generateCallFunction(callFunction, firstCaller, classType, variablesCache);
            firstCaller = returnCall.alias;
            classType = returnCall.type;

            if (isPrimitive(classType))
                break;
        }

        llvmOutput.append("\n");
        return returnCall;
    }

    /**
     * Generate every caller
     * @param ctx
     * @param variablesCache
     * @return
     */
    private VariableDefinition generateCaller(CallerContext ctx, VariableDefinition self, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        VariableDefinition returnVar = null;
        // According to caller's type
        if (ctx.newObj() != null) {
            returnVar = generateNewObj(ctx.newObj(), variablesCache);
            returnVar.alias = returnVar.aliasAlocated;
        } else if (ctx.OBJECT_IDENTIFIER() != null) {
            if (self == null) {
                // If a variable
                returnVar = generateObjectIdentifier(ctx.OBJECT_IDENTIFIER(), variablesCache);
                if (returnVar.name.equals("self"))
                    returnVar.alias = returnVar.aliasAlocated;

            } else {
                // Look into fields
                String vsopVarType = vsopTypeToLlvmType(self.type);
                FieldDefinition fieldToCheck = classes.get(self.type).fields.get(ctx.OBJECT_IDENTIFIER().getText());
                llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = getelementptr inbounds ")
                        .append(vsopVarType).append(", ").append(vsopVarType).append("* %").append(lastInstructionId-1)
                        .append(", i32 0, i32 ").append(fieldToCheck.position).append("\n");

                returnVar = new VariableDefinition("", String.valueOf(lastInstructionId), fieldToCheck.type, "");
                // TODO : check for inheritance
            }
        } else if (ctx.ifStatement() != null) {
            returnVar = generateIfStatement(ctx.ifStatement(), variablesCache);
        }

        return returnVar;
    }

    /**
     * Generate every method dispatch
     * @param ctx
     * @param variablesCache
     * @return
     */
    private VariableDefinition generateCallFunction(CallFunctionContext ctx, String selfId, String selfType, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        MethodDefinition methodToCheck = null;

        // Check for the method in self or parent
        do {
            methodToCheck = classes.get(selfType).methods.get(ctx.OBJECT_IDENTIFIER().getText());

            if (methodToCheck == null) {
                 String nextType = classes.get(selfType).extend;
                 if (nextType.equals("Object") || nextType.equals("")) {
                     // Mean method not found
                     return null;
                 }
                llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = getelementptr inbounds ")
                        .append(vsopTypeToLlvmType(selfType)).append(", ").append(vsopTypeToLlvmType(selfType)).append("* %")
                        .append(lastInstructionId-1).append(", i32 0, i32 ").append(0).append("\n");
                selfId = String.valueOf(lastInstructionId);
                selfType = nextType;
            }
        } while (methodToCheck == null);


        StringBuilder formalStr = new StringBuilder();
        // Generate Formals
        List<FormalDefinition> formals = new ArrayList<>(methodToCheck.formals.values());
        Collections.sort(formals, Comparator.comparingInt(FormalDefinition::getPosition));
        int j = 0;
        if (formals.size() > 0) llvmOutput.append(indents).append("; Arguments").append("\n");
        for (FormalDefinition formal : formals) {
            ArgumentContext arg = ctx.argument(j++);
            VariableDefinition argType = generateStatement(arg.statement(), variablesCache);

            if (arg.statement().newObj() != null)
                formalStr.append(", ").append(vsopTypeToLlvmType(argType.type)).append(isPrimitive(argType.type) ? "" : "*")
                        .append(" %").append(argType.aliasAlocated);
            else
                formalStr.append(", ").append(vsopTypeToLlvmType(argType.type)).append(isPrimitive(argType.type) ? "" : "*")
                        .append(" %").append(isPrimitive(argType.type) ? argType.alias : argType.alias);
        }

        // Find function to get type
        if (methodToCheck.type.equals("unit"))
            llvmOutput.append(indents).append("call ").append(vsopTypeToLlvmType(methodToCheck.type)).append(" @")
                    .append(selfType).append("_").append(methodToCheck.name).append("(").append(vsopTypeToLlvmType(selfType))
                    .append(isPrimitive(selfType) ? "" : "*").append(" %").append(selfId).append(formalStr).append(")").append("\n");
        else
            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = ").append("call ")
                    .append(vsopTypeToLlvmType(methodToCheck.type)).append(isPrimitive(methodToCheck.type) ? "" : "*").append(" @")
                    .append(selfType).append("_").append(methodToCheck.name).append("(").append(vsopTypeToLlvmType(selfType))
                    .append(isPrimitive(selfType) ? "" : "*").append(" %").append(selfId).append(formalStr).append(")").append("\n");


        return new VariableDefinition("", String.valueOf(lastInstructionId), methodToCheck.type, "");
    }

    /**
     * Generate binary operation
     * @param ctx
     * @param variablesCache
     * @return
     */
    private VariableDefinition generateBinaryOperation(BinaryOperationContext ctx, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        // Handle the binary operation
        return handleExpr1(ctx.expr1(), variablesCache);
    }

    /**
     * Generate and expression type
     * @param expr1
     * @param variablesCache
     * @return
     */
    private VariableDefinition handleExpr1(Expr1Context expr1, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        // Handle and operation
        if (expr1.expr1() != null) {
            VariableDefinition var1 = handleExpr1(expr1.expr1(), variablesCache);
            if (var1.type.equals("bool") && var1.value.equals("1")) {
                VariableDefinition var2 = handleExpr2(expr1.expr2(), variablesCache);

                llvmOutput.append(indents).append("; And\n");
                llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = and i1 %").append(var1.alias)
                        .append(", %").append(var2.alias).append("\n");
                llvmOutput.append("\n");
            }
        } else
            return handleExpr2(expr1.expr2(), variablesCache);

        return new VariableDefinition("", String.valueOf(lastInstructionId), "bool", "");
    }

    /**
     * Generate not expression type
     * @param expr2
     * @param variablesCache
     * @return
     */
    private VariableDefinition handleExpr2(Expr2Context expr2, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        // Handle not operation
        if (expr2.expr2() != null) {
            VariableDefinition var1 = handleExpr2(expr2.expr2(), variablesCache);
            int notTrue = ++lastGotoId;
            int notFalse = lastGotoId;
            int notEnd = lastGotoId;

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

    /**
     * Generate comparator expression type
     * @param expr3
     * @param variablesCache
     * @return
     */
    private VariableDefinition handleExpr3(Expr3Context expr3, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        // Handle comparator (<, <=, =, !=, >=, >) operation
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
                    llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = call i32 @strcmp(i8* ")
                            .append(alias1).append(", i8* ").append(alias2).append(") #2").append("\n");
                    alias1 = "%" + lastInstructionId;
                    alias2 = "0";
                } else if (id1.type.equals("unit") && id2.type.equals("unit")) {
                    alias1 = "0";
                    alias2 = "0";
                }
            }

            llvmOutput.append(indents).append("%").append(++lastInstructionId).append(" = icmp ").append(operator).append(" ").append(type).append(" ").append(alias1).append(", ").append(alias2).append("\n");
            llvmOutput.append("\n");

        } else
            return handleExpr4(expr3.expr4(0), variablesCache);

        return new VariableDefinition("", String.valueOf(lastInstructionId), "bool", "");
    }

    /**
     * Generate term operator expression type
     * @param expr4
     * @param variablesCache
     * @return
     */
    private VariableDefinition handleExpr4(Expr4Context expr4, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        // Handle term operation (-, +)
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

    /**
     * Generate factor operator expression type
     * @param expr5
     * @param variablesCache
     * @return
     */
    private VariableDefinition handleExpr5(Expr5Context expr5, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        // Handle factor operation (*, /)
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

    /**
     * Generate negative and isnull type
     * @param expr6
     * @param variablesCache
     * @return
     */
    private VariableDefinition handleExpr6(Expr6Context expr6, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        String returnType = "";
        // Handle negative and isnull operation
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

    /**
     * Generate pow operation type
     * @param expr7
     * @param variablesCache
     * @return
     */
    private VariableDefinition handleExpr7(Expr7Context expr7, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        // Handle pow operation
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

    /**
     * Generate every possible value type
     * @param expr8
     * @param variablesCache
     * @return
     */
    private VariableDefinition handleExpr8(Expr8Context expr8, ArrayList<Map<String, VariableDefinition>> variablesCache) {
        // Handle for each type of possible value
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
        else if (expr8.OBJECT_IDENTIFIER() != null)
            return generateObjectIdentifier(expr8.OBJECT_IDENTIFIER(), variablesCache);
        else if (expr8.block() != null)
            return generateBlock(expr8.block(), variablesCache);

        return new VariableDefinition("", "", "", "");
    }


    /**
     * Transform VSOP type to LLVM type
     * @param type
     * @return
     */
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
                return "%struct." + type + "";
        }
    }

    /**
     * Check if var type is primitive
     * @param varType
     * @return
     */
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

    /**
     * Get default value of a var
     * @param type
     * @return
     */
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

    /**
     * Append a title to a new section
     * @param title
     */
    private void appendSectionHeader(String title) {
        llvmOutput.append(indents).append("; \n");
        llvmOutput.append(indents).append("; ").append(title).append("\n");
        llvmOutput.append(indents).append("; \n");
    }

    /**
     * Check variable cache for a variable
     * @param identifier
     * @param variablesCache
     * @return
     */
    private VariableDefinition checkVariableCacheForIdentifier(String identifier, ArrayList<Map<String, VariableDefinition>> variablesCache)  {
        VariableDefinition varFound = null;

        // Look for a specific variable
        if (variablesCache != null) {
            for (int i = variablesCache.size() - 1; i >= 0; i--) {
                if (variablesCache.get(i).containsKey(identifier)) {
                    varFound = variablesCache.get(i).get(identifier);
                    break;
                }
            }
        }

        // If not found, get self variable
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

    /**
     * Count the number of removed special char to adjust the length we need to allocate for a string
     * @param str
     * @return
     */
    private int countRemovedSpecialChar(String str) {
        int finalLength = str.length();
        HashMap<String, String> characterEscape = new HashMap<>();
        characterEscape.put("\\x08", "\\08");
        characterEscape.put("\\x09", "\\09");
        characterEscape.put("\\x0a", "\\0a");
        characterEscape.put("\\x0d", "\\0d");
        characterEscape.put("\\\\", "\\5c");
        characterEscape.put("\\\"", "\\22");

        // Escape Character
        for (Map.Entry<String, String> escape : characterEscape.entrySet()) {
            int i = 0;
            while((i = str.indexOf(escape.getKey(), i)) != -1) {
                i += escape.getKey().length();
                finalLength += -escape.getKey().length() + 1;
            }
            str = str.replace(escape.getKey(), escape.getValue());
        }

        int i = 0;
        while((i = str.indexOf("\\x", i)) != -1) {
            i += "\\x".length();
            finalLength -= 3;
        }

        return finalLength;
    }

    /**
     * Ajust a string for llvm. Removing \x?? in escape sequence
     * @param str
     * @return
     */
    private String removeSpecialChar(String str) {
        HashMap<String, String> characterEscape = new HashMap<>();
        characterEscape.put("\\x08", "\\08");
        characterEscape.put("\\x09", "\\09");
        characterEscape.put("\\x0a", "\\0a");
        characterEscape.put("\\x0d", "\\0d");
        characterEscape.put("\\\\", "\\5c");
        characterEscape.put("\\\"", "\\22");
        characterEscape.put("\\x", "\\");

        // Escape Character
        for (Map.Entry<String, String> escape : characterEscape.entrySet()) {
            str = str.replace(escape.getKey(), escape.getValue());
        }

        return str;
    }

    /**
     * Look for inhertiance between two objects
     * @param parent
     * @param child
     * @return
     */
    private boolean lookForInheritance(String parent, String child) {
        ClassDefinition classToCheck =  classes.get(child);
        if (classToCheck != null) {
            while (true) {
                if (parent.equals(classToCheck.name) && !parent.equals(""))
                    return true;

                if (classes.containsKey(classToCheck.extend))
                    classToCheck = classes.get(classToCheck.extend);
                else if (classToCheck.extend.equals("")) {
                    break;
                }
            }
        }

        return false;
    }

//endregion

}
