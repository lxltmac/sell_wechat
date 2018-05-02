package com.imooc.service;

import com.imooc.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;

/**
 * 支付
 * Created by Administrator on 2018/5/2.
 */
public interface PayService {
    PayResponse create(OrderDTO orderDTO);
}
