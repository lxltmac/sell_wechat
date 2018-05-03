package com.imooc.utils;

import com.imooc.enums.CodeEnum;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by Administrator on 2018/5/3.
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code,Class<T> enumClass){
        for(T each : enumClass.getEnumConstants()){
            if(each.getCode().equals(code)){
                return each;
            }
        }
        return null;
    }
}
