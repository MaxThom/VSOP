
import CodeGeneration.CodeGenerationListener;
import Lexer.LexerErrorListener;
import Lexer.LexerListener;
import Parser.ParserErrorListener;
import Parser.ParserListener;
import Semantic.*;
import VSOP.CodeGeneration.CODELexer;
import VSOP.CodeGeneration.CODEParser;
import VSOP.Lexer.LEXERLexer;
import VSOP.Lexer.LEXERParser;
import VSOP.Parser.PARSERLexer;
import VSOP.Parser.PARSERParser;
import VSOP.Semantic.SEMANTICLexer;
import VSOP.Semantic.SEMANTICParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Main entry for the VSOP compiler
 */
public class Main {

    /**
     * Main methods. Receive arguments and dispatch
     * @param args
     */
    public static void main(String[] args) {
        try {
            int exitCode = 0;
            if (args.length == 0) {
                System.out.println("Error : Missing correct arguments");
                System.exit(1);
            }

            File file = new File(args[args.length-1]);
            // Analyze arguments and call right method
            switch (args[0]) {
                case "-lex":
                    exitCode = startLexer(file, true);
                    break;
                case "-parse":
                    exitCode = startParser(file, true);
                    break;
                case "-check":
                    exitCode = startSemantic(file, true);
                    break;
                case "-llvm":
                    exitCode = startCodeGeneration(file, true, false);
                    break;
                default:
                    exitCode = startProgram(file, args[0].equals("-v") || args[0].equals("-visual"));
                    break;
            }
            System.exit(exitCode);
        } catch (IOException e) {
            System.err.println("IO Exception : " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unknown Exception : " + e.getMessage());
        }
    }

    /**
     * Call every part of the compiler
     * @param file
     * @param displayVisual
     * @return
     * @throws IOException
     */
    private static int startProgram(File file, boolean displayVisual) throws IOException {
        int exitCode = 0;

        if (displayVisual) {
            System.out.println("======================");
            System.out.println("= LEXER ==============");
            System.out.println("======================");
        }
        exitCode = startLexer(file, displayVisual);

        if (exitCode == 0) {
            if (displayVisual) {
                System.out.println("======================");
                System.out.println("= PARSER =============");
                System.out.println("======================");
            }

            exitCode = startParser(file, displayVisual);
        }

        if (exitCode == 0) {
            if (displayVisual) {
                System.out.println("======================");
                System.out.println("= SEMANTIC ===========");
                System.out.println("======================");
            }

            exitCode = startSemantic(file, displayVisual);
        }

        if (exitCode == 0) {
            if (displayVisual) {
                System.out.println("======================");
                System.out.println("= CODE GENERATION ====");
                System.out.println("======================");
            }

            exitCode = startCodeGeneration(file, displayVisual, true);
        }

        return exitCode;
    }

    /**
     * Call the lexer part
     * @param file
     * @param displayVisual
     * @return
     * @throws IOException
     */
    private static int startLexer(File file, boolean displayVisual) throws IOException {
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(file));
        LEXERLexer lexer = new LEXERLexer(input);
        lexer.removeErrorListeners();
        lexer.addErrorListener(LexerErrorListener.getInstance(file.getName()));
        LEXERParser parser = new LEXERParser(new CommonTokenStream(lexer));
        LexerListener listener = new LexerListener(file.getName());
        parser.addParseListener(listener);
        parser.removeErrorListeners();
        parser.addErrorListener(LexerErrorListener.getInstance(file.getName()));

        // Start parsing
        parser.program();

        // Display results
        if (displayVisual) {
            for (String token : listener.tokenOutput) {
                System.out.println(token);
            }
        }
        for (String token : listener.errorOutput) {
            System.err.println(token);
        }

        return LexerErrorListener.getInstance("").inError ? 1 : (listener.lexicalError ? 1 : 0) ;
    }

    /**
     * Call the parser part
     * @param file
     * @param displayVisual
     * @return
     * @throws IOException
     */
    private static int startParser(File file, boolean displayVisual) throws IOException  {
        String text = removeSpecialChar(removeComments(file));

        ANTLRInputStream input = new ANTLRInputStream(text);//(new FileInputStream(file));
        PARSERLexer lexer = new PARSERLexer(input);
        lexer.removeErrorListeners();
        lexer.addErrorListener(ParserErrorListener.getInstance(file.getName()));

        PARSERParser parser = new PARSERParser(new CommonTokenStream(lexer));
        ParserListener listener = new ParserListener(file.getName());
        parser.addParseListener(listener);
        parser.removeErrorListeners();
        parser.addErrorListener(ParserErrorListener.getInstance(file.getName()));

        // Start parsing
        parser.program();

        // Display results
        if (parser.getNumberOfSyntaxErrors() == 0 && displayVisual)
            System.out.println(listener.treeOuput);

        return parser.getNumberOfSyntaxErrors();
    }

