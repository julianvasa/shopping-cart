package com.wirecard.discounts;

import com.wirecard.item.Item;

import java.math.BigDecimal;
import java.util.List;

/**
 * Apply a discount of 20% on OrderItems order with a Gold Credit Card
 */
public class GoldDiscount implements Discount {

    @Override
    public void apply(List<? extends Item> items) {
        for (Item item : items) {
            BigDecimal standardPrice = item.getPrice();
            BigDecimal discountPrice = standardPrice.subtract(standardPrice.multiply(BigDecimal.valueOf(0.2)));
            item.setPrice(discountPrice);
        }
    }
}
