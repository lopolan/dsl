grammar PCScript;
options {
  language=Java;
}
root:  simple_express;


operator_token: '+'|'-'|'*'|'/'|'>'|'<'|'>='|'<=';
nested_express: '(' simple_express ')';
simple_express: (param_name|number|method|nested_express) (operator_token (param_name|number|method|nested_express))*;


param_name: TEXT;
method: TEXT'('simple_express?(',' simple_express)*')';


number :
    ('+'|'-')?(SingleInteger|MultipleInteger|Float);
SingleInteger :
    [0-9];
MultipleInteger :
    [1-9](SingleInteger)+;
Float :
    (MultipleInteger|SingleInteger) DOT (MultipleInteger|SingleInteger)+;

DOT: '.';
TEXT: (ID|[\u4e00-\u9fa5]|'_')+ ;
ID: ([a-zA-Z]|'_')+([a-zA-Z0-9]|'_')* ;
WS: [ \t\n\r]+ -> skip ;
