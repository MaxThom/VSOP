grammar CODE;
@header {package VSOP.CodeGeneration;}
    program                 : (classDefinition)+ ;

    statement               : assign | ifStatement | whileStatement | let | callMethod | newObj | OBJECT_IDENTIFIER | varValue | ('(' statement ')') | binaryOperation;
    block                   : '{' (((statement | block) | (((statement ';') | whileStatement | ifStatement)+ (statement | block) ))?) '}' ;

    classDefinition         : 'class' TYPE_IDENTIFIER ('extends' TYPE_IDENTIFIER)? '{' (methodDefinition | field)* '}' ;
    field                   : OBJECT_IDENTIFIER ':' varType ('<-' (statement | block))? ';' ;

    methodDefinition        : OBJECT_IDENTIFIER ('(' ((((formal ',')+ (formal)) | (formal)?) ')') | ('()')) ':' varType block ;
    formal                  : OBJECT_IDENTIFIER ':' varType ;

    callMethod              : (singleCallMethod) | ((singleCallMethod  '.')+ (singleCallMethod));
    singleCallMethod        : (caller)* callFunction ('.' callFunction)* ;
    caller                  : (OBJECT_IDENTIFIER | ('(' newObj ')') | ('(' ifStatement ')')) '.';
    callFunction            : OBJECT_IDENTIFIER (('(' (((argument ',')+ argument) | argument?) ')') | ('()')) ;
    argument                : statement ;

    assign                  : OBJECT_IDENTIFIER '<-' statement ;

    whileStatement          : 'while' statement 'do' (statement | block) ;

    ifStatement             : ifStat elseStat? ;
    ifStat                  : 'if' statement 'then' (statement | block) ;
    elseStat                : 'else' (statement | block) ;

    let                     : 'let' OBJECT_IDENTIFIER ':' varType ('<-' statement)? 'in' (statement | block) ;

    newObj                  : 'new' TYPE_IDENTIFIER ;

    binaryOperation         : expr1 ;
    expr1                   : expr1 AND expr2 | expr2 ;
    expr2                   : <assoc=right> NOT expr2 | expr3 ;
    expr3                   : expr4 comparatorOperator expr4 | expr4 ;
    expr4                   : expr4 termOperator expr5 | expr5 ;
    expr5                   : expr5 factorOperator expr6 | expr6 ;
    expr6                   : <assoc=right> MINUS expr6 | <assoc=right> ISNULL expr6 | expr7 ;
    expr7                   : <assoc=right> expr8 POW expr7 | expr8 ;
    expr8                   : '(' expr1 ')' |  varValue | OBJECT_IDENTIFIER | callMethod | newObj | ifStatement| block ;

    termOperator            : MINUS | PLUS ;
    factorOperator          : MULTI | DIV ;
    comparatorOperator      : LOWER | LOWER_EQUAL | EQUAL | GREATER | GREATER_EQUAL | DIFFERENT_EQUAL ;

    integer                 : INTEGER_HEX | INTEGER_DEC | INTEGER_BIN ;
    varType                 : 'bool' | 'int32' | 'string' | 'unit' | TYPE_IDENTIFIER ;
    varValue                : 'true' | 'false' | STRING | integer  | VOID_OPERATOR;


    POW                     : '^' ;
    MULTI                   : '*' ;
    DIV                     : '/' ;
    MINUS                   : '-' ;
    PLUS                    : '+' ;

    LOWER                   : '<' ;
    LOWER_EQUAL             : '<=' ;
    EQUAL                   : '=' ;
    GREATER                 : '>' ;
    GREATER_EQUAL           : '>=' ;
    DIFFERENT_EQUAL         : '!=' ;

    AND                     : 'and' ;
    NOT                     : 'not' ;
    ISNULL                  : 'isnull' ;

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
