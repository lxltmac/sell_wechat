package com.imooc.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/28.
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO<T> implements Serializable{

    private static final long serialVersionUID = 3773087406155860963L;
    /** 错误码*/
    private Integer code;
    /** 提示信息*/
    private String message;
    /** 具体内容*/
    private T data;
}