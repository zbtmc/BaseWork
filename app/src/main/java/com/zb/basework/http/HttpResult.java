package com.zb.basework.http;

/**
 * 后台返回数据
 * Created by zb on 2019/5/5.
 */

public class HttpResult<T> {

    private int code;  //与后台约定的状态码
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
