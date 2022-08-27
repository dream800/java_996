package com.dream.lamda.cart;

public enum Category {

    CLOTHING(10, "服装类"),
    ELECTONICS(20, "数码类"),
    SPRORTS(30, "运动类"),
    BOOKS(40, "图书类")

    ;


    private Integer code;

    private String value;


    Category(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
