package com.imooc.service.Impl;

import com.imooc.dataobject.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2018/4/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() throws Exception {
        ProductInfo result = productService.findOne("123456");
        Assert.assertEquals("123456",result.getProductId());
    }

    @Test
    public void findAll() throws Exception {
        List<ProductInfo> result = productService.findAll();
        Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void findAll1() throws Exception {
        PageRequest request = new PageRequest(0,2);
        Page<ProductInfo> result = productService.findAll(request);
//        System.out.println(result.getTotalElements());
        Assert.assertNotEquals(0,result.getTotalElements());
    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("炒饭");
        productInfo.setProductPrice(new BigDecimal(4.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好吃的饭");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);
        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void onSale() throws Exception{
        ProductInfo productInfo = productService.onSale("123456");
        Assert.assertTrue("商品上架状态",productInfo.getProductStatus() == 0);
    }

    @Test
    public void offSale() throws Exception{
        ProductInfo productInfo = productService.offSale("123456");
        Assert.assertTrue("商品下架状态",productInfo.getProductStatus() > 0);
    }

}