package com.academia.hybris.service;

import com.academia.hybris.model.User;

import java.util.List;

public interface UserService {

    User register(User user);

    User load(Integer id);

    List<User> findAll();

    void delete(Integer id);
}
