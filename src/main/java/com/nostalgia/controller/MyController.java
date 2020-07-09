package com.nostalgia.controller;

import com.nostalgia.entity.Account;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.nostalgia.service.AccountService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MyController {

    @PostMapping("/login")
    public String login(String username, String password, Model model){
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        try{
            subject.login(token);
            Account account=(Account)subject.getPrincipal();
            subject.getSession().setAttribute("account",account);
            return "index";
        }catch (UnknownAccountException e){
            e.printStackTrace();
            model.addAttribute("msg","用户名不存在！");
            return "login";
        }catch(IncorrectCredentialsException e){
            e.printStackTrace();
            model.addAttribute("msg","密码错误！");
            return "login";
        }

    }

    @GetMapping("/{url}")
    public String redirect(@PathVariable  String url){
        return url;
    }

    @GetMapping("/unauth")
    @ResponseBody
    public String unauth(){
        return "未授权,无法访问!";
    }

    @GetMapping("/logout")
    public String logout(){
        Subject subject=SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }

}