    /**
     * Call the semantic part
     * @param file
     * @param displayVisual
     * @return
     * @throws IOException
     */
    private static int startSemantic(File file, boolean displayVisual) throws IOException  {
        String text = removeSpecialChar(removeComments(file));

        ANTLRInputStream input = new ANTLRInputStream(text);
        SEMANTICLexer lexer = new SEMANTICLexer(input);
        lexer.removeErrorListeners();
        lexer.addErrorListener(SemanticErrorListener.getInstance(file.getName()));

        SEMANTICParser parser = new SEMANTICParser(new CommonTokenStream(lexer));
        SemanticListener listener = new SemanticListener(file.getName());
        listener.addLibrary(addIOClasses());
        listener.addLibrary(addObjectClasses());

        parser.addParseListener(listener);
        parser.removeErrorListeners();
        parser.addErrorListener(SemanticErrorListener.getInstance(file.getName()));

        // Start parsing
        parser.program();

        // Display results
        if (parser.getNumberOfSyntaxErrors() == 0 && displayVisual)
            System.out.println(listener.treeOutput.toString());

        // Display errors
        for (String token : listener.errorOutput) {
            System.err.println(token);
        }

        return parser.getNumberOfSyntaxErrors() + listener.errorOutput.size();
    }

    /**
     * Call the code generation part
     * @param file
     * @param displayVisual
     * @param generateLllvmFile
     * @return
     * @throws IOException
     */
    private static int startCodeGeneration(File file, boolean displayVisual, boolean generateLllvmFile) throws IOException  {

        String text = removeSpecialChar(removeComments(file));

        ANTLRInputStream input = new ANTLRInputStream(text);
        CODELexer lexer = new CODELexer(input);
        CODEParser parser = new CODEParser(new CommonTokenStream(lexer));
        CodeGenerationListener listener = new CodeGenerationListener(file.getName());
        parser.addParseListener(listener);

        // Start parsing
        parser.program();

        // Display results
        if (parser.getNumberOfSyntaxErrors() == 0 && displayVisual) {
            System.out.println(listener.llvmOutput.toString());
        }

        // Generate llvm file and executable
        if (generateLllvmFile) {
            createLlvmFile(file.getName(), listener.llvmOutput.toString(), displayVisual);
        }

        return parser.getNumberOfSyntaxErrors();
    }

    /**
     * Create llvm file with the results
     * @param fileName
     * @param input
     * @param displayVisual
     */
    private static void createLlvmFile(String fileName, String input, boolean displayVisual) {
        try {
            String name = fileName.substring(0, fileName.lastIndexOf("."));
            String path = "";
            File file = new File(path + name + ".ll");
            Files.deleteIfExists(file.toPath());
            if (!file.createNewFile()) {
                System.err.println("Can't generate LLVM file : impossible to create file");
            }

            FileWriter writer = new FileWriter(file);
            writer.write(input);
            writer.close();

            if (System.getProperty("os.name").trim().toLowerCase().equals("linux")) {
                generateExecutableFinal(name);
                if (displayVisual) {
                    System.out.println("======================");
                    System.out.println("= CODE EXECUTION =====");
                    System.out.println("======================");
                    executeFinal(name);
                }
            }
        } catch (Exception e) {
            System.err.println("Can't generate LLVM file : " + e.getMessage());
        }
    }

    /**
     * Generate an executable with the .ll file
     * @param fileName
     */
    private static void generateExecutableFinal(String fileName) {
        try
        {
            String command = "llvm-as -f " + fileName + ".ll -o " + fileName + ".bc" ;
            executeCommandAndListen(command);

            command = "llc " + fileName + ".bc";
            executeCommandAndListen(command);

            command = "gcc -c " + fileName + ".s -o " + fileName + ".o";
            executeCommandAndListen(command);

            command = "gcc " + fileName + ".o -lm -o " + fileName + " -no-pie";
            executeCommandAndListen(command);

            command = "rm " + fileName + ".bc";
            executeCommandAndListen(command);

            command = "rm " + fileName + ".s";
            executeCommandAndListen(command);

            command = "rm " + fileName + ".o";
            executeCommandAndListen(command);

            command = "rm " + fileName + ".ll";
            executeCommandAndListen(command);

        } catch (Exception e) {
            System.err.println("Can't generate LLVM file : " + e.getMessage());
        }
    }

