package com.example.defence.daoimpl;

import com.example.defence.dao.UserDAO;
import com.example.defence.entity.User;
import com.example.defence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private UserRepository userRepository;

    @Override
    public long getId(){
        return userRepository.count();
    }

    @Override
    public User getOne(int id){
        return userRepository.findUserById(id);
    }

    @Override
    public void changeAllow(int id,int allowed){
        User user = getOne(id);
        user.setAllowed(allowed);
        userRepository.saveAndFlush(user);
        System.out.print(id +"change allow into "+allowed+" \n");
    }

    @Override
    public int signIn(String account, String password){
        List<User> users = userRepository.findUserByAccount(account);
        if( users.size()==1){
            User user = users.get(0);
            if(user.getPassword().equals(password)){
                if(user.getAllowed()==1){
                    System.out.print(user.getId() +" signup success \n");
                    return user.getId();//登陆成功
                }
                else {
                    System.out.print(user.getId() +" is forbidden \n");
                    return -1;//被禁止
                }
            }
            else {
                System.out.print(user.getId() +" wrong password \n");
                return -2;//错误的密码
            }
        }
        else {
            System.out.print(" no such a account \n");
            return -2;//错误的用户名
        }
    }

    @Override
    public int signUp( User user){
        user.setId((int)getId());
        List<User> users = userRepository.findUserByAccount(user.getAccount());
        if(null != users && !users.isEmpty() ){
            System.out.print(user.getAccount() +" already exist \n");
            return 0;
        }
        else{
            userRepository.save(user);
            System.out.print(user.getId() +" sign up success \n");
            return user.getId();
        }
    }

    @Override
    public List<User> getAll(){
        return userRepository.findAll();
    }

}
