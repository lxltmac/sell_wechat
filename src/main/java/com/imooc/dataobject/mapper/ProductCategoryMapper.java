package com.imooc.dataobject.mapper;

import com.imooc.dataobject.ProductCategory;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/8.
 */
//在SellApplication上配置了注解@MapperScan(basePackages = "cn.chenhaoxiang.dataObject.mapper")//配置mybatis mapper扫描路径 所以不用我们再写注解注入Bean
@Mapper
@Component//也可以通过上面两个注解实现注入Bean
public interface ProductCategoryMapper {
    /**
     * 通过map插入
     * @param map
     * @return
     */
    @Insert("insert into product_category (category_name,category_type) values (#{categoryName,jdbcType=VARCHAR},#{categoryType,jdbcType=INTEGER})")
    int insertByMap(Map<String,Object> map);

    /**
     * 通过对象插入
     * @param productCategory
     * @return
     */
    @Insert("insert into product_category (category_name,category_type) values (#{categoryName,jdbcType=VARCHAR},#{categoryType,jdbcType=INTEGER})")
    int insertByObject(ProductCategory productCategory);


    @Select("select * from product_category where category_type=#{categoryType,jdbcType=INTEGER}")
    @Results({
        @Result(column = "category_id",property = "categoryId"),
        @Result(column = "category_name",property = "categoryName"),
        @Result(column = "category_type",property = "categoryType"),
        @Result(column = "create_time",property = "createTime"),
    })
    ProductCategory findByCategory(Integer categoryType);

    @Select("select * from product_category where category_name=#{categoryName,jdbcType=VARCHAR}")
    @Results({
            @Result(column = "category_id",property = "categoryId"),
            @Result(column = "category_name",property = "categoryName"),
            @Result(column = "category_type",property = "categoryType"),
            @Result(column = "create_time",property = "createTime"),
    })
    List<ProductCategory> findByCategoryName(String categoryName);

    @Update("update product_category set category_name=#{categoryName,jdbcType=VARCHAR} where category_type=#{categoryType,jdbcType=INTEGER}")
    int updateByCategoryType(@Param("categoryName") String categoryName,@Param("categoryType") Integer categoryType);

    @Update("update product_category set category_name=#{categoryName,jdbcType=VARCHAR} where category_type=#{categoryType,jdbcType=INTEGER}")
    int updateByObject(ProductCategory productCategory);

    @Delete("delete from product_category where category_type=#{categoryType,jdbcType=INTEGER}")
    int deleteByCategoryType(Integer categoryType);

    ProductCategory selectByCategoryType(Integer categoryType);
}
