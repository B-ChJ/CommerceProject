package com.example.commerce;

public class Order {
    private Product product;
    private Customer customer;
    private int processingTime;

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
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
}
