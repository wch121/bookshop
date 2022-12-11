package dao_.Domain;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "datou", 2, new BigDecimal(10.00), new BigDecimal(20.00)));
        cart.addItem(new CartItem(1, "datou", 2, new BigDecimal(10.00), new BigDecimal(20.00)));
        System.out.println(cart.getItems());
    }

    @Test
    public void deleteItem() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void updateCount() {
    }
}