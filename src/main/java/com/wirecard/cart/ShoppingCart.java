package com.wirecard.cart;

import com.wirecard.discounts.Discount;
import com.wirecard.item.Item;

import java.math.BigDecimal;
import java.util.List;

/**
 * A Shopping Cart is a list of items
 * Can eventually apply a discount on the price of all items
 */
public class ShoppingCart {
    private final List<Item> items;
    private final Discount discount;

    public ShoppingCart(List<Item> items, Discount discount) {
        this.items = items;
        this.discount = discount;
    }

    public int total() {
        BigDecimal total = BigDecimal.ZERO;
        discount.apply(items);

        for (Item item : items) {
            total = total.add(item.getTotalPrice());
        }
        //order.forEach(System.out::println);

        return total.intValue();
    }
}
