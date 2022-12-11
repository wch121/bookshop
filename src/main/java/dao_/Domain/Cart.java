package dao_.Domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
//    private Integer totalCount;
//    private BigDecimal totalPrice;
    private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();


    /**
     * 添加商品项
     *
     * @param cartItem
     */
    public void addItem(CartItem cartItem) {
        CartItem cartItem1 = items.get(cartItem.getId());
        if (cartItem1 == null) {
            items.put(cartItem.getId(), cartItem);
        } else {

            //其实这里就提现出set方法和直接赋值的区别，一个可以修改，一个就是换引用根本修改不了
            cartItem1.setCount(cartItem1.getCount() + 1);   //修改总数量
            cartItem1.setTotalPrice(cartItem1.getTotalPrice().multiply(new BigDecimal(cartItem1.getCount()))); //修改总金额
        }


    }

    /**
     * 删除商品项
     *
     * @param id
     */
    public void deleteItem(Integer id) {
        items.remove(id);

    }

    /**
     * 清空购物车
     */

    public void clear() {
        items.clear();

    }

    /**
     * 修改商品数量
     *
     * @param id
     * @param count
     */
    public void updateCount(Integer id, Integer count) {
        CartItem cartItem = items.get(id);
        if (cartItem != null) {
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getTotalPrice().multiply(new BigDecimal(cartItem.getCount()))); //修改总金额
        }

    }

    public Cart() {
    }

    public Cart(Map<Integer, CartItem> items) {
        this.items = items;
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (Map.Entry<Integer, CartItem> integerCartItemEntry : items.entrySet()) {
            totalCount += integerCartItemEntry.getValue().getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer, CartItem> integerCartItemEntry : items.entrySet()) {
            totalPrice = totalPrice.add(integerCartItemEntry.getValue().getTotalPrice());
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }

}
