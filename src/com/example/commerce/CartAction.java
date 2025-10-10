package com.example.commerce;

import java.util.Date;

public class CartAction {
    private ActionType type; // ADD, REMOVE
    private Product product;
    private int quantity;
    private Date timestamp;

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Date getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

}
