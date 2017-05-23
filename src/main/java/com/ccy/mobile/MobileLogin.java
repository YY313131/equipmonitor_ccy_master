package com.ccy.mobile;

import com.ccy.bean.User;
import com.ccy.mobile.bean.LoginResponse;
import com.ccy.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/5/22.
 */
@Controller
public class MobileLogin {
    @Autowired
    private UserService userService;
    private ObjectMapper mapper=new ObjectMapper();
    @RequestMapping("/mobilelogin")
    @ResponseBody
    public String mobileLogin(String usename,String password) throws JsonProcessingException {
        String loginstate=userService.checkUserState(usename,password);
        LoginResponse response=new LoginResponse();
        if (loginstate.equals("userNameNotExist")||loginstate.equals("passwordWrong")){
        }else {
           response.setCode(1);
           response.setMsg("sucess");
        }

        return mapper.writeValueAsString(response);
    }
}
