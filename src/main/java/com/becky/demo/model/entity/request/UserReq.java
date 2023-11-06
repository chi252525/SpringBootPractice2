package com.becky.demo.model.entity.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class UserReq extends BaseReq {
    private String name;
    private String password;
    private String emailAddress;
    public void validate() {
        require("name", name);
    }
}
