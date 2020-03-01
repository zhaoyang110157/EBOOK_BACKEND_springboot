package com.example.defence.service;

import com.example.defence.entity.User;

import java.util.List;

public interface UserService {

    User signIn(String account , String password);

    int signUp(User user);

    List<User> getAll();

    void changeAllow(int id,int allow);
}
