lexer grammar VirgoLexer;

import Unit;


SingleInteger :
    [0-9];
MultipleInteger :
    [1-9][0-9]*;
Number :
    (MultipleInteger|SingleInteger) (DOT SingleInteger SingleInteger*)?;
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
    '混凝土'|'墙'|'砖'|'土壤'|'砂浆'|'弃土' | TEXT'土';
//  混凝土种类
//TODO 混凝土
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
// 混凝土防渗标号
HNT_FS_DESCRIPTOR :
    'P' MultipleInteger;
// 混凝土抗冻标号
HNT_KD_DESCRIPTOR :
    'F' MultipleInteger;

// 描述文字
Description :
    '(' TEXT ')';
// 顿号
COORDINATION :
    '、';
//WORDS :
//    [a-zA-Z]+;
TEXT :
    [\u4e00-\u9fa5];
//Symbol:
//    ([\u0020\u002f]
//   |[\u003a\u003f]
//   |[\u0040]
//   |[\u005b\u005f]
//   |[\u0060]
//   |[\u007b\u007e]
//   |[\u3002]
//   |[\uFF1F]
//   |[\uFF01]
//   |[\u3010]
//   |[\u3011]
//   |[\uFF0C]
//   |[\u3001]
//   |[\uFF1B]
//   |[\uFF1A]
//   |[\u300C]
//   |[\u300D]
//   |[\u300E]
//   |[\u300F]
//   |[\u2019]
//   |[\u201C]
//   |[\u201D]
//   |[\u2018]
//   |[\uFF08]
//   |[\uFF09]
//   |[\u3014]
//   |[\u3015]
//   |[\u2026]
//   |[\u2013]
//   |[\uFF0E]
//   |[\u2014]
//   |[\u300A]
//   |[\u300B]
//   |[\u3008]
//   |[\u3009]
//   );
DOT :
    '.';
WS :
    [ \t\n\r ';']+ -> skip ;
