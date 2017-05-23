package com.ccy.mobile.bean;

/**
 * Created by Administrator on 2017/5/22.
 */
public class LoginResponse {
    /**
     * 1:表示成功
     * -1:表示失败
     */
    private int code=-1;
    /**
     * 登陆信息
     * "fail"
     * "success"
     */
    private String msg="fail";

    public LoginResponse() {

    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
