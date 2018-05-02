package com.imooc.controller;

import com.imooc.config.WechatAccountConfig;
import com.imooc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2018/5/2.
 */
@Controller
@RequestMapping("/pay")
public class PayController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/create")
    public void create(@RequestParam("orderId") String order,
                       @RequestParam("retrurnUrl") String returnUrl){
        //查询订单



    }
}
