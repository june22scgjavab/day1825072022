package com.demos.service;

import java.util.List;

import com.demos.dao.BookDAO;
import com.demos.dao.BookDAOImpl;
import com.demos.dao.exception.BookException;
import com.demos.model.Book;
import com.demos.validator.Validator;

public class BookServiceImpl implements BookService {

	BookDAO bookDAO=new BookDAOImpl();
	Validator validator=new Validator();
	@Override
	public int addBooks(Book book) throws BookException {
		validator.validate(book);
		
		return bookDAO.addBooks(book);
	}

	@Override
	public List<Book> listOfBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book searchBook(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
