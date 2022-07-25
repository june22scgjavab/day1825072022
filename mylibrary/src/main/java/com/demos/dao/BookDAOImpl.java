package com.demos.dao;

import java.util.ArrayList;
import java.util.List;

import com.demos.model.Book;

public class BookDAOImpl implements BookDAO {

	List<Book> listOfBooks=null;
	public BookDAOImpl() {
		listOfBooks=new ArrayList<>();
	}
	@Override
	public int addBooks(Book book) {
	   listOfBooks.add(book);
		return book.getId();
	}

	@Override
	public List<Book> listOfBooks() {
		
		return listOfBooks;
	}

	@Override
	public Book searchBook(int id) {
		Book searched=null;
	for(Book book : listOfBooks)
	{ 
		if(book.getId()==id)
		{
			searched=book;
			break;
		}
	}
		return searched;
	}

}
