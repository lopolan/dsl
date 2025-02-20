grammar Test;
options {
  language=Java;
}
root:  TEXT*;
TEXT: [\u4e00\u9fa5~中];
WS: [ \t\n\r]+ -> skip ;
