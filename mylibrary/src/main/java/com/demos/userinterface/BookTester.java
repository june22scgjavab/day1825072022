package com.demos.userinterface;

import java.time.LocalDate;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.demos.dao.exception.BookException;
import com.demos.model.Book;
import com.demos.service.BookService;
import com.demos.service.BookServiceImpl;


public class BookTester {
	private static BookService bookService;

	private static PropertiesConfiguration propertiesConfiguration;

	private static final Log LOG = LogFactory.getLog(BookTester.class);
	public static void main(String[] args) throws ConfigurationException {
		bookService=new BookServiceImpl();
		propertiesConfiguration=new Configurations().properties("configuration.properties");
		addBook();
	

	}
	private static void addBook() {
	Book book=new Book(-1,"Complete Reference Java",LocalDate.now(), 45.67f,"Jim");
	try {
		LOG.info("The book added with the id: "+bookService.addBooks(book));
	} catch (BookException e) {
		
		LOG.error(propertiesConfiguration.getProperty(e.getMessage()),e);
	}	
	}

}
