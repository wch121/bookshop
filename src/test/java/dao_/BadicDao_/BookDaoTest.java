package dao_.BadicDao_;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookDaoTest {

    @Test
    public void queryPageTotalCount() {
        BookDao bookDao = new BookDao();
        System.out.println(bookDao.queryPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        BookDao bookDao = new BookDao();
        System.out.println(bookDao.queryForPageItems(0, 2));
    }
}