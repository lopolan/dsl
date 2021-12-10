grammar DO;
options {
  language=Java;
}
/**
  * rule
  */
root: class;
IMPORT
    :  'import' .*? ';'
    ;
class: IMPORT* 'public' 'abstract'? 'class' ID '{' field* '}' EOF;
field: 'private' type_name fieldName ';';
type_name: ID;
fieldName: ID;
ID: ([a-zA-Z0-9])+;
WS  :  [ \t\r\n\u000C]+ -> skip
    ;
COMMENT
    :   '/*' .*? '*/' -> skip
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> skip
    ;
METHOD
    : 'public'  ~[\r\n]* '(' .*? ')' .*? '{' .*? '}' -> skip;
