package com.wwt.wwt_crm.controller;

import com.sun.deploy.net.HttpResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @PostMapping("/doLogin")
    public Map login(@RequestBody Map<String, String> map, HttpServletRequest request){
        Map<String,String> m=new HashMap<>();
        m.put("code","1");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(map.get("empName"),map.get("pwd"));
        try{
            subject.login(token);
            HttpSession session=request.getSession();
            session.setAttribute("user",map.get("empName"));
        }catch (UnknownAccountException uae){
            m.put("code","用户名不存在");
        }catch (IncorrectCredentialsException ice){
            m.put("code","密码错误");
        }
        return m;
    }
}
