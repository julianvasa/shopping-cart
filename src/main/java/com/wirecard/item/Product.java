package com.wirecard.item;

import java.math.BigDecimal;

/**
 * An item can have many fields but it should have a price field
 * and a getter and a setter method for the price
 *
 * An implementation of Item can be a product or a some bundled products
 * or some products that bought together are discounted
 */
public class Product implements Item{

    private final Long id;
    private final String name;
    private BigDecimal price;
    private final int quantity;

    public Product(Long id, String name, BigDecimal price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return total price = quantity * price (discounted or not)
     */
    @Override
    public BigDecimal getTotalPrice() {
        return BigDecimal.valueOf(quantity).multiply(price);
    }

    @Override
    public String toString() {
        return "Product{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", price=" + price +
            ", quantity=" + quantity +
            '}';
    }
}
