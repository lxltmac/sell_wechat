package com.imooc.dataobject.mapper;

import com.imooc.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void insertByMap() throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("categoryName","我最爱的人");
        map.put("category_type",101);
        int result = mapper.insertByMap(map);
        Assert.assertEquals(1,result);
    }

    @Test
    public void inserByObject() throws Exception{
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("最喜欢的food");
        productCategory.setCategoryType(31);
        int result = mapper.insertByObject(productCategory);
        Assert.assertEquals(1,result);
    }

    @Test
    public void findByCategory() throws Exception{
        ProductCategory result =  mapper.findByCategory(31);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryName() throws Exception{
        List<ProductCategory> result =  mapper.findByCategoryName("最喜欢的food");
        Assert.assertNotNull(result);
    }

    @Test
    public void updateByCategoryType() throws Exception{
        int result = mapper.updateByCategoryType("我最不爱",30);
        Assert.assertEquals(1,result);
    }

    @Test
    public void updateByObject() throws Exception{
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("最喜欢的food");
        productCategory.setCategoryType(32);
//        mapper.insertByObject(productCategory);
        int result = mapper.updateByObject(productCategory);
        Assert.assertEquals(1,result);
    }
    @Test
    public void deleteByCategoryType() throws Exception{
        int result = mapper.deleteByCategoryType(30);
        Assert.assertEquals(1,result);
    }
    @Test
    public void selectByCategoryType() throws Exception{
        ProductCategory result = mapper.selectByCategoryType(31);
        Assert.assertNotNull(result);
    }

}