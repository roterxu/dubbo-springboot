package com.xiaoze.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaoze.api.model.User;
import com.xiaoze.api.service.DemoService;
import com.xiaoze.provider.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * DemoServiceImpl
 * 服务提供类
 *
 * @author xiaoze
 * @date 2018/6/7
 */
@Service(version = "${demo.service.version}")
public class DemoServiceImpl implements DemoService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public String sayHello(String name) {
        return "Hello, " + name + " (from Spring Boot)";
    }

    @Override
    public User detail(Integer id) {
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        String key = "user" + id;
        boolean haskey = redisTemplate.hasKey(key);
        if (haskey) {
            User user = operations.get(key);
            System.out.println("redis缓存");
            return user;
        } else {
            User user = new User();
            user = userDao.selectById(id);
            System.out.println("mysql数据库");
            operations.set(key, user);
            return user;
        }
    }


}
