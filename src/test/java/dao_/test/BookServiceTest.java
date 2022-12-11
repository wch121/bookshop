package dao_.test;

import dao_.BadicDao_.BookDao;
import dao_.Domain.Book;
import org.junit.Test;
import service.BookService;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {
    private BookService bookService = new BookService();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "wo", new BigDecimal(999.00), "xiaoli", 999, 0, null));

    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(1);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(2, "aaa", new BigDecimal(10088.00), "laopo", 9999, 0, null));
    }

    @Test
    public void queryBookById() {
        bookService.queryBookById(1);
    }

    @Test
    public void queryBooks() {
        bookService.queryBooks();
    }
}