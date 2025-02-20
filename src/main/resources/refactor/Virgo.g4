grammar Virgo;

options {
    language=Java;
}

import Unit;

root :
  project_feature work_content?;
project_feature :
    ((ProjectFeatureText|(LeftBrackets ProjectFeatureText RightBrackets))? entity);
work_content :
    (
      (
        WorkContentText
        |(
          (LeftBrackets WorkContentText RightBrackets)
        )
      )? TEXT*
    );
entity: field*;
field :
  field_declear (field_value|TEXT|ChineseInteger|Entity)*;
field_declear :
  serial field_descriptor ':';
field_descriptor :
  Entity? TEXT* field_name;
field_name :
  Field_Single (COORDINATION? Field_Single)*;
serial :
  (SingleInteger|MultipleInteger) DOT;
field_value :
  ((Entity? SL Entity?)
  |(Entity? SL_Range Entity?)
  |(Entity? HNT_ZL Entity?)
  |(Entity? HNT_QT Entity?)
  |(Entity? JP Entity?)
  |(Entity? HNT_KD_DESCRIPTOR Entity?)
  |(Entity? HNT_FS_DESCRIPTOR Entity?)
  |(Entity? TR_LB Entity?)
  |(Entity? HNT_QD_DESCRIPTOR Entity?))+;





ProjectFeatureText :
    '项目特征';
WorkContentText :
    '工作内容';


//可识别特征
//数量
SL :
  (SingleInteger|MultipleInteger|Number) Unit;
//数量区间
SL_Range:
  SL Subtract SL;
// 混凝土种类
HNT_ZL :
    '商砼'|'商品砼'|'商混'|'商品'|'聚合物'|'预拌'|'现浇';
HNT_QT:
    ('膨胀' | '高性能');
/**级配*/
JP :
    ChineseInteger* '级配 ';
// 混凝土抗冻标号
HNT_KD_DESCRIPTOR :
    'F' MultipleInteger;
 // 混凝土防渗标号
HNT_FS_DESCRIPTOR :
     'P' MultipleInteger;
// 混凝土强度标号
HNT_QD_DESCRIPTOR :
    'C' [1-9]+ ('0'|'5');
// 混凝土强度标号
TR_LB_WORD :
     '类土';
TR_LB :
     ChineseInteger (COORDINATION? ChineseInteger)*TR_LB_WORD;


//数字
//一位数
SingleInteger :
    [0-9];
//多位数
MultipleInteger :
    [1-9][0-9]+;
//数字
Number :
    (SingleInteger|MultipleInteger) (DOT SingleInteger+ SingleInteger*)?;
//数字区间
Range :
    Number Subtract Number;

//中文数字
ChineseInteger :
    '零' | '一' | '二' | '三' | '四' | '五' | '六' | '七' | '八' |  '九' |
    '十' | '百' |'千'|'万' | '亿';

//Symbol
DOT :
    '.';
Subtract :
    '-' | '－';
LeftBrackets :
    '['|'【';
RightBrackets :
    ']'|'】';
COORDINATION :
    '、';
// 中文/英文文字 单个
TEXT :
    [\u4e00-\u9fa5];
Field_Single:
    '种类'|'强度'| '部位' |'名称' | '厚度'|'类别'|'品种'|'等级'|'规格'|'其他'|'深度'|'运距'|'基础类型';
Entity:
    '混凝土'|'墙'|'砖'|'土壤'|'砂浆'|'弃土' | '土'|TU
    {
//      if(_input.LT(1).getType()!=1 && _input.LT(1).getType()==24){
          setType(TEXT);
//      }
    };
TU :
  (TEXT '土');
// skip
WS :
    [ \t\n\r ';' ',']+ -> skip ;
