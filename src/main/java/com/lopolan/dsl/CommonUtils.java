package com.lopolan.dsl;


import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Optional;

/**
 * <h1> CommonUtils</h1>
 *
 * <pre>
 *
 * </pre>
 *
 * @Author lopo
 * @Date 2019-11-06 11:25
 **/
public class CommonUtils {
    private static DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

    public static String format(BigDecimal bigDecimal) {
        return Optional.ofNullable(bigDecimal).map(decimalFormat::format).orElse(null);
    }
    public static BigDecimal bigDecimal (Object o){
        if(o instanceof  BigDecimal){
            return (BigDecimal) o;
        }
        if(o instanceof Number){
            return BigDecimal.valueOf(((Number) o).doubleValue());
        }
        if(o instanceof String){
            try {
                return new BigDecimal((String) o);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public static String simpleFormat(BigDecimal bigDecimal) {
        return bigDecimal.toPlainString();
    }
    public static int minusDays(LocalDate date,LocalDate localDate){
        if(localDate.isAfter(date)){
            return -1;
        }
        LocalDate copy = LocalDate.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth());
        for(int i =0;i<100000;i++){
            if(!copy.isBefore(date)){
                return i;
            }
            copy = copy.plusDays(1);
        }
        throw new RuntimeException("日期相差太大");
    }
    public static String removeStartZero(String a){
        if(a.startsWith("0")){
            return removeStartZero(a.replaceFirst("0",""));
        }
        return a;
    }
    public static class Assert {
        public static void assertTrue(Boolean b) {
            assertTrue(b, "assert fail");
        }

        public static void assertTrue(Boolean b, RuntimeException cause) {
            if (!b) {
                throw cause;
            }
        }

        public static void assertTrue(Boolean b, String message) {
            assertTrue(b, new RuntimeException(message));
        }

        public static void isFalse(boolean b, String format, Object[] objects) {
            assertTrue(!b,String.format(format,objects));
        }
    }

}
