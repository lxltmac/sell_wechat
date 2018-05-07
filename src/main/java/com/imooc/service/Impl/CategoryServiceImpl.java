package com.imooc.service.Impl;

import com.imooc.dataobject.ProductCategory;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.repository.ProductCategoryRepository;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/4/27.
 */
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findbyCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        List<ProductCategory> productCategoryList = repository.findAll();
        for(ProductCategory category : productCategoryList){
            if(productCategory.getCategoryType().equals(category.getCategoryType())){
                if(!productCategory.getCategoryName().equals(category.getCategoryName())) {
                    log.error("【商品类目保存】保存的类目类型在数据库已存在,categoryType={}", category.getCategoryType());
                    throw new SellException(ResultEnum.CATEGORY_TYPE_ERROR);
                }
            }
        }
        return repository.save(productCategory);
    }
}
