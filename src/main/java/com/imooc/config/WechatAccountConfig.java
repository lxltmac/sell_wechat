package com.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/5/1.
 */
@Data
@Component
//@PropertySource("wechat.yml")
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    private String mpAppId;

    private String mpAppSecret;
    /**
     * 商户号
     */
    private String mchId;
    /**
     * 商户秘钥
     */
    private String mchKey;
    /**
     * 商户证书路径
     */
    private String keyPath;
    /**
     * 微信支付异步通知
     */
    private String notifyUrl;
}
