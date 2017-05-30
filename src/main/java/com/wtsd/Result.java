package com.wtsd;

import java.io.Serializable;

/**
 * 通用的结果bean
 * Created by xianghao on 2017/5/30.
 */
public class Result implements Serializable{

    private final static String SUCCESS = "0";
    private final static String FAIL = "1";
    private String code;

    private String msg;

    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(String msg) {
        this.code = SUCCESS;
        this.msg = msg;
    }

    public Result(String msg, Object data) {
        this.code = SUCCESS;
        this.msg = msg;
        this.data = data;
    }

    public Result(Object data) {
        this.code = SUCCESS;
        this.msg = "success";
        this.data = data;
    }

    public Result() {
    }
}
