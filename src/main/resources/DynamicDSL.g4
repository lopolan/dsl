grammar DynamicDSL;
options {
  language=Java;
}
/**
  * rule
  */
IMPORT : 'import';
PARAM: ID;
FUNCTION: 'function';
WAY: 'way';
RELATION: 'relation';
MAPSTRUCT: 'mapstruct';
TYPE_DECLARE: COLLECTION_TYPE '<' TYPE '>';
COLLECTION_TYPE: ('List'|'Set');
POINT: '->';
body_statement: '{' body '}';
body: call+;
call: (retrun_value '=')? object('.'method'('param')')+;
retrun_value: ID;
object:ID;
TYPE:[A-Z]+([a-zA-Z0-9]|'_')+;
method:ID;
param:ID;
ID: ([a-zA-Z0-9]|'_')+ ;
TEXT: ([a-zA-Z0-9]|[\u4e00-\u9fa5]|'_')+ ;
NAME: ([a-zA-Z0-9]|'_'|'-')+ ;
STR: '\'' ('\'\'' | ~('\''))* '\'';
WS: [ \t\n\r]+ -> skip ;
