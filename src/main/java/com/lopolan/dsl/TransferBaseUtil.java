package com.lopolan.dsl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

/**
 * <h1> TransferBaseUtil</h1>
 *
 * <pre>
 *
 * </pre>
 *
 * @author lopo
 * @date 2021/1/27 3:50 下午
 **/
public class TransferBaseUtil {
    public final static Map<String, BaseTransfer> TRANSFER_REF = new HashMap<>();
    static class BaseTransfer {
        private Function<BigDecimal, BigDecimal> f;
        private Function<BigDecimal, BigDecimal> r;

        private BaseTransfer(Function<BigDecimal, BigDecimal> f, Function<BigDecimal, BigDecimal> r) {
            this.f = f;
            this.r = r;
        }

        public BaseTransfer() {
        }

        public static BaseTransfer of(Function<BigDecimal, BigDecimal> f, Function<BigDecimal, BigDecimal> r) {
            return new BaseTransfer(f, r);
        }

        public BigDecimal doTransfer(BigDecimal p){
            return function().apply(p);
        }
        public Function<BigDecimal, BigDecimal> function() {
            return f;
        }

        BaseTransfer reverse() {
            return new BaseTransfer(r, f) ;
        }
    }

    public static BaseTransfer lToM3() {
        Function<BigDecimal, BigDecimal> f = (s) -> s.divide(BigDecimal.valueOf(1000));
        Function<BigDecimal, BigDecimal> r = (s) -> s.multiply(BigDecimal.valueOf(1000));
        return BaseTransfer.of(f, r);
    }
    public static BaseTransfer mlToL() {
        return lToM3();
    }
    public static BaseTransfer mlToM3() {
        BaseTransfer mlToL = mlToL();
        BaseTransfer lToM3 = mlToL();
        return new BaseTransfer(){
            @Override
            public Function<BigDecimal, BigDecimal> function() {
                return bigDecimal ->
                    lToM3.doTransfer(mlToL.doTransfer(bigDecimal));
            }

            @Override
            BaseTransfer reverse() {
                mlToL.reverse();
                lToM3.reverse();
                return this;
            }
        };
    }

    public static BaseTransfer dm2ToM2() {
        Function<BigDecimal, BigDecimal> f = (s) -> s.divide(BigDecimal.valueOf(100));
        Function<BigDecimal, BigDecimal> r = (s) -> s.multiply(BigDecimal.valueOf(100));
        return BaseTransfer.of(f, r);
    }

    public static BaseTransfer cm2ToM2() {

        Function<BigDecimal, BigDecimal> f = (l) -> l.divide(BigDecimal.valueOf(100 * 100));
        Function<BigDecimal, BigDecimal> r = (l) -> l.multiply(BigDecimal.valueOf(100 * 100));
        return BaseTransfer.of(f, r);
    }

    public static BaseTransfer dmToM() {

        Function<BigDecimal, BigDecimal> f = (l) -> l.divide(BigDecimal.valueOf(10));
        Function<BigDecimal, BigDecimal> r = (l) -> l.multiply(BigDecimal.valueOf(10));
        return BaseTransfer.of(f, r);
    }

    public static BaseTransfer cmToM() {
        Function<BigDecimal, BigDecimal> f = (l) -> l.divide(BigDecimal.valueOf(10 * 10));
        Function<BigDecimal, BigDecimal> r = (l) -> l.multiply(BigDecimal.valueOf(10 * 10));
        return BaseTransfer.of(f, r);
    }
    public static BaseTransfer mgToG() {
        Function<BigDecimal, BigDecimal> f = (l) -> l.divide(BigDecimal.valueOf(1000));
        Function<BigDecimal, BigDecimal> r = (l) -> l.multiply(BigDecimal.valueOf(1000));
        return BaseTransfer.of(f, r);
    }
    public static BaseTransfer gToKg() {
        Function<BigDecimal, BigDecimal> f = (l) -> l.divide(BigDecimal.valueOf(1000));
        Function<BigDecimal, BigDecimal> r = (l) -> l.multiply(BigDecimal.valueOf(1000));
        return BaseTransfer.of(f, r);
    }

    public static BaseTransfer mgToKg() {
        BaseTransfer mgToG = mgToG();
        BaseTransfer gToKg = gToKg();
        return new BaseTransfer(){
            @Override
            public Function<BigDecimal, BigDecimal> function() {
                return bigDecimal ->
                    gToKg.doTransfer(mgToG.doTransfer(bigDecimal));
            }

            @Override
            BaseTransfer reverse() {
                mgToG.reverse();
                gToKg.reverse();
                return this;
            }
        };
    }
    public static BigDecimal doTransferVolume(BigDecimal value, String unit) {
        BaseTransfer transfer = null;
        if (StringUtils.equals(unit.trim().toLowerCase(), "l")) {
            transfer =  lToM3();
        }
        return transfer != null?transfer.doTransfer(value):value;
    }

    public static BigDecimal doTransferArea(BigDecimal value, String unit) {
        BaseTransfer transfer = null;
        if (StringUtils.equals(unit.trim().toLowerCase(), "cm2")) {
            transfer =  cm2ToM2();
        }
        if (StringUtils.equals(unit.trim().toLowerCase(), "dm2")) {
            transfer =  dm2ToM2();
        }
        return transfer != null?transfer.doTransfer(value):value;
    }

