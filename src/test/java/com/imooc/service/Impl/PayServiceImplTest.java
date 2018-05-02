package com.imooc.service.Impl;

import com.imooc.dto.OrderDTO;
import com.imooc.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/5/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {
    @Autowired
    private OrderService orderService;

    @Autowired
    private PayServiceImpl payService;

    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = orderService.findOne("1525088373972422728");
        payService.create(orderDTO);
    }
}