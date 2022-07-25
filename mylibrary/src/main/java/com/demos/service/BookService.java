package com.demos.service;

import java.util.List;

import com.demos.dao.exception.BookException;
import com.demos.model.Book;

public interface BookService {
	int addBooks(Book book) throws BookException;
	List<Book> listOfBooks();
	Book searchBook(int id);
}
