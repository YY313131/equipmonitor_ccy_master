package com.ccy.mobile.bean;

/**
 * Created by dsz on 17/5/23.
 */
public class MobileResult<T> {
    /**
     * 请求成功 true
     * 失败 false
     */
    private boolean success;
    /**
     * 返回的数据
     */
    private T data;
    /**
     * 返回的信息
     */
    private String msg;

    public MobileResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public MobileResult(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
