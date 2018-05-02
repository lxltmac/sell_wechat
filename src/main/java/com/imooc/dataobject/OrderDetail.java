package com.imooc.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2018/4/28.
 */
@Entity
@Data
public class OrderDetail {
    @Id
    private String detailId;
    /** 订单Id.*/
    private String orderId;
    /** 商品名称.*/
    private String productId;
    /** 商品名字.*/
    private String productName;
    /** 商品价格.*/
    private BigDecimal productPrice;
    /** 商品数量.*/
    private Integer productQuantity;
    /** 商品小图.*/
    private String productIcon;
}
