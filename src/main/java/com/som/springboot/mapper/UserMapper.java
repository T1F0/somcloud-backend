package com.som.springboot.mapper;


import com.som.springboot.entity.Resource;
import com.som.springboot.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserMapper extends Mapper<User> {

    @Insert("INSERT into users(userName,password) VALUES(#{userName},#{password})")
    int saveUser(@Param("userName") String userName, @Param("password") String password);

    @Select("SELECT * FROM users WHERE userName = #{userName}")
    User selectUser(@Param("userName") String userName);

    @Update("UPDATE users SET password=#{newpassword} WHERE userName=#{userName}")
    int updatePassword(@Param("userName") String userName,@Param("password") String newpassword);

    @Update("DELETE FROM users WHERE users.userName=#{userName}")
    int deleteUser(@Param("userName") String userName);
}
