package com.springcloud.demo.shiro.controller;

import com.alibaba.fastjson.JSONObject;
import com.springcloud.demo.shiro.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {


    @RequestMapping("/rong")
    @ResponseBody
    public String a() {
        return "1";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Object loginUser(String username, String password, HttpSession session, HttpServletRequest request) {
        //授权认证

        System.out.println(request.getRequestURL().toString());
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            //完成登录
            subject.login(usernamePasswordToken);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("token", subject.getSession().getId());
            //获得用户对象
            User user=(User) subject.getPrincipal();
            //存入session
            session.setAttribute("user", user);
            return jsonObject;
        } catch(Exception e) {
            return null;//返回登录页面
        }

    }


    @RequestMapping("/logOut")
    @ResponseBody
    public String logOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
//        session.removeAttribute("user");
        return "login";
    }

    @RequestMapping(value = "/unauth")
    @ResponseBody
    public String unauth() {
        return "0";
    }

    @RequestMapping(value = "/loginSucess")
    @ResponseBody
    public String loginSucess() {
        return "1";
    }
}
