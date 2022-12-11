package dao_.BadicDao_;

import dao_.Domain.Order;

public class OrderDao extends BasicDao {
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`, `create_time`, `price`, `status`, `user_id`) values(?,?,?,?,?)";
        return update(sql, order.getOrder_id(), order.getCreate_time(), order.getPrice(), order.getStatus(), order.getUser_id());
    }
}
