package com.imooc.service;


/**
 * Created by Administrator on 2018/5/10.
 */

public interface SeckillService {
    /**
     * 查询特价商品
     * @param productId
     * @return
     */
    String querySecKillProductInfo(String productId);

    /**
     * 秒杀的逻辑方法
     * @param productId
     */
    void orderProductMocckDiffUser(String productId);
}