    /**
     * Execute a command line command and Listen
     * @param command
     */
    private static void executeCommandAndListen(String command) {
        try
        {
            Process proc = Runtime.getRuntime().exec(command);
            proc.waitFor();

            BufferedReader buf = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = "";
            while ((line=buf.readLine())!=null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.err.println("Can't generate LLVM file : " + e.getMessage());
        }
    }

    /**
     * Execute executable
     * @param fileName
     */
    private static void executeFinal(String fileName) {
        try
        {
            String command = "./" + fileName;
            Process proc = Runtime.getRuntime().exec(command);
            proc.waitFor();

            BufferedReader buf = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = "";
            while ((line=buf.readLine())!=null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            System.err.println("Can't generate LLVM file : " + e.getMessage());
        }
    }

    /**
     * Remove special char in a file
     * @param file
     * @return
     */
    private static String removeSpecialChar(String file) {
        HashMap<String, String> characterEscape = new HashMap<>();
        characterEscape.put("\\b", "\\x08");
        characterEscape.put("\\t", "\\x09");
        characterEscape.put("\\n", "\\x0a");
        characterEscape.put("\\r", "\\x0d");

        // Escape Character
        for (Map.Entry<String, String> escape : characterEscape.entrySet()) {
            file = file.replace(escape.getKey(), escape.getValue());
        }

        // New Line
        String LINE_FEED_LIN = "\n";
        int nl = -1;
        while ((nl = file.indexOf(LINE_FEED_LIN, nl)) != -1) {
            int offsetWindows = 0;
            if ((nl - 1) >= 0 && file.charAt(nl - 1) == '\r')
                offsetWindows = 1;

            if ((nl - 1 - offsetWindows) >= 0 && file.charAt(nl - 1 - offsetWindows) == '\\') {
                int endIndex = nl + 1 + offsetWindows;
                while (file.charAt(endIndex) == ' ' || file.charAt(endIndex) == '\t')
                    endIndex++;
                file = file.substring(0, nl - 1 - offsetWindows) + file.substring(endIndex);
            }
            ++nl;
        }

        //Hexadecimal Character
        int hex = 0;
        while ((hex = file.indexOf("0x", hex)) != -1 ||
                (hex = file.indexOf("0X", hex)) != -1 ||
                (hex = file.indexOf("0b", hex)) != -1 ||
                (hex = file.indexOf("0B", hex)) != -1) {
            String hexNumber = "";
            try {

                while (file.substring(hex+2, hex+3).matches("[0-9a-zA-Z]")) {
                    hexNumber += file.substring(hex+2, hex+3);
                    ++hex;
                }

                int radix = file.charAt(hex - hexNumber.length() + 1) == 'x' || file.charAt(hex - hexNumber.length() + 1) == 'X' ? 16 : 2;
                int decimalValue = Integer.parseInt(hexNumber, radix);
                file = file.substring(0, hex - hexNumber.length()) + decimalValue + file.substring(hex + 2);
            } catch (Exception e) {

                break;
            }
        }

        return file;
    }

    /**
     * Remove comments in a file
     * @param file
     * @return
     */
    private static String removeComments(File file) {

        String text = "";
        boolean forgetSingle = false;
        Stack<Integer> comments = new Stack<>();

        // Remove Multiline
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            int c;
            while((c = reader.read()) != -1) {
                text += String.valueOf((char) c);
                if (text.length() >= 2 && text.charAt(text.length()-2) == '(' && text.charAt(text.length()-1) == '*') {
                    comments.push(text.length()-2);
                }
                else if (text.length() >= 2 && text.charAt(text.length()-2) == '*' && text.charAt(text.length()-1) == ')') {

                    text = text.substring(0, comments.pop()) + text.substring(text.length());
                }
            }
        }
        catch (IOException e) {

        }

        // Remove single line
        int i = 0;
        while ((i = text.indexOf("//", i)) != -1) {
            int nl = text.indexOf("\n", i);
            if (nl == -1)
                text = text.substring(0, i);
            else
                text = text.substring(0, i) + text.substring(nl);
        }

        return text;
    }

    /**
     * Add IO class
     * @return
     */
    private static ClassDefinition addIOClasses() {
        ClassDefinition ioClass = new ClassDefinition("IO", "Object");
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
     * Add Object class
     * @return
     */
    private static ClassDefinition addObjectClasses() {
        ClassDefinition objectClass = new ClassDefinition("Object", "");
        objectClass.classInitialized = true;
        return objectClass;
    }


}

