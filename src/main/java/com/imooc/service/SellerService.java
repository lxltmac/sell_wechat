package com.imooc.service;

import com.imooc.dataobject.SellerInfo;

/**
 * Created by Administrator on 2018/5/4.
 */
public interface SellerService {
    /**
     * 通过openid查询
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
