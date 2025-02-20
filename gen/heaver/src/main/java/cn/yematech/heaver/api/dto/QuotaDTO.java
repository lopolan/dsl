package cn.yematech.heaver.api.dto;

public class QuotaDTO {
    private String name;
    private String code;
    private String unit;


    public  QuotaDTO setName(String name) {
        this.name=name;
        return this;
    }
    public  String getName() {
        return this.name;
    }

    public  QuotaDTO setCode(String code) {
        this.code=code;
        return this;
    }
    public  String getCode() {
        return this.code;
    }

    public  QuotaDTO setUnit(String unit) {
        this.unit=unit;
        return this;
    }
    public  String getUnit() {
        return this.unit;
    }

}