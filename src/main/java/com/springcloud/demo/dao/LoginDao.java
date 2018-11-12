package com.springcloud.demo.dao;

import com.springcloud.demo.entity.News;
import com.springcloud.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LoginDao {

    User queryUserByName(String name);

    List<User> getAllUser();

    List<News> getNews();
}
