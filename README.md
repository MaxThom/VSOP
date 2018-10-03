# VSOP
Compiler for VSOP language using ANTLR and Java
Generate LLVM code to then compiled into an executable (on linux only)

---------------------------------------------------------------
The compiler is divided in four parts: lexical analysis, syntax analysis, semantic analysis and code generation in assembly. 

The first two parts of the compiler are to build the Abstract Syntax Tree (AST). 
To do so, the ANTLRv4 (ANother Tool for Language Recogntion) framework was used. 
It’s a powerful parser generator for reading and processing files. For every rule captured, 
it generates two methods: Enter (when we encounter the rule) and Exit (when everything under the rule has been parsed)
that the developer can override.

The third part was about doing the semantic check by analyzing the AST since VSOP is a statically and explicitly typed language. 
Finally, the code generation part is to generate the AST into an intermediary representation 
called LLVM IR that can be compiled into an executable.

---------------------------------------------------------------
What would have I done differently?

Now that my understanding of how to build a compiler is far better than at the beginning, I would change many things in every part.
Also, I understand much more all the tools I have used, ANTLR, LLVM IR, the AST, parser and lexer in general. How every part fit and could work together.

First, I will make every section of the compiler work together instead of being independent. 
In that view, I would keep only one .g4. The AST will only be generated once, and 
it will be passed to the other part as it is and not be generated each time.

Second, ANTLR create one class for every rule (node) of the AST. Using OOP, I would override every single class or using the visitor pattern to add a type field. This way, every node as his type defined directly when we generate the tree and the information is kept. Moving on the semantic check and code generation with the annotated AST, it will be easier to do the type checking and then to do the code generation.

Third, the classes definition with their fields and methods are generated in both semantic and code generation phase. This could be done directly in the parsing part and pass this information to the next parts. An object could encapsulate both the AST and the class definitions, and we pass this object to the other parts.

Fourth, the compiler is divided into steps. Each step is similar: to go through the AST and analyze all the rules in it. They all use the same principle and define the same methods explained in section 3.2. The idea is, by using the strategy and template method pattern, to build the compiler in a way to ease the evolution and the maintenance of the code. Moreover, it will help reduce code smell and if we need to add more steps, there is a structure ready to be used.

Overall, to improve the compiler, the two main ideas is to make every part work together to reduce code overhaul and to code the compiler in an oriented object programming way instead of a procedural approach.

 
