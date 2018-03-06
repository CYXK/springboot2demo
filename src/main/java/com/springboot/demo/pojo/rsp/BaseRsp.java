package com.springboot.demo.pojo.rsp;

import lombok.Data;

/**
 * @description:
 * @author: liuyanlong
 * @date: created in 2018/3/6 13:42
 */
@Data
public class BaseRsp<T> {
    private Integer code;
    private T value;

    public BaseRsp() {}

    public BaseRsp(T value) {
        this.value = value;
    }
}
