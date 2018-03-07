package com.example.demo.controller;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    @Resource(name="userMapper")
    private UserMapper userMapper;
    @RequestMapping("/")
    public User hello(){
        User user = new User();
        user.setName("jjjj");
        user.setAge(20);
        userMapper.insert(user);
        return user;
    }
    @RequestMapping("get")
    public List<User> get(@RequestParam(defaultValue = "1")Integer pageNum, @RequestParam(defaultValue = "2") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userMapper.getList();
        return list;
    }
}