    public static BigDecimal complexTransfer(BigDecimal value, String unit,String target) {
        if(value == null){
            return null;
        }
        if(StringUtils.equals(unit,target)){
            return value;
        }
        List<Pair<String,String>> ori = new ArrayList<>();
        splitUnit(unit, ori);
        List<Pair<String,String>> tar = new ArrayList<>();
        splitUnit(target, tar);
        CommonUtils.Assert.assertTrue(ori.size() == tar.size(),"单位格式错误,请输入正确的格式:"+target);

        for(int i =0;i<ori.size();i++){
            Pair<String,String> o = ori.get(i);
            Pair<String,String> t = tar.get(i);
            CommonUtils.Assert.assertTrue(StringUtils.equals(o.getLeft(), t.getLeft()),"单位格式错误,请输入正确的格式:"+target);
            String ou = o.getRight();
            String tu = t.getRight();
            if(StringUtils.equals(ou,tu)){
                continue;
            }
            BaseTransfer transfer = TRANSFER_REF.get((ou + "to" + tu).toLowerCase());
            if(transfer == null){
                transfer = TRANSFER_REF.get(( tu+ "to" + ou).toLowerCase());
                CommonUtils.Assert.assertTrue(StringUtils.equals(o.getLeft(), t.getLeft()),"单位格式错误,请输入正确的单位:"+String.join(",",fetchOriLike(tu))+" 而不是"+ou);
                transfer =  transfer.reverse();
            }
            if(StringUtils.equals("/",o.getLeft())){
                value =  transfer.reverse().doTransfer(value);
            }else {
                value =  transfer.doTransfer(value);
            }
        }
        return value;
    }
    public static List<String> fetchOriLike(String tu){
        return TRANSFER_REF.entrySet().stream().filter(stringBaseTransferEntry ->
            Arrays.stream(stringBaseTransferEntry.getKey().split("to")).anyMatch(s -> StringUtils.equals(tu.toLowerCase(),s))
        ).flatMap(stringBaseTransferEntry -> Arrays.stream(stringBaseTransferEntry.getKey().split("to")).filter(s -> !StringUtils.equals(tu.toLowerCase(),s))).collect(Collectors.toList());
    }
    private static void splitUnit(String unit, List<Pair<String, String>> pairs) {
        String[] units = unit.trim().split("/|\\.|\\*");
        int index = 0;
        for(String s :units){
            String symbol = null;
            if(index <= 0){
                symbol = ".";
                index=index+s.length();
            }else {
                symbol = unit.substring(index,index+1);
                index=index+s.length()+1;
            }
            pairs.add(Pair.of(symbol,s));
        }
    }

    public static BigDecimal doTransferDeep(BigDecimal value, String unit) {
        BaseTransfer transfer = null;
        if (StringUtils.equals(unit.trim().toLowerCase(), "cm")) {
            transfer =  cmToM();
        }
        if (StringUtils.equals(unit.trim().toLowerCase(), "dm")) {
            transfer =  dmToM();
        }
        return transfer != null?transfer.doTransfer(value):value;
    }
    static {
        TRANSFER_REF.put("lToM3".toLowerCase(), lToM3());
        TRANSFER_REF.put("mlToL".toLowerCase(), mlToL());
        TRANSFER_REF.put("mlToM3".toLowerCase(), mlToM3());
        TRANSFER_REF.put("dm2ToM2".toLowerCase(), dm2ToM2());
        TRANSFER_REF.put("cm2ToM2".toLowerCase(), cm2ToM2());
        TRANSFER_REF.put("dmToM".toLowerCase(), dmToM());
        TRANSFER_REF.put("cmToM".toLowerCase(), cmToM());
        TRANSFER_REF.put("mgToG".toLowerCase(), mgToG());
        TRANSFER_REF.put("gToKg".toLowerCase(), gToKg());
        TRANSFER_REF.put("mgToKg".toLowerCase(), mgToKg());


        TRANSFER_REF.put(
            "sToD".toLowerCase(),
            BaseTransfer.of(
                bigDecimal ->
                    bigDecimal.divide(BigDecimal.valueOf(TimeUnit.SECONDS.convert(1,TimeUnit.DAYS)),6, RoundingMode.HALF_UP),
                bigDecimal ->
                    bigDecimal.multiply(BigDecimal.valueOf(TimeUnit.SECONDS.convert(1,TimeUnit.DAYS))
                    )
            )
        );
        TRANSFER_REF.put(
            "mToD".toLowerCase(),
            BaseTransfer.of(
                bigDecimal ->
                    bigDecimal.divide(BigDecimal.valueOf(TimeUnit.MINUTES.convert(1,TimeUnit.DAYS)),6,RoundingMode.HALF_UP),
                bigDecimal ->
                    bigDecimal.multiply(BigDecimal.valueOf(TimeUnit.MINUTES.convert(1,TimeUnit.DAYS))
                    )
            )
        );

        TRANSFER_REF.put(
            "hToD".toLowerCase(),
            BaseTransfer.of(
                bigDecimal ->
                    bigDecimal.divide(BigDecimal.valueOf(TimeUnit.HOURS.convert(1,TimeUnit.DAYS)),6,RoundingMode.HALF_UP),
                bigDecimal ->
                    bigDecimal.multiply(BigDecimal.valueOf(TimeUnit.HOURS.convert(1,TimeUnit.DAYS)))
            )
        );
    }

    public static void main(String[] args) {
        System.out.println(complexTransfer(BigDecimal.valueOf(100),"m3/d","m3/h"));
    }
}
