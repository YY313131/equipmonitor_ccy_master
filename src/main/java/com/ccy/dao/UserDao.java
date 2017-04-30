package com.ccy.dao;

import com.ccy.bean.User;

/**
 * Created by caihanbin on 2017/4/27.
 */
public interface UserDao {
    User getUserByName(String username);
}
