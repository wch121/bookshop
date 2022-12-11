package dao_.BadicDao_;

import dao_.Domain.Order;
import dao_.Domain.OrderItem;

public class OrderItemDao extends BasicDao{
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`id`, `name`, `count`, `price`, `total_price`, `order_id`) values(?,?,?,?,?,?)";
        return update(sql, null, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotal_price(), orderItem.getOrder_id());
    }
}
