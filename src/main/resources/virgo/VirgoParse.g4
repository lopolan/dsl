grammar VirgoParse;

options {
    language=Java;
}
import Unit;
root:full_attr;
serial: (SingleInteger|MultipleInteger) DOT;
field_mul:
    Field_Single (COORDINATION? Field_Single)*;
entity_descriptor:
    Entity? field_mul;
entity_declear:
    serial entity_descriptor ':';
entity_content:
    (SL| JP|LJ | HNT_ZL|HNT_QD|HNT_QT|HNT_FS_DESCRIPTOR|HNT_KD_DESCRIPTOR)+;
full_entity:entity_declear (entity_content|TEXT|ChineseInteger)*;
entity: full_entity*;
full_attr:
    ((ProjectFeatureText|(LeftBrackets ProjectFeatureText RightBrackets))? entity)
    |((WorkContentText|((LeftBrackets WorkContentText RightBrackets)))? TEXT*)
    ;
SL:(MultipleInteger|Number) Unit;
HNT_ZL :
    '商砼'|'商品砼'|'商混'|'商品'|'聚合物'|'预拌'|'现浇';
// 混凝土强度
HNT_QD :
    HNT_QD_DESCRIPTOR | (HNT_QD_DESCRIPTOR '混凝土')| (HNT_QD_DESCRIPTOR '高性能混凝土')|
    (HNT_QD_DESCRIPTOR '膨胀混凝土');
HNT_QT:
    '膨胀' | '高性能';
// 混凝土强度标号
HNT_QD_DESCRIPTOR :
    'C' [1-9]+ '0'|'5';
// 混凝土防渗标
HNT_FS_DESCRIPTOR :
    'P' MultipleInteger;
// 混凝土抗冻标号
HNT_KD_DESCRIPTOR :
    'F' MultipleInteger;
SingleInteger :
    [0-9];
MultipleInteger :
    [1-9][0-9]*;
Number :
    MultipleInteger (DOT SingleInteger+ SingleInteger*)?;
Subtract :
    '-' | '-';
Range :
    Number Subtract Number;
LeftBrackets :
    '['|'【';
RightBrackets :
    ']'|'】';
TitleText: ProjectFeatureText|WorkContentText;
ProjectFeatureText :
    '项目特征';
WorkContentText :
    '工作内容';
ChineseInteger :
    '零' | '一' | '二' | '三' | '四' | '五' | '六' | '七' | '八' |  '九' |
    '十' | '百' |'千'|'万' | '亿';
/**级配*/
JP :
    ChineseInteger* '级配 ';
/**粒径*/
LJ :
    Range ;

Field_Single:
    '种类'|'强度'| '部位' |'名称' | '厚度'|'类别'|'品种'|'等级'|'规格'|'其他'|'深度'|'运距'|'基础类型';
Entity:
    '混凝土'|'墙'|'砖'|'土壤'|'砂浆'|'弃土' | TEXT*'土';
TEXT :
    [\u4e00-\u9fa5];
DOT :
    '.';
COORDINATION :
    '、';
WS :
    [ \t\n\r ';' ',']+ -> skip ;

