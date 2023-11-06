package com.becky.demo.service;

import com.becky.demo.model.entity.User;
import com.becky.demo.model.entity.request.UserReq;
import com.becky.demo.model.entity.response.UserRsp;
import com.becky.demo.model.mapper.mysql.UserMapper;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    public UserRsp insert(UserReq req) {
        req.validate();
        User user = new User();
        user.setName(req.getName());
        user.setPassword(req.getPassword());
        user.setEmailAddress(req.getEmailAddress());
        userMapper.add(user);
        UserRsp rsp = new UserRsp();
        rsp.setShopName(req.getName());
        return rsp;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isBlank(username)) {
        }
        return null;
    }
}
