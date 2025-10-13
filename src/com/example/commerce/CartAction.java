package com.example.commerce;

import java.util.Date;

public class CartAction {
    private ActionType type; // ADD, REMOVE
    private Product product;
    private int quantity;
    private int beforeQuantity;
    private Date timestamp;

    public CartAction(ActionType type, Product product, int quantity, int beforeQuantity) {
        this.type = type;
        this.product = product;
        this.quantity = quantity;
        this.beforeQuantity = beforeQuantity;
        this.timestamp = new Date();
    }

    public ActionType getActionType() {
        return type;
    }
    public void setActionType(ActionType type) {
        this.type = type;
    }
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
    public int getBeforeQuantity() {
        return beforeQuantity;
    }
    public void setBeforeQuantity(int beforeQuantity) {
        this.beforeQuantity = beforeQuantity;
    }
    public Date getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return (this.product.toString() +  " | " + this.type.toString() + " | 현재 주문수량 " + this.quantity + "개 | 수정 전 주문 수량 " + this.beforeQuantity + " | " + this.timestamp.toString());
    }
}
