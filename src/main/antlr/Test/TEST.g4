grammar TEST;
@header {package VSOP.Test;}

    expression              : expr1 ;
    expr1                   : expr1 AND expr2 | expr2 ;
    expr2                   : NOT expr2 | expr3 ;
    expr3                   : expr4 comparatorOperator expr4 | expr4 ;
    expr4                   : expr4 termOperator expr5 | expr5 ;
    expr5                   : expr5 factorOperator expr6 | expr6 ;
    expr6                   : MINUS expr6 | ISNULL expr6 | expr7 ;
    expr7                   : expr8 POW expr7 | expr8 ;
    expr8                   : '(' expression ')' |  varValue ;


    termOperator            : MINUS | PLUS ;
    factorOperator          : MULTI | DIV ;
    comparatorOperator      : LOWER | LOWER_EQUAL | EQUAL ;

    varValue                : 'true' | 'false' | STRING | integer ;
    integer                 : INTEGER_HEX | INTEGER_DEC | INTEGER_BIN ;

    POW                     : '^' ;
    MULTI                   : '*' ;
    DIV                     : '/' ;
    MINUS                   : '-' ;
    PLUS                    : '+' ;

    LOWER_EQUAL             : '<=' ;
    EQUAL                   : '=' ;
    LOWER                   : '<' ;

    AND                     : 'and' ;
    NOT                     : 'not' ;
    ISNULL                  : 'isnull' ;
    DOT                     : '.' ;

    ASSIGN                  : '<-' ;

    INTEGER_BIN             : '0'[bB][0-9a-zA-Z]* ;
    INTEGER_HEX             : '0'[xX][0-9a-zA-Z]* ;
    INTEGER_DEC             : [0-9][0-9a-zA-Z]* ;
    STRING                  : '"' ( '\\"' | . )*? ('"' | EOF) ;
    WS                      : [ \r\n\t]+ -> skip;
