package com.ccy.service.Impl;

import com.ccy.bean.User;
import com.ccy.dao.UserDao;
import com.ccy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * Created by caihanbin on 2017/4/28.
 */
@Service
public class UserServiceImpl implements UserService {
    private static final String sort="binbinshdhsdkjsdbs";
    @Autowired
    private UserDao userDao;
    public String checkUserState(String username, String password) {
        User user=userDao.getUserByName(username);
        String passstr=password+sort;
        String md5= DigestUtils.md5DigestAsHex(passstr.getBytes());
        if (user==null){
            return "userNameNotExist";
        }else if (!md5.equals(user.getPassword())){
            return "passwordWrong";
        }else {
            return "success";
        }
    }
}
