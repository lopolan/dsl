grammar SPE;
options {
  language=Java;
}
root: title item*;
title: ('[项目特征]' | '项目特征')?;
item: N '.' item_name MAOHAO item_value;
item_name: TEXT;
item_value: (nums|TEXT)*;
nums: 'C30'|(N LENGTH_UNIT);
N: [1-9]+[0-9]*;
LENGTH_UNIT: 'CM'|'MM' | 'M' | 'KM' | '10KM';
TEXT: ([a-zA-Z]|[\u4e00-\u9fa5]|'_'|'%')*;
MAOHAO: ':';
KONGJIAN_UNIT: 'M3';
STR: '\'' ('\'\'' | ~('\''))* '\'';
WS: [ \t\n\r ';']+ -> skip ;


