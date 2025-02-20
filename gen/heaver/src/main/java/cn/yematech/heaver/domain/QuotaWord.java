package cn.yematech.heaver.domain;
import java.math.BigDecimal;

public class QuotaWord  extends AbstractAuditingEntity {
    @TableField(name="${$field.lineName}")
    private String refId;
    @TableField(name="${$field.lineName}")
    private String wordId;
    @TableField(name="${$field.lineName}")
    private BigDecimal degree;


    public  QuotaWord setRefId(String refId) {
        this.refId=refId;
        return this;
    }
    public  String getRefId() {
        return this.refId;
    }

    public  QuotaWord setWordId(String wordId) {
        this.wordId=wordId;
        return this;
    }
    public  String getWordId() {
        return this.wordId;
    }

    public  QuotaWord setDegree(BigDecimal degree) {
        this.degree=degree;
        return this;
    }
    public  BigDecimal getDegree() {
        return this.degree;
    }

}
