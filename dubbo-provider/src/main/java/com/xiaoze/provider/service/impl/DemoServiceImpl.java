package com.xiaoze.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaoze.api.model.User;
import com.xiaoze.api.service.DemoService;
import com.xiaoze.provider.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * DemoServiceImpl
 * 服务提供类
 * @author xiaoze
 * @date 2018/6/7
 */
@Service(version = "${demo.service.version}")
public class DemoServiceImpl implements DemoService {

    @Autowired
    private UserDao userDao;

    @Override
    public String sayHello(String name) {
        return "Hello, " + name + " (from Spring Boot)";
    }

    @Override
    public User detail(Integer id) {

        return userDao.selectById(id);
    }


//    @Override
//    public User select(Integer id) {
//        return userDao.selectById(id);
//    }
}
