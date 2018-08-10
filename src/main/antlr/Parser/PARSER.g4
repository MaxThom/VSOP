grammar PARSER;
@header {package VSOP.Parser;}
    program                 : (classDefinition)+ ; // | methodDefinition | statement)+ ; //TODO REMOVE STATEMENT

    statement               : assign | ifStatement | whileStatement | let | callMethod | newObj | OBJECT_IDENTIFIER | varValue | ('(' statement ')') | binaryOperation | unOperation;
    block                   : '{' (((statement | block) | (((statement ';') | whileStatement | ifStatement)+ (statement | block) ))?) '}' ;

    classDefinition         : 'class' TYPE_IDENTIFIER ('extends' TYPE_IDENTIFIER)? '{' (methodDefinition | field)* '}' ;

    methodDefinition        : OBJECT_IDENTIFIER ('(' ((((formal ',')+ (formal)) | (formal)?) ')') | ('()')) ':' varType block ;
    formal                  : OBJECT_IDENTIFIER ':' varType ;
    field                   : OBJECT_IDENTIFIER ':' varType ('<-' (statement | block))? ';' ;
    callMethod              : (singleCallMethod) | ((singleCallMethod  '.')+ (singleCallMethod));
    singleCallMethod        : (caller)* callFunction ('.' callFunction)* ;
    caller                  : (OBJECT_IDENTIFIER | ('(' newObj ')')) '.';
    callFunction            : OBJECT_IDENTIFIER (('(' (((argument ',')+ argument) | argument?) ')') | ('()')) ;
    argument                : OBJECT_IDENTIFIER | varValue | callMethod | newObj | binaryOperation;


    assign                  : OBJECT_IDENTIFIER '<-' statement ;

    whileStatement          : 'while' statement 'do' (statement | block) ;

    ifStatement             : ifStat elseStat? ; //ifStat elseIfStat* elseStat? ;
    ifStat                  : 'if' statement 'then' (statement | block) ;
    //elseIfStat              : 'else if' condition 'then' block ;
    elseStat                : 'else' (statement | block) ;

    let                     : 'let' OBJECT_IDENTIFIER ':' varType ('<-' statement)? 'in' (statement | block) ;

    //binaryOperation         : (OBJECT_IDENTIFIER | varValue) ((ARITHMETIC_OPERATOR | CONDITIONAL_OPERATOR) statement)+ ;

    binaryOperation         : condition (AND_OPERATOR condition)* | ('(' condition (AND_OPERATOR condition)* ')') ;
    condition               : term (CONDITIONAL_OPERATOR term)* | ('(' term (CONDITIONAL_OPERATOR term)* ')') ;
    term                    : factor (termOperator factor)* | ('(' factor (termOperator factor)* ')') ;
    factor                  : (value (FACTOR_OPERATOR value)*) | ('(' value (FACTOR_OPERATOR value)* ')') ;
    value                   : unOperation | OBJECT_IDENTIFIER | varValue | callMethod | VOID_OPERATOR;

    unOperation             : unOperator (condition | statement) ;

    newObj                  : 'new' TYPE_IDENTIFIER ;

    unOperator              : UN_OPERATOR | NEGATIVE_OPERATOR ;
    termOperator            : TERM_OPERATOR | NEGATIVE_OPERATOR ;
    //condition               : comparaiser CONDITIONAL_OPERATOR comparaiser ;
    comparaiser             : OBJECT_IDENTIFIER | integer | STRING ;
    integer                 : INTEGER_HEX | INTEGER_DEC | INTEGER_BIN ;
    varType                 : 'bool' | 'int32' | 'string' | 'unit' | TYPE_IDENTIFIER ;
    varValue                : 'true' | 'false' | STRING | integer  ;

    UN_OPERATOR             : 'not' | 'isnull' ;
    //ARITHMETIC_OPERATOR     : '+' | '-' | '*' | '/' | '^' ;
    FACTOR_OPERATOR         : 'd zzdqasdw' ;
    TERM_OPERATOR           : '+' | '*' | '/' | '^';
    AND_OPERATOR            : 'and' ;
    CONDITIONAL_OPERATOR    : '=' | '<' | '<=' ;
    NEGATIVE_OPERATOR       : '-' ;
    VOID_OPERATOR           : '()' ;

    MULTILINE_OPEN_COMMENT  : '(*' ;
    MULTILINE_CLOSE_COMMENT : '*)' ;
    MULTILINE_COMMENT       : '(*' .*? '*)' ;
    INTEGER_BIN             : '0'[bB][0-9a-zA-Z]* ;
    INTEGER_HEX             : '0'[xX][0-9a-zA-Z]* ;
    INTEGER_DEC             : [0-9][0-9a-zA-Z]* ;

    OBJECT_IDENTIFIER       : [a-z][a-zA-Z0-9_]* ;
    TYPE_IDENTIFIER         : [A-Z][a-zA-Z0-9_]* ;
    STRING                  : '"' ( '\\"' | . )*? ('"' | EOF) ;
    SINGLE_LINE_COMMENT     : '//'~[\r\n]* ;
    WS                      : [ \r\n\t]+ -> skip;
