package com.imooc.service;

import com.imooc.dataobject.ProductInfo;
import com.imooc.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Administrator on 2018/4/28.
 */
public interface ProductService {
    ProductInfo findOne(String productId);

    /**
     * 查询所有在架商品类表
     * @return
     */
    List<ProductInfo> findAll();

    Page<ProductInfo> findAll(Pageable pageable);

//    List<ProductInfo> findByProductStatusIn(Integer productStatus);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseSock(List<CartDTO> cartDTOList);

    //上架
    ProductInfo onSale(String productId);

    //下架
    ProductInfo offSale(String productId);

}