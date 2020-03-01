package com.example.defence.daoimpl;

import com.example.defence.entity.Book;
import com.example.defence.dao.BookDAO;
import com.example.defence.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {
    @Resource
    public BookRepository bookRepository;

    @Override
    public void  addBook(Book book){
        bookRepository.save(book);
    }

    @Override
    public void modifyBook(Book newBook, int bid){
        Book oldBook = bookRepository.findBookByBid(bid);
        oldBook.setTitle(newBook.getTitle());
        oldBook.setBid(newBook.getBid());
        oldBook.setImage(newBook.getImage());
        oldBook.setIsbn(newBook.getIsbn());
        oldBook.setAuthor(newBook.getAuthor());
        oldBook.setInventory(newBook.getInventory());
        oldBook.setTranch(newBook.getTranch());
        oldBook.setIntroduction(newBook.getIntroduction());
        bookRepository.saveAndFlush(oldBook);
        System.out.print( "modify succeed \n");
    }

    @Override
    public Book getOne(int bid){
        return bookRepository.findBookByBid(bid);
    }

    @Override
    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    @Override
    public void deleteBook(int bid){
        Book book = bookRepository.findBookByBid(bid);
        bookRepository.delete(book);
    }

    @Override
    public void buyBooks(int bid ,int sales){
        Book book = bookRepository.findBookByBid(bid);
        int inventory = book.getInventory();
        book.setInventory(inventory - sales);
        bookRepository.saveAndFlush(book);
    }
}
