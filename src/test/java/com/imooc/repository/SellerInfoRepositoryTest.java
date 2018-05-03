package com.imooc.repository;

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
public class SellerInfoRepositoryTest {
    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Test
    public void findByOpenid() throws Exception {
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setOpenid("lxltmac");
        sellerInfo.setSellerId("123456");
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        sellerInfoRepository.save(sellerInfo);

        SellerInfo result = sellerInfoRepository.findByOpenid("lxltmac");
        Assert.assertNotNull(result);
    }
}