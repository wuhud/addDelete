package com.example.lhjreallylast.service;

import com.example.lhjreallylast.mapper.UserMapper;
import com.example.lhjreallylast.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//告诉spring 这是一个service类
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    //同理需要用一个userMapper来真正去帮助怎么访问数据层，不能通过new一个的方式产生

    public User getUserById(Integer id) {
        return userMapper.selectUserById(id);
    }
    public List<User> getAllUsers() {
        return userMapper.selectAllUsers();
    }

    public void changeUserPasswordById(Integer id,String password ){
        userMapper.changeUserPasswordById(id,password);

    }
    public void deleteUserById(Integer id){
        userMapper.deleteUserById(id);
    }
    public void addUser(User user){
        userMapper.addUser(user);
    }
}
