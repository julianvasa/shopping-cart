package com.wirecard.discounts;

import com.wirecard.item.Item;

import java.util.List;

public interface Discount {
    void apply(List<? extends Item> order);
}
