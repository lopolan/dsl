### 一个DSL 代码生成项目
基于 antlr4 和velocity 
### 模版可定制 @see resource/velocity
### 词法语法如下
<pre>
root: project;
project: remark? (annotation)* 'project' projectName '{' (entity|dto|enums|config)* '}'  EOF;
entity: remark? (annotation)* 'entity' entityName ('extends' fieldName)? '{' (field)* '}';
dto: remark? (annotation)* 'abstract' entityName '{' (field)* '}';
enums: remark? (annotation)* 'enum' entityName '{' (fieldName)* '}';
config: 'config' '{' (configItem)* '}';
configItem: configKey ':' configValue;
field: remark? (annotation)* fieldName fieldType;
projectName: ID|NAME;
entityName: ID;
fieldName: ID;
configKey: ID|NAME;
configValue: TEXT*;
fieldType: simpleType|collectionType '<' simpleType '>';
collectionType: ('List'|'Set');
simpleType: 'Integer'|'Long'|'String'|'BigDecimal'|'Json'|'LocalDate'|'LocalDateTime'|'LocalTime'|'ZonedDateTime'|'Instant'|ID;
annotation: '@'annotationName('(' (annotationField'='annotationValue) (',' annotationField'='annotationValue)* ')')?;
annotationName: ID;
annotationField: ID;
annotationValue: ID;
remark: '//' remarkContent?;
remarkContent: ID|TEXT;
ID: ([a-zA-Z0-9]|'_')+ ;
TEXT: ([a-zA-Z0-9]|[\u4e00-\u9fa5]|'_'|'.'|'-')+ ;
NAME: ([a-zA-Z0-9]|'_'|'-')+ { if(1==-1){setType(TEXT);}};
STR: '\'' ('\'\'' | ~('\''))* '\'';
WS: [ \t\n\r]+ -> skip ;
</pre>
