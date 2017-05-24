package com.ccy.mobile.bean;

/**
 * Created by Administrator on 2017/5/22.
 */
public class UserInfo {
    /**
     * 用户名
     */
    private String username;
    /**
     * 联系电话，之后添加
     */
    private String phone;
    /**
     * 邮件
     */
    private String email;

    public UserInfo(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
