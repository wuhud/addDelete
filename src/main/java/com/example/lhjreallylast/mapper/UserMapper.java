package com.example.lhjreallylast.mapper;
import com.example.lhjreallylast.model.User;
import org.apache.ibatis.annotations.Mapper;

import  java.util.List;



//定义数据库的操作有哪些，具体操作在xml文件中完成的
//@Mapper 标记这是一个类，告诉Mybatic
@Mapper
public interface UserMapper {
    User selectUserById(Integer id);
    List<User> selectAllUsers();

    void addUser(User user);
    void deleteUserById(Integer id);

    void changeUserPasswordById(Integer id,String password);
}
