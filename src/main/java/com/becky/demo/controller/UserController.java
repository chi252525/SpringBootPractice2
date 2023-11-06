package com.becky.demo.controller;

import com.becky.demo.model.entity.request.UserReq;
import com.becky.demo.model.entity.response.UserRsp;
import com.becky.demo.service.SecurityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public-api")
public class UserController {
    @Autowired
    private SecurityUserService userService;

    @PostMapping("/user/create")
    public UserRsp createUser(@RequestBody UserReq req) {
        return userService.insert(req);
    }
}
