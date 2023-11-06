package com.becky.demo.controller.page;

import com.becky.demo.model.entity.request.UserReq;
import com.becky.demo.model.entity.response.UserRsp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomeController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
