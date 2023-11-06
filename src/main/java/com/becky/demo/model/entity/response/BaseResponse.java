package com.becky.demo.model.entity.response;

import lombok.Data;

import java.util.List;

@Data
public class BaseResponse {
    private String status;
    private List<String> message;

    public void setStatus(int status) {
        this.status = String.valueOf(status);
    }
}
