package com.example.defence.service;
import com.example.defence.entity.Book;
import java.util.List;

public interface BookService {
    void addBook(Book book);

    void modifyBook(Book newBook, int bid);

    Book getOne(int bid);

    List<Book> getAll();

    void deleteBook (int bid);
}
