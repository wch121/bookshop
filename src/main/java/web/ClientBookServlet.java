package web;

import dao_.Domain.Book;
import dao_.Domain.Page;
import dao_.utils.WebUtils;
import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ClientBookServlet extends BasicServlet{


    private BookService bookService = new BookService();
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //分析这种逻辑都是自顶向下
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setPageUrl("client/bookServlet?action=page");
        System.out.println(pageNo);

        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);




    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //分析这种逻辑都是自顶向下
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);
        page.setPageUrl("client/bookServlet?action=pageByPrice&min=" + min + "&max=" + max);


        //这里也可以用if判断是否为null（）空输入来进行赋值

//        StringBuilder stringBuilder = new StringBuilder("client/bookServlet?action=pageByPrice");
//        if (req.getParameter("min") != null) {
//            stringBuilder.append("&min=").append(min);
//        }
//        if (req.getParameter("max") != null) {
//            stringBuilder.append("&max=").append(max);
//        }


        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);

    }
}
