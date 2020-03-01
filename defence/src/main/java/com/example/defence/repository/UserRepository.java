package com.example.defence.repository;

import com.example.defence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserById(int id);
    List<User> findUserByAccount(String account);
}
