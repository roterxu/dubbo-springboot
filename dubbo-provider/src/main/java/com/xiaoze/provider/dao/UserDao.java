package com.xiaoze.provider.dao;

import com.xiaoze.api.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User selectById(Integer id);
}
