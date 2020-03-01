package com.example.defence.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.defence.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findBookByBid(int bid);
    List<Book> findAll();
}
