lexer grammar Unit;


Unit: SimpleUnit | ComplexUnit;
UnitSymbol: '/'|'\\'|'*';
SimpleUnit: OtherUnit|LengthUnit|AreaUnit|VolumesUnit|SizeUnit|WeightUnit|PowerUnit|TimeUnit;
ComplexUnit: SimpleUnit (UnitSymbol SimpleUnit)*;
OtherUnit:
    '台'| '座'| '每座'| '个'| '丛'|
    '只'| '支'| '套'| '根'| '株'|
    '盆'| '件'| '块'| '组'| '节'|
    '部'| '对'| '付'| '副'| '匹'|
    '把'| '樘'| '份'| '榀'| '攒'|
    '系统'| '宗'| '元'| '辆'|
    '处'| '缸' | '千个'|
    '百个'| '工日'| '台班' | '千卡'| '卡' | '千匹';
LengthUnit:
    'mm'| 'MM'| 'Mm'| '毫米'|
    'cm'| 'Cm'| 'cM'| 'CM'|
    '厘米'| 'dm'| 'Dm'| 'dM'|
    'DM'| '分米'| 'm'| 'M'| '米'|
    'km'| 'Km'| 'kM'| 'KM'| '千米';
AreaUnit: 'm2'| 'M2'| 'm²'| 'M²'| '平方米'| '平米'| '平方'| '方'|
          'dm2'| 'Dm2'| 'dm²'| 'Dm²'| 'dM2'| 'DM2'| 'dM²'|
          'DM²'| '平方分米'| 'cm2'| 'Cm2'| 'cm²'| 'Cm²'|
          'cM2'| 'CM2'| 'cM²'| 'CM²'| '平方厘米'| 'mm2'|
          'Mm2'| 'mm²'| 'Mm²'| 'mM2'| 'MM2'| 'mM²'| 'MM²'|
          '平方毫米'| '公顷'| '顷'| '亩';
VolumesUnit: 'cm3'| 'Cm3'| 'cm³'| 'Cm³'|
             'cM3'| 'CM3'| 'cM³'| 'CM³'|
             '立方厘米'| 'dm3'| 'Dm3'| 'dm³'|
             'Dm³'| 'dM3'| 'DM3'| 'dM³'| 'DM³'|
             '立方分米'| 'm3'| 'M3'| 'm³'| 'M³'|
             '立方米'| '立方';
SizeUnit: '升'| 'L'| 'l'| '分升'|
          'ML'| 'mL'| 'Ml'| 'ml'|
          '厘升'| 'CL'| 'cL'| 'Cl'|
          'cl'| '毫升';
WeightUnit:'KG'| 'kg'| 'Kg'| 'kG'| '千克'| 't'| 'T'| '吨';

PowerUnit:'千瓦'| 'KW'| 'kw'| 'kW'| 'Kw'| '瓦'| 'w'| 'W';

TimeUnit: '年'|'月'|'日'|'时'|'分'|'秒'|'小时'|'分钟'|'毫秒'|'微秒'|'天'|'周';
