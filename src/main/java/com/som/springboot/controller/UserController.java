package com.som.springboot.controller;
//import com.som.springboot.repository.UserRepository;
import com.som.springboot.entity.User;
import com.som.springboot.mapper.UserMapper;
import com.som.springboot.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserMapper userMapper;
    private Integer userid;
    private String userName;
    private String password;
    private String token;
    private String admaut;

////    @Autowired
////    private UserRepository userRepository;
//    private final String userName;
//    private final String PASSWORD;
//    private final String USERID;
//
//    @GetMapping("/login")
//    public User login(User user) {
////        if (userName.equals(user.getuserName()) && PASSWORD.equals(user.getPassword())) {
//        if (userName.equals(user.getuserName()) && PASSWORD.equals(user.getPassword())) {
//            user.setToken(JwtUtil.createToken());
//            return user;
//        }
//        return null;
//    }
    @GetMapping("/register")
    public String register(String userName,String password) {
        log.info("userName:{}",userName);
        log.info("password:{}",password);
        int result = userMapper.saveUser(userName,password);
        if (result==1) {
            return "注册成功";
        } else {                            //走不到这一步，因为返回整数不是1的话就是String类型的，所以int赋值不执行
            return "注册失败";
        }
    }

    @GetMapping("/login")
    public User login(String userName, String password){
        User user = userMapper.selectUser(userName);
        if (user == null){
            return null;
        }
        if(Objects.equals(password, user.getPassword())){
            user.setToken(JwtUtil.createToken());   //添加token
//            user.getUserid(Integer userid);
            return user;
        }
        return null;
//        return "登录失败，密码错误";
    }

    @GetMapping("/checkToken")
    public Boolean checkToken(HttpServletRequest request){
        String token = request.getHeader("token");
        return JwtUtil.checkToken(token);
    }

    @GetMapping("/updatePassword")
    public String updatePassword(String userName,String password) {
        log.info("userName:{}",userName);
        log.info("password:{}",password);
        int result = userMapper.updatePassword(userName,password);
        if(result==1){
            return "修改成功";
        } else {
            return "该用户不存在";
        }
    }

    @GetMapping("/deleteUser")
    public String deleteUser(String userName){
        log.info("userName:{}",userName);
        int result = userMapper.deleteUser(userName);
        if(result==1){
            return "删除成功";
        } else {
            return "该用户不存在";
        }
    }

//    public User logout(HttpServletRequest request){
//        String token = request.getHeader("token");
//        Boolean delete = .delete(token);
//        return new User(delete,"注销成功",100)
//    }


//    @GetMapping("/login")
//    public User login(User user) {
////        if (userName.equals(user.getuserName()) && PASSWORD.equals(user.getPassword())) {
//        if (userName.equals(user.getuserName()) && PASSWORD.equals(user.getPassword())) {
//            user.setToken(JwtUtil.createToken());
//            return user;
//        }
//        return null;
//    }




}
