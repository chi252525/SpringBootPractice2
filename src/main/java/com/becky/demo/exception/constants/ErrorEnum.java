package com.becky.demo.exception.constants;

public enum ErrorEnum {


    PRODUCT_NOT_EXIST("找不到商品");
    private String message;

    ErrorEnum(String message) {
        this.message = message;
    }

}
