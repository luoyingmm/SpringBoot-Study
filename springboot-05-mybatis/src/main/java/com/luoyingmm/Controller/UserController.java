package com.luoyingmm.Controller;

import com.luoyingmm.mapper.UserMapper;
import com.luoyingmm.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> userList = userMapper.queryUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        return userList;
    }

    @GetMapping("/queryUserById")
    public User queryUserById(){
        User user = userMapper.queryUserById(1);
        return user;
    }

    @GetMapping("/addUser")
    public String addUser(){
        userMapper.addUser(new User(6,"小卡","12435"));
        return "OK";
    }

    @GetMapping("/updateUser")
    public String updateUser(){
        userMapper.updateUser(new User(4,"小华","1244535"));
        return "OK";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(){
        userMapper.deleteUser(9);
        return "OK";
    }
}
