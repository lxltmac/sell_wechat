package com.imooc.controller;

import com.imooc.VO.ProductInfoVO;
import com.imooc.VO.ProductVO;
import com.imooc.VO.ResultVO;
import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductService;
import com.imooc.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2018/4/28.
 */
@RestController
@RequestMapping("/buyer/product")
@Cacheable(cacheNames = "product",key="123")
public class BuyerProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list")
    public ResultVO list(){
        //查询所有上架的商品
        List<ProductInfo> productInfoList = productService.findAll();

        //查询类目（一次性查询）
//        List<Integer> categoryList =  new ArrayList<>();
//        //传统方法
//        for(ProductInfo productInfo : productInfoList){
//            categoryList.add(productInfo.getCategoryType());
//        }
        //精简做法
        List<Integer> categoryList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findbyCategoryTypeIn(categoryList);

        //数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
//        int i  = 0;
//        int j  = 0;
        for(ProductCategory productCategory : productCategoryList){
//            System.out.println("i==================="+(i++));
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
//                    System.out.println("j==================="+(j++));
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        ResultVO resultVO = new ResultVO();

        return ResultVOUtil.success(productVOList);
    }
}
