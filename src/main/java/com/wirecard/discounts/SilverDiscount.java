package com.wirecard.discounts;

import com.wirecard.item.Item;

import java.math.BigDecimal;
import java.util.List;

/**
 * Apply a discount of 10% on OrderItems order with a Silver Credit Card
 */
public class SilverDiscount implements Discount {

    @Override
    public void apply(List<? extends Item> items) {
        for (Item item : items) {
            BigDecimal standardPrice = item.getPrice();
            BigDecimal discountPrice = standardPrice.subtract(standardPrice.multiply(BigDecimal.valueOf(0.1)));
            item.setPrice(discountPrice);
        }
    }
}
