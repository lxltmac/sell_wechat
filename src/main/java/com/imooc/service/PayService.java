package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * 支付
 * Created by Administrator on 2018/5/2.
 */
public interface PayService {
    void create(OrderDTO orderDTO);
}
