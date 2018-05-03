package com.imooc.service.Impl;

import com.imooc.dataobject.OrderDetail;
import com.imooc.dataobject.OrderMaster;
import com.imooc.dto.CartDTO;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.OrderStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/4/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("林熙力");
        orderDTO.setBuyerAddress("深圳");
        orderDTO.setBuyerPhone("13590171602");
        orderDTO.setBuyerOpenid("lxltmac");
        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123457");
        o1.setProductQuantity(3);
        orderDetailList.add(o1);
        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】 result={}",result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("123457");
        OrderDTO result = orderService.findOne(orderDTO.getOrderId());
        Assert.assertEquals("123457",result.getOrderId());
    }

    @Test
    public void findList() throws Exception {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList("lxltmac",pageRequest);
        log.info("【订单分页查询】orderDTOPage={}",orderDTOPage.getTotalElements());
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() throws Exception {
        OrderDTO orderDTO = orderService.findOne("1524996050239175805");
        OrderDTO result = orderService.cancel(orderDTO);
        log.info("【取消订单】result={}",result);
        Assert.assertNotNull(result);
    }

    @Test
    public void finish() throws Exception {
        OrderDTO orderDTO = orderService.findOne("1524996204656173890");
        OrderDTO result = orderService.finish(orderDTO);
        log.info("【完结订单】result={}",result);
        Assert.assertNotNull(result);
    }

    @Test
    public void paid() throws Exception {
        OrderDTO orderDTO = orderService.findOne("1524996433792770630");
        OrderDTO result = orderService.paid(orderDTO);
        log.info("【支付订单】result={}",result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findlist() throws Exception{
        PageRequest pageRequest = new PageRequest(1,2);
        Page<OrderDTO> orderDTOPage = orderService.list(pageRequest);
        log.info("【所有订单分页查询】orderDTOPage={}",orderDTOPage.getTotalElements());
//        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
        Assert.assertTrue("所有订单分页查询",orderDTOPage.getTotalElements() > 0);
    }
}