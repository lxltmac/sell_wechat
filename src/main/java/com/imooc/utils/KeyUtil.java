package com.imooc.utils;

import java.util.Random;

/**
 * Created by Administrator on 2018/4/28.
 */
public class KeyUtil {
    /**
     * 生成唯一的主键
     * 格式：时间+随机数
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000)+100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }

    /**
     * 生成唯一的主键
     * 格式：随机数
     */
    public static synchronized String genUniqueKeyID(){
        Random random = new Random();
        Integer number = random.nextInt(900000)+100000;
        return String.valueOf(number);
    }
}
