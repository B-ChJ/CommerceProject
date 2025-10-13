package com.example.commerce;

public class Order {
    private Cart cart;
    private Customer customer;
    private long waitingTime = System.nanoTime();
    private int processingTime;

    Order(Cart cart, Customer customer) {
        this.cart = cart;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Cart getCart() {
        return cart;
    }
    public void setCart(Cart cart1) {
        this.cart = cart1;
    }
    public int getProcessingTime() {
        return processingTime;
    }
    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
    }
    public String getCustomerName() {
        return this.customer.getCustomerName();
    }
    public void setCustomerName(String customerName) {
        this.customer.setCustomerName(customerName);
    }
    public void setWaitingTime() {
        this.waitingTime = System.nanoTime();
    }
    public long getWaitingTime() {
        return System.nanoTime() - waitingTime;
    }
}
