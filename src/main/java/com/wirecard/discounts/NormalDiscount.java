package com.wirecard.discounts;

import com.wirecard.item.Item;

import java.util.List;

/**
 * Do not apply any discount, the calculation of the total will consider the default price of the item
 */
public class NormalDiscount implements Discount {

    @Override
    public void apply(List<? extends Item> orders) {

    }
}
