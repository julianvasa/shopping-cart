package com.wirecard.discounts;

import com.wirecard.item.Item;

import java.math.BigDecimal;
import java.util.List;

/**
 * Apply a discount of 30% on OrderItems ordered on Black Friday
 */
public class BlackFridayDiscount implements Discount {

    @Override
    public void apply(List<? extends Item> items) {
        for (Item item : items) {
            BigDecimal standardPrice = item.getPrice();
            BigDecimal discountPrice = standardPrice.subtract(standardPrice.multiply(BigDecimal.valueOf(0.3)));
            item.setPrice(discountPrice);
        }
    }
}
