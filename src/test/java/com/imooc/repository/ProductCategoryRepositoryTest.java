package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/4/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;
    @Test
    public void findOneTest(){
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory.toString());
    }
    @Test
    @Transactional //service层中使用这个注解如果跑出异常的时候会回滚，但是在测试类中使用是不会新增数据是直接回滚的
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("xin最爱",7);
//        productCategory.setCategoryId(3);
//        productCategory.setCategoryName("xixnixn最爱");
//        productCategory.setCategoryType(4);
//        ProductCategory productCategory = repository.findOne(2);
//        productCategory.setCategoryType(3);
//        productCategory.setUpdateTime(new Date());
        ProductCategory result = repository.save(productCategory);
//        Assert.notNull(result);

    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.notNull(result);
    }
}