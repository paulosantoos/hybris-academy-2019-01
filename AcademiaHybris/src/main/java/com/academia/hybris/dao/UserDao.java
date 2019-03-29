package com.academia.hybris.dao;

import com.academia.hybris.model.User;

import java.util.List;

public interface UserDao {
    User register(User user);

    void update(User user);

    void delete(Integer id);

    User load(Integer id);

    List<User> findAll();
}
