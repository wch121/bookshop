package web;

import dao_.Domain.Cart;
import dao_.Domain.Order;
import dao_.Domain.User;
import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;

public class OrderServlet extends BasicServlet {
    private OrderService orderService = new OrderService();

//    private LinkedHashMap<Integer, Order> linkedHashMap =  new LinkedHashMap<Integer, Order>();
//    Integer integer = 0;
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User user = (User) req.getSession().getAttribute("user");
        Order order = orderService.createOrder(cart, user.getId());

//        linkedHashMap.put(integer+=1, order);
//        req.getSession().setAttribute("order", );

        req.getSession().setAttribute("order", order);
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }
}
