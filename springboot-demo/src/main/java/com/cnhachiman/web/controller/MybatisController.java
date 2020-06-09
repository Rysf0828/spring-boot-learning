package com.cnhachiman.web.controller;

import com.cnhachiman.web.domain.User;
import com.cnhachiman.web.mapper.User2Mapper;
import com.cnhachiman.web.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mybatis")
public class MybatisController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private User2Mapper user2Mapper;

    @GetMapping("/user/{id}")
    public ResponseEntity<User> queryById(@PathVariable("id")Long id){

        return ResponseEntity.ok(userMapper.findById(id).get(0));
    }

    @GetMapping("/user2/{id}")
    public ResponseEntity<User> queryById2(@PathVariable("id")Long id){

        return ResponseEntity.ok(userMapper.findById(id).get(0));
    }
}
