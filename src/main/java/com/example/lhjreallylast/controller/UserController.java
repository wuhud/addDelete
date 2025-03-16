package com.example.lhjreallylast.controller;


import com.example.lhjreallylast.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.lhjreallylast.service.UserService;

import java.util.List;


//标记这是一个controller用来处理请求的类
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService; //基本含义是需要一个类new出一个新的类来完成任务，下面的就在这个对象上执行
    //但是这个类是不能通过new这种方式产生的，需要使用spring来自己管理

    // 根据 id 获取用户
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    // 获取所有用户
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/delete/{id}")
    public void deleteUserById(@PathVariable("id")Integer id){
        System.out.println("正在删除 ");
        userService.deleteUserById(id);

    }
    @GetMapping("/change/{id}/{password}")
    public void changeUserPasswordById(@PathVariable("id")Integer id,@PathVariable("password")String password){
        System.out.println("正在修改 ");
        userService.changeUserPasswordById(id,password);

    }
}
