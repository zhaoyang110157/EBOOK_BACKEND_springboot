package com.example.defence.serviceImpl;

import com.example.defence.dao.UserDAO;
import com.example.defence.entity.User;
import com.example.defence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO ;

    @Override
    public User signIn(String account, String password){
        int id = userDAO.signIn(account,password);
        if(id<0){
            User user=new User();
            user.setId(id);
            return user;
        }
        else {
            User user = userDAO.getOne(id);
            user.setPassword("");
            return user;
        }
    }

    @Override
    public int signUp(User user){
        return userDAO.signUp(user);
    }

    @Override
    public List<User> getAll(){
        return userDAO.getAll();
    }

    @Override
    public void changeAllow(int id,int allow){
        userDAO.changeAllow(id,allow);
    }
}
