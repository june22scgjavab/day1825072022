package com.demos.dao;

import java.util.List;

import com.demos.model.Book;

public interface BookDAO {
int addBooks(Book book);
List<Book> listOfBooks();
Book searchBook(int id);
}
