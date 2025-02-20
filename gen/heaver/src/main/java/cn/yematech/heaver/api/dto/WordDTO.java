package cn.yematech.heaver.api.dto;

public class WordDTO {
    private String text;


    public  WordDTO setText(String text) {
        this.text=text;
        return this;
    }
    public  String getText() {
        return this.text;
    }

}