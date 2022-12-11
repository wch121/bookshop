package dao_.test;

import dao_.BadicDao_.BookDao;
import dao_.Domain.Book;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookDaoTest {
    private BookDao bookDao = new BookDao();
    @Test
    public void addBook() {
        System.out.println(bookDao.addBook(new Book(null, "datou", new BigDecimal(1000), "datou", 1000, 0, null)));

    }

    @Test
    public void deleteBookById() {
        System.out.println(bookDao.deleteBookById(5));
    }

    @Test
    public void updateBook() {
//        System.out.println(bookDao.updateBook(new Book(null, "xaioli", new BigDecimal(1000), "datou", 1000, 0, null), 1));;
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(1));
    }

    @Test
    public void queryForPageItemsByPrice() {
        for (Book book : bookDao.queryForPageItemsByPrice(0, 6, 0, 100)) {

            System.out.println(book);
        }

    }

}