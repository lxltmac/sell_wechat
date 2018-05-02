package com.imooc.service.Impl;

import com.imooc.dataobject.ProductCategory;
import com.imooc.repository.ProductCategoryRepository;
import com.imooc.service.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/4/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl categoryService;
    @Test
    public void findOne() throws Exception {
        ProductCategory result = categoryService.findOne(1);
        Assert.assertEquals(new Integer(1),result.getCategoryId());
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> result  = categoryService.findAll();
        Assert.assertNotNull(result);
    }

    @Test
    public void findbyCategoryTypeIn() throws Exception {
        List<ProductCategory> result = categoryService.findbyCategoryTypeIn(Arrays.asList(1,2,3,4,5));
        Assert.assertNotNull(result);
    }

    @Test
    @Transactional
    public void save() throws Exception {
        ProductCategory result = categoryService.save(new ProductCategory("小妹妹",9));
        Assert.assertNotNull(result);
    }
}