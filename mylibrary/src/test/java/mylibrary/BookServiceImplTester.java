package mylibrary;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.demos.dao.exception.BookException;
import com.demos.model.Book;
import com.demos.service.BookServiceImpl;

public class BookServiceImplTester {

	@Test
	public void addBookInvlidTest1() {
		BookServiceImpl bookService=new BookServiceImpl();
		Book book=new Book(-1,"Html Basics",LocalDate.of(2021,10,11),340.56f,"John");
		BookException exception=Assertions.assertThrows(BookException.class, ()->bookService.addBooks(book));
		Assertions.assertEquals("Validator.INVALID_BOOK_ID",exception.getMessage());
	}
	
	
	@Test
	public void addBookInvlidTest2() {
		BookServiceImpl bookService=new BookServiceImpl();
		Book book=new Book(1,"HTML",LocalDate.of(2021,10,11),340.56f,"John");
		BookException exception=Assertions.assertThrows(BookException.class, ()->bookService.addBooks(book));
		Assertions.assertEquals("Validator.INVALID_BOOK_NAME",exception.getMessage());
	}
	

	@Test
	public void addBookInvlidTest2b() {
		BookServiceImpl bookService=new BookServiceImpl();
		Book book=new Book(1,"HTML_BOOK",LocalDate.of(2021,10,11),340.56f,"John");
		BookException exception=Assertions.assertThrows(BookException.class, ()->bookService.addBooks(book));
		Assertions.assertEquals("Validator.INVALID_BOOK_NAME",exception.getMessage());
	}
	@Test
	public void addBookInvlidTest2c() {
		BookServiceImpl bookService=new BookServiceImpl();
		Book book=new Book(1,"html",LocalDate.of(2021,10,11),340.56f,"John");
		BookException exception=Assertions.assertThrows(BookException.class, ()->bookService.addBooks(book));
		Assertions.assertEquals("Validator.INVALID_BOOK_NAME",exception.getMessage());
	}
	
	
	@Test
	public void addBookInvlidTest3() {
		BookServiceImpl bookService=new BookServiceImpl();
		Book book=new Book(1,"Html",LocalDate.of(2022,10,11),340.56f,"John");
		BookException exception=Assertions.assertThrows(BookException.class, ()->bookService.addBooks(book));
		Assertions.assertEquals("Validator.INVALID_BOOK_PUBLISH_DATE",exception.getMessage());
	}
	@Test
	public void addBookInvlidTest4() {
		BookServiceImpl bookService=new BookServiceImpl();
		Book book=new Book(1,"Html",LocalDate.of(2021,10,11),-1,"John");
		BookException exception=Assertions.assertThrows(BookException.class, ()->bookService.addBooks(book));
		Assertions.assertEquals("Validator.INVALID_BOOK_PRICE",exception.getMessage());
	}
	
	
}
