package com.imooc.enums;

import lombok.Data;
import lombok.Getter;

/**
 * Created by Administrator on 2018/4/28.
 */
@Getter
public enum ProductStatusEnum {
    up(0,"商品上架"),
    down(1,"商品下架");

    private Integer code;
    private String msg;

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
