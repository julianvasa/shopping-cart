package com.wirecard;

import com.wirecard.cart.ShoppingCart;
import com.wirecard.discounts.*;
import com.wirecard.item.Item;
import com.wirecard.item.Product;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShoppingCartTests {

    private Item A, B, C, D, E;
    private Discount goldDiscount, silverDiscount, blackFridayDiscount, normalDiscount;

    @Before
    public void setup() {
        A = new Product(1L, "A", BigDecimal.valueOf(100), 3);
        B = new Product(2L, "B", BigDecimal.valueOf(100), 5);
        C = new Product(3L, "C", BigDecimal.valueOf(100), 10);
        D = new Product(4L, "D", BigDecimal.valueOf(20), 10);

        E = new Product(2L, "B", BigDecimal.valueOf(100), 20);
        goldDiscount = new GoldDiscount();
        silverDiscount = new SilverDiscount();
        blackFridayDiscount = new BlackFridayDiscount();
        normalDiscount = new NormalDiscount();
    }

    @Test
    public void goldDiscount() {
        List<Item> orders = List.of(A, B, C, D);
        ShoppingCart shoppingCart = new ShoppingCart(orders, goldDiscount);
        assertEquals(1600, shoppingCart.total());
    }

    @Test
    public void silverDiscount() {
        List<Item> orders = List.of(A, B, C, D);
        ShoppingCart shoppingCart = new ShoppingCart(orders, silverDiscount);
        assertEquals(1800, shoppingCart.total());
    }

    @Test
    public void blackFridayDiscount() {
        List<Item> orders = List.of(A);
        ShoppingCart shoppingCart = new ShoppingCart(orders, blackFridayDiscount);
        assertEquals(210, shoppingCart.total());
    }

    @Test
    public void normalDiscount() {
        List<Item> orders = List.of(E);
        ShoppingCart shoppingCart = new ShoppingCart(orders, normalDiscount);
        assertEquals(2000, shoppingCart.total());
    }
}
