package com.springcloud.demo.shiro.dao;

import com.springcloud.demo.shiro.entity.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDAO {

    User queryUserByName(String username);
}
