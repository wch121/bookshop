package web;

import com.google.gson.Gson;
import dao_.Domain.Book;
import dao_.Domain.Cart;
import dao_.Domain.CartItem;
import dao_.utils.WebUtils;
import service.BookService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@SuppressWarnings({"all"})
public class CartServlet extends BasicServlet {
    private BookService bookService = new BookService();

    public void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int bookId = WebUtils.parseInt(req.getParameter("bookId"), 0);
        Book book = bookService.queryBookById(bookId);
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("cartItemName", cartItem.getName());
        stringObjectHashMap.put("totalCount", cartItem.getCount());
        Gson gson = new Gson();
        String s = gson.toJson(stringObjectHashMap);

        resp.getWriter().write(s);

    }

    /**
     * 加入购物车
     *
     * @param req
     * @param resp
     * @throws IOException
     */
    public void addItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String referer = req.getHeader("Referer");
        int bookId = WebUtils.parseInt(req.getParameter("bookId"), 0);
        Book book = bookService.queryBookById(bookId);
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        resp.sendRedirect(referer);

    }

    /**
     * 删除商品项
     *
     * @param req
     * @param resp
     * @throws IOException
     */
    public void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.deleteItem(id);
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }

    /**
     * 清空购物车
     *
     * @param req
     * @param resp
     * @throws IOException
     */
    public void clear(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clear();
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 修改商品数量
     * @param req
     * @param resp
     * @throws IOException
     */
    public void updateCount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.updateCount(id, count);
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }

}
