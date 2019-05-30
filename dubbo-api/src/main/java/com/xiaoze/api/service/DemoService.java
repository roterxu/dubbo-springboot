package com.xiaoze.api.service;

import com.xiaoze.api.model.User;

/**
 * DemoService
 * 服务Api接口类
 *
 * @author xiaoze
 * @date 2018/6/6
 */
public interface DemoService {
    String sayHello(String name);

    Object detail(Integer id);

//    User select(Integer id);
}
