package com.wirecard.item;

import java.math.BigDecimal;

/**
 * An item can have many fields but it should have a price field
 * and a getter and a setter method for the price
 *
 * An implementation of Item can be a product or a some bundled products
 * or some products that bought together are discounted
 */
public interface Item {
    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    BigDecimal getTotalPrice();
}
