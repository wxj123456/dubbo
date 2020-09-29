package com.dubbo.service.impl;

import com.domain.User;
import com.dubbo.services.UserService;
import java.lang.management.ManagementFactory;
import java.util.Date;

public class UserServiceImpl implements UserService {

    int port;

    public User getUser(Integer id) {
        User user = new User();
        user.setBirthday(new Date());
        user.setId(id);
        user.setPort(port);
        user.setName(ManagementFactory.getRuntimeMXBean().getName());
        return user;
    }

}
