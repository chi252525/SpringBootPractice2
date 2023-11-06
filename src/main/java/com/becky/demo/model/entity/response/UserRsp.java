package com.becky.demo.model.entity.response;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class UserRsp {
    private String status ="200";
    private List<String> message = Arrays.asList("SUCCESS");
    private String shopName;
}
