package com.example.defence.dao;

import com.example.defence.entity.User;

import java.util.List;

public interface UserDAO {
    void changeAllow(int id,int allowed);
    int signIn(String account, String password);
    int signUp(User user);
    List<User> getAll();
    User getOne(int id);
    long getId();
}
