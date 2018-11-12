package com.springcloud.demo.service;

import com.springcloud.demo.dao.LoginDao;
import com.springcloud.demo.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class LoginService {


    @Resource
    private LoginDao loginDao;


    public User queryUserByName(String name) {


        return loginDao.queryUserByName(name);


    }
}
