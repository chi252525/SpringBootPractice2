package com.becky.demo.model.mapper.mysql;

import com.becky.demo.model.entity.User;
import org.apache.ibatis.annotations.Mapper;


public interface UserMapper {
    void add(User user);

}
