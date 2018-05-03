package com.imooc.service.Impl;

import com.imooc.dataobject.SellerInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/5/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceImplTest {
    @Autowired
    private SellerServiceImpl sellerService;

    @Test
    public void findSellerInfoByOpenid() throws Exception {
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid("lxltmac");
        Assert.assertNotNull(sellerInfo);
    }
}