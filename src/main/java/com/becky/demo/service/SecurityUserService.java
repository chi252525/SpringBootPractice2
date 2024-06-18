package com.becky.demo.service;

import com.becky.demo.exception.constants.ErrorEnum;
import com.becky.demo.exception.general.IllegalParameterException;
import com.becky.demo.model.entity.User;
import com.becky.demo.model.entity.request.UserReq;
import com.becky.demo.model.entity.response.UserRsp;
import com.becky.demo.model.mapper.mysql.UserMapper;
import com.becky.demo.utils.PatternUtils;
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

    public UserRsp addUser(UserReq req) {
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
            throw new IllegalParameterException(ErrorEnum.REQUIRED, "username");
        }
        if (!PatternUtils.isMatch(PatternUtils.EMAIL, username)) {
            throw new IllegalParameterException(ErrorEnum.INVALID_EMAIL);
        }
        User user = userMapper.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username + " do not exist!");
        }
        return user;
    }
}
