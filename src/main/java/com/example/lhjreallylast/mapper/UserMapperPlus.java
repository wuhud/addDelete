package com.example.lhjreallylast.mapper;

import com.example.lhjreallylast.model.User;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface UserMapperPlus extends BaseMapper<User> {
    // 这里可以自定义一些特殊的 SQL 方法，也可以不写

    @Insert("INSERT INTO user (username, password) VALUES (#{username}, #{password})")
        // 如果想返回影响行数可以用 int，也可用void
    int insertUser(User user);

    /**
     * 2. 自定义通过 id 查询用户（示例：与内置 selectById 类似）
     */
    @Select("SELECT * FROM user WHERE id = #{id}")
    User getUserById(@Param("id") Long id);

    /**
     * 3. 自定义更新用户（示例：与内置 updateById 类似）
     */
    @Update("UPDATE user SET username = #{username}, password = #{password} WHERE id = #{id}")
    int updateUser(User user);

    /**
     * 4. 自定义通过 id 删除用户（示例：与内置 deleteById 类似）
     */
    @Delete("DELETE FROM user WHERE id = #{id}")
    int deleteUserById(@Param("id") Long id);

    /**
     * 5. 自定义查询：比如根据用户名的关键字模糊查询用户列表
     */
    @Select("SELECT * FROM user WHERE username LIKE CONCAT('%', #{username}, '%')")
    java.util.List<User> findUsersByUsernameLike(@Param("username") String username);
}