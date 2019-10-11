package com.techprimers.service;

import com.techprimers.model.User;

import java.util.List;

public interface UserService{
    User findById(Long id);
    List<User> findAll();
    User update(User user, Long id);
    User save(User users);
    void deleteUser(Long id);
}
