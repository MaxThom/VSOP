grammar PARSER;
@header {package VSOP.Parser;}
    program     : statement+ ;

    statement   : assign | ifStatement | whileStatement;



    assign                  : OBJECT_IDENTIFIER ':' varType ('<-' ('true' | 'false' | STRING | integer))? ;


    whileStatement          : 'while' condition* 'do' statement* ;


    ifStatement             : ifStat elseStat? ; //ifStat elseIfStat* elseStat? ;
    ifStat                  : 'if' condition 'then' statement* ;
    //elseIfStat              : 'else if' condition 'then' '{' statement* '}' ;
    elseStat                : 'else' statement* ;

    condition               : comparaiser CONDITIONAL_OPERATOR comparaiser ;
    comparaiser             : OBJECT_IDENTIFIER | integer | STRING ;
    integer                 : INTEGER_HEX | INTEGER_DEC | INTEGER_BIN ;
    varType                 : 'bool' | 'int32' | 'string' | 'unit' | TYPE_IDENTIFIER ;


   // KEYWORD                 : 'and' | 'class' | 'do' | 'else' | 'extends' | 'false' | 'if' | 'in' | 'isnull' | 'let' | 'new' | 'not' | 'then' | 'true' | 'unit' | 'while' ;
    MULTILINE_OPEN_COMMENT  : '(*' ;
    MULTILINE_CLOSE_COMMENT : '*)' ;
    MULTILINE_COMMENT       : '(*' .*? '*)' ;
    INTEGER_BIN             : '0'[bB][0-9a-zA-Z]* ;
    INTEGER_HEX             : '0'[xX][0-9a-zA-Z]* ;
    INTEGER_DEC             : [0-9][0-9a-zA-Z]* ;

    OBJECT_IDENTIFIER       : [a-z][a-zA-Z0-9_]* ;
    TYPE_IDENTIFIER         : [A-Z][a-zA-Z0-9_]* ;
    STRING                  : '"' ( '\\"' | . )*? ('"' | EOF) ;
    SINGLE_LINE_COMMENT     : '//'~[\r\n]* ; //'//'.* -> skip ; //'//'[ a-zA-Z0-9_]* -> skip ;
    OPERATOR                : '{' | '}' | '(' | ')' | ':' | ';' | ',' | '+' | '-' | '*' | '/' | '^' | '.' | '<-' ;
    CONDITIONAL_OPERATOR    : '=' | '<' | '<=';
    WS                      : [ \r\n\t]+ -> skip;



    //id        : ID ;
    //assign    : 'let' ID 'be' (NUMBER | ID) ;
    //print     : 'print' (NUMBER | ID | TEXT) ;
    //add       : 'add' (NUMBER | ID) 'to' ID ;