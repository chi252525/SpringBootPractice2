package com.becky.demo.controller.rest;

import com.becky.demo.annotation.InternalAPIController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@InternalAPIController
@RestController
@RequestMapping("/public-api")
public class UserInternalController {
}
