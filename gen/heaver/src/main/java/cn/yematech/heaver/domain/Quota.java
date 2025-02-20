package cn.yematech.heaver.domain;

public class Quota  extends AbstractAuditingEntity {
    @TableField(name="${$field.lineName}")
    private String name;
    @TableField(name="${$field.lineName}")
    private String code;
    @TableField(name="${$field.lineName}")
    private String unit;


    public  Quota setName(String name) {
        this.name=name;
        return this;
    }
    public  String getName() {
        return this.name;
    }

    public  Quota setCode(String code) {
        this.code=code;
        return this;
    }
    public  String getCode() {
        return this.code;
    }

    public  Quota setUnit(String unit) {
        this.unit=unit;
        return this;
    }
    public  String getUnit() {
        return this.unit;
    }

}
