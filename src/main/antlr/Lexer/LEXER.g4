grammar LEXER;
@header {package VSOP.Lexer;}
    program   : statement+ ;

    statement : keyword | operator | integer | objectIdentifier | typeIdentifier | string ;

    keyword                 : KEYWORD ;
    operator                : OPERATOR ;
    integer                 : (INTEGER_BIN | INTEGER_HEX | INTEGER_DEC) ;
    objectIdentifier        : OBJECT_IDENTIFIER ;
    typeIdentifier          : TYPE_IDENTIFIER ;
    string                  : STRING ;

    KEYWORD                 : 'and' | 'bool' | 'class' | 'do' | 'else' | 'extends' | 'false' | 'if' | 'in' | 'int32' | 'isnull' | 'let' | 'new' | 'not' | 'string' | 'then' | 'true' | 'unit' | 'while' ;
    OPERATOR                : '{' | '}' | '(' | ')' | ':' | ';' | ',' | '+' | '-' | '*' | '/' | '^' | '.' | '=' | '<' | '<=' | '<-' ;
    INTEGER_BIN             : '0'[bB][0-9a-zA-Z]* ;
    INTEGER_HEX             : '0'[xX][0-9a-zA-Z]* ;
    INTEGER_DEC             : [0-9][0-9a-zA-Z]* ;
    OBJECT_IDENTIFIER       : [a-z][a-zA-Z0-9_]* ;
    TYPE_IDENTIFIER         : [A-Z][a-zA-Z0-9_]* ;
    STRING                  : '"' ( '\\"' | . )*? '"' ;
    WS                      : [ \r\n\t]+ -> skip;


