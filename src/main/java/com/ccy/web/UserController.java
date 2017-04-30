package com.ccy.web;

import com.ccy.bean.User;
import com.ccy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by caihanbin on 2017/4/27.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public String login(){
        return "redirect:/pages/login.html";
    }
    @RequestMapping("/userCheck")
    public String checkUser(String username, String password, HttpSession session){
        System.out.println(username+" "+password+"11112");
        String loginstate=userService.checkUserState(username,password);
        if (loginstate.equals("userNameNotExist")){
            return "redirect:login.action";
        }else if(loginstate.equals("passwordWrong")){
            return "redirect:login.action";
        }else {
            User user=new User();
            user.setUsername(username);
            user.setPassword(password);
            session.setAttribute("user",user);
            return "redirect:/pages/index.html";
        }
    }
}
