package service;

import com.sun.org.apache.xpath.internal.operations.Or;
import dao_.BadicDao_.OrderDao;
import dao_.BadicDao_.OrderItemDao;
import dao_.Domain.Cart;
import dao_.Domain.CartItem;
import dao_.Domain.Order;
import dao_.Domain.OrderItem;

import java.util.Date;
import java.util.Map;

public class OrderService {
    private OrderDao orderDao = new OrderDao();
    private OrderItemDao orderItemDao = new OrderItemDao();

    public Order createOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        orderDao.saveOrder(order);
        for (Map.Entry<Integer, CartItem> integerCartItemEntry : cart.getItems().entrySet()) {
            CartItem cartItem = integerCartItemEntry.getValue();
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            orderItemDao.saveOrderItem(orderItem);
        }
        cart.clear();
        return order;
    }
}
