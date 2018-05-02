package com.imooc.service;

import com.imooc.dataobject.ProductCategory;

import java.util.List;

/**
 * Created by Administrator on 2018/4/27.
 */
public interface CategoryService {
    /**
     * 查询商品类目其中一条
     * @param categoryId
     * @return
     */
    public ProductCategory findOne(Integer categoryId);

    /**
     * 查看所有商品
     * @return
     */
    public List<ProductCategory> findAll();

    /**
     *  根据商品类别查询
     * @param categoryTypeList
     * @return
     */
    public List<ProductCategory> findbyCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     * 保存商品
     * @param productCategory
     * @return
     */
    public ProductCategory save(ProductCategory productCategory);
}