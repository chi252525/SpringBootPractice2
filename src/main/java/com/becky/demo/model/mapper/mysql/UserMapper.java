package com.becky.demo.model.mapper.mysql;

import com.becky.demo.model.entity.User;


public interface UserMapper {
    void add(User user);

    User findByUserName(String userName);

}
