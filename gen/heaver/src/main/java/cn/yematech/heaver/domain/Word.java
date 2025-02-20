package cn.yematech.heaver.domain;

public class Word  extends AbstractAuditingEntity {
    @TableField(name="${$field.lineName}")
    private String text;


    public  Word setText(String text) {
        this.text=text;
        return this;
    }
    public  String getText() {
        return this.text;
    }

}
