package com.ccy.web;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by caihanbin on 2017/4/28.
 */
public class LoginInterceptor implements HandlerInterceptor{
    private List<String> allowUrl;

    public List<String> getAllowUrl() {
        return allowUrl;
    }

    public void setAllowUrl(List<String> allowUrl) {
        this.allowUrl = allowUrl;
    }

    /**
     * 在请求之前执行
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse,
                             Object o) throws Exception {
        String url=httpServletRequest.getRequestURL().toString();
        Object user=httpServletRequest.getSession().getAttribute("user");
        if (user!=null){
            return true;
        }
        for (String temp:allowUrl){
            if (url.endsWith(temp)){
                return true;
            }
        }
       httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login");
        return false;
    }

    /**
     * 在请求提交之后执行
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("处理后");
    }

    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {

    }
}
