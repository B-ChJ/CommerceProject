package com.example.commerce;

public class Customer {

    //1. 속성
    private String customerName;
    private String customerEmail;
    private CustomerRank customerRank;
    //2. 생성자
    Customer(String customerName, String customerEmail) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }
    //3. 기능
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerEmail() {
        return customerEmail;
    }
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
    public CustomerRank getCustomerRank() {
        return customerRank;
    }
    public void setCustomerRank(CustomerRank customerRank) {
        this.customerRank = customerRank;
    }
}
