package service;

import dao_.BadicDao_.BookDao;
import dao_.BadicDao_.UserDao;
import dao_.Domain.Book;
import dao_.Domain.Page;

import java.util.List;
@SuppressWarnings({"all"})
public class BookService {
    private BookDao bookDao = new BookDao();
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> bookPage = new Page<Book>();
        bookPage.setPageSize(pageSize);
        bookPage.setPageTotalCount(bookDao.queryPageTotalCount());
        bookPage.setPageTotal(bookPage.getPageTotalCount() % bookPage.getPageSize() > 0 ? bookPage.getPageTotalCount() / bookPage.getPageSize() + 1 : bookPage.getPageTotalCount() / bookPage.getPageSize());
        bookPage.setPageNo(pageNo);
        int begin = (bookPage.getPageNo() - 1) * pageSize;
        List<Book> items = bookDao.queryForPageItems(begin, pageSize);
        bookPage.setItems(items);

        return bookPage;



    }

    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> bookPage = new Page<Book>();
        bookPage.setPageSize(pageSize);
        bookPage.setPageTotalCount(bookDao.queryPageTotalCountByPrice(min, max));
        bookPage.setPageTotal(bookPage.getPageTotalCount() % bookPage.getPageSize() > 0 ? bookPage.getPageTotalCount() / bookPage.getPageSize() + 1 : bookPage.getPageTotalCount() / bookPage.getPageSize());
        bookPage.setPageNo(pageNo);
        int begin = (bookPage.getPageNo() - 1) * pageSize;
        List<Book> items = bookDao.queryForPageItemsByPrice(begin, pageSize, min, max);
        bookPage.setItems(items);

        return bookPage;

    }


}
