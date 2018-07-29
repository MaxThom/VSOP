grammar PARSER;
@header {package VSOP.Parser;}
    program                 : code+ ; //statement+ ;

    code                    : classHeader | methodHeader | statement ; //TODO REMOVE STATEMENT
    statement               : assign | ifStatement | whileStatement;

    classHeader             : 'class' TYPE_IDENTIFIER ('extends' TYPE_IDENTIFIER)? '{' classBody* '}';
    classBody               : methodHeader | field;

    methodHeader            : OBJECT_IDENTIFIER '(' (((formal ',')+ (formal)) | (formal)?) ')' ':' varType '{' methodBody* '}' ;
    methodBody              : statement ;
    formal                  : OBJECT_IDENTIFIER ':' varType ;
    field                   : OBJECT_IDENTIFIER ':' varType ('<-' varValue)? ';' ;



    assign                  : OBJECT_IDENTIFIER ':' varType ('<-' varValue)? ;

    whileStatement          : 'while' condition* 'do' statement* ;

    ifStatement             : ifStat elseStat? ; //ifStat elseIfStat* elseStat? ;
    ifStat                  : 'if' condition 'then' statement* ;
    //elseIfStat              : 'else if' condition 'then' '{' statement* '}' ;
    elseStat                : 'else' statement* ;

    condition               : comparaiser CONDITIONAL_OPERATOR comparaiser ;
    comparaiser             : OBJECT_IDENTIFIER | integer | STRING ;
    integer                 : INTEGER_HEX | INTEGER_DEC | INTEGER_BIN ;
    varType                 : 'bool' | 'int32' | 'string' | 'unit' | TYPE_IDENTIFIER ;
    varValue                : ('true' | 'false' | STRING | integer) ;


   // KEYWORD                 : 'and' | 'class' | 'do' | 'else' | 'extends' | 'false' | 'if' | 'in' | 'isnull' | 'let' | 'new' | 'not' | 'then' | 'true' | 'unit' | 'while' ;
    ARITHMETIC_OPERATOR     : '+' | '-' | '*' | '/' | '^' ;
    CONDITIONAL_OPERATOR    : '=' | '<' | '<=';
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
