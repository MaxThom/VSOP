grammar LEXER;
@header {package VSOP.Lexer;}
    program   : statement+ ;

    statement : keyword | operator | integer | objectIdentifier | typeIdentifier | string | singleLineComment | multiLineComment ;

    keyword                 : KEYWORD ;

    integer                 : (INTEGER_BIN | INTEGER_HEX | INTEGER_DEC) ;
    objectIdentifier        : OBJECT_IDENTIFIER ;
    typeIdentifier          : TYPE_IDENTIFIER ;
    string                  : STRING ;
    singleLineComment       : SINGLE_LINE_COMMENT ;
    multiLineComment        : MULTILINE_COMMENT | MULTILINE_CLOSE_COMMENT |  MULTILINE_OPEN_COMMENT;
    operator                : OPERATOR ;

    KEYWORD                 : 'and' | 'bool' | 'class' | 'do' | 'else' | 'extends' | 'false' | 'if' | 'in' | 'int32' | 'isnull' | 'let' | 'new' | 'not' | 'string' | 'then' | 'true' | 'unit' | 'while' ;
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
    OPERATOR                : '{' | '}' | '(' | ')' | ':' | ';' | ',' | '+' | '-' | '*' | '/' | '^' | '.' | '=' | '<' | '<=' | '<-' ;
    WS                      : [ \r\n\t]+ -> skip;
