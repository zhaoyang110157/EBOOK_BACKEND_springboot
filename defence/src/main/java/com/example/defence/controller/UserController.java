package com.example.defence.controller;

import com.example.defence.entity.SignIn;
import com.example.defence.entity.User;
import com.example.defence.entity.changeAllow;
import com.example.defence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/Users")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signIn")
    public User signIn(@RequestBody SignIn signIn){
        String account = signIn.account;
        String password = signIn.password;
        System.out.print(account+" is trying to sign in \n");
        return userService.signIn(account,password);
    }

    @PostMapping("/signUp")
    public void signUp(@RequestBody User user){
        userService.signUp(user);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping("changeAllow")
    public void changeAllow(@RequestBody changeAllow changeAllow){
        int id = changeAllow.id;
        int allowed = changeAllow.allowed;
        System.out.print(id +"'s right is changed to "+allowed + "\n");
        userService.changeAllow(id,allowed);
    }

}
