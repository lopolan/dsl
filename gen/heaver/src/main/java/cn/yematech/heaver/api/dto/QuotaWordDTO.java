package cn.yematech.heaver.api.dto;
import java.math.BigDecimal;

public class QuotaWordDTO {
    private String refId;
    private String wordId;
    private BigDecimal degree;


    public  QuotaWordDTO setRefId(String refId) {
        this.refId=refId;
        return this;
    }
    public  String getRefId() {
        return this.refId;
    }

    public  QuotaWordDTO setWordId(String wordId) {
        this.wordId=wordId;
        return this;
    }
    public  String getWordId() {
        return this.wordId;
    }

    public  QuotaWordDTO setDegree(BigDecimal degree) {
        this.degree=degree;
        return this;
    }
    public  BigDecimal getDegree() {
        return this.degree;
    }

}