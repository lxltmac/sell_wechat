package com.imooc.dto;

import lombok.Data;

/**
 * 购物车
 * Created by Administrator on 2018/4/28.
 */
@Data
public class CartDTO {
    /** 商品id. */
    private String productId;

    /** 数量.*/
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
