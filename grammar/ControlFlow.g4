grammar ControlFlow;

@header {
    package parser;
}


program
    : statement+ EOF
    ;

statement
    : matchedStatement
    | unmatchedStatement
    ;

matchedStatement
    : IF '(' expression ')' matchedStatement ELSE matchedStatement
    | FOR '(' forInit expression SEMI forUpdate ')' statement
    | block
    | assignmentStmt
    ;

unmatchedStatement
    : IF '(' expression ')' statement
    | IF '(' expression ')' matchedStatement ELSE unmatchedStatement
    ;

block
    : LBRACE statement* RBRACE
    ;


forInit
    : assignmentStmt?
    ;

forUpdate
    : assignment?
    ;


assignment
    : ID ASSIGN expression
    ;

assignmentStmt
    : assignment SEMI
    ;


expression
    : expression OR andExpr
    | andExpr
    ;

andExpr
    : andExpr AND equalityExpr
    | equalityExpr
    ;

equalityExpr
    : equalityExpr (EQ | NEQ) relationalExpr
    | relationalExpr
    ;

relationalExpr
    : relationalExpr (GT | LT | GTE | LTE) additiveExpr
    | additiveExpr
    ;

additiveExpr
    : additiveExpr (ADD | SUB) multiplicativeExpr
    | multiplicativeExpr
    ;

multiplicativeExpr
    : multiplicativeExpr (MUL | DIV) unaryExpr
    | unaryExpr
    ;

unaryExpr
    : NOT unaryExpr
    | SUB unaryExpr       
    | primary
    ;

primary
    : ID
    | INT
    | LPAREN expression RPAREN
    ;


IF     : 'if' ;
ELSE   : 'else' ;
FOR    : 'for' ;


OR     : '||' ;
AND    : '&&' ;
NOT    : '!' ;

ADD    : '+' ;
SUB    : '-' ;
MUL    : '*' ;
DIV    : '/' ;

GT     : '>' ;
LT     : '<' ;
GTE    : '>=' ;
LTE    : '<=' ;

EQ     : '==' ;
NEQ    : '!=' ;

ASSIGN : '=' ;
SEMI   : ';' ;


LPAREN : '(' ;
RPAREN : ')' ;
LBRACE : '{' ;
RBRACE : '}' ;

ID     : [a-zA-Z_][a-zA-Z0-9_]* ;
INT    : [0-9]+ ;

WS     : [ \t\r\n]+ -> skip ;