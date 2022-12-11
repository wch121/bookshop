package web;

import dao_.Domain.Book;
import dao_.Domain.Page;
import dao_.utils.WebUtils;
import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BasicServlet {
    private BookService bookService = new BookService();



    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
        pageNo += 1;

//        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
//        bookService.addBook(book);
//        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");

        //这里是通过把传进来的信息封装成一个new book，然后调用addBook方法，最后请求转发
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.addBook(book);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int id = WebUtils.parseInt(req.getParameter("id"), 0);
//        bookService.deleteBookById(id);
//
//        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");

        //删除就是先通过WebUtils获取id，然后调用delete方法，最后请求重定向
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        bookService.deleteBookById(id);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
//        bookService.updateBook(book);
//        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");

        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo" + req.getParameter("pageNo"));
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int id = WebUtils.parseInt(req.getParameter("id"), 0);
//        Book book = bookService.queryBookById(id);
//        req.setAttribute("book", book);
//        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);

        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        req.setAttribute("book", book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp?pageNo=" + req.getParameter("pageNo")).forward(req, resp);


    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Book> books = bookService.queryBooks();
//        req.setAttribute("books", books);
//        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);

        //这个是查询，就其他三个都会请求转发调用
        //步骤是先bookService调用queryBooks()方法，然后set进req域中，最后请求转发（jsp页面中是）

        List<Book> books = bookService.queryBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //分析这种逻辑都是自顶向下
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setPageUrl("manager/bookServlet?action=page");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);




    }
}
