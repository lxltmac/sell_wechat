package com.imooc.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Created by Administrator on 2018/4/28.
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO<T> {

    /** 错误码*/
    private Integer code;
    /** 提示信息*/
    private String message;
    /** 具体内容*/
    private T data;
}