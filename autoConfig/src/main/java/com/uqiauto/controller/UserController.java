package com.uqiauto.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.uqiauto.pojo.User;
import com.uqiauto.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/queryUser")
    public String toIndex(HttpServletRequest request,Model model){
        Long userId=Long.parseLong(request.getParameter("id"));
        User user=this.userService.getUserById(userId);
        model.addAttribute("user",user);
        return "user";
    }

    @ResponseBody
    @RequestMapping(value="/queryAllUser",method = RequestMethod.POST)
    public PageInfo<User> queryAllUser(){
        PageHelper.startPage(1,10);
        PageInfo<User> userList=this.userService.queryAllUser();
        //String users=new Gson().toJson(userList);
        return userList;
    }


}
