package com.example.commerce;

public class Customer {
    //1. 속성
    private String customerName;
    private String customerEmail;
    private String customerRank;
    //2. 생성자
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
    public String getCustomerRank() {
        return customerRank;
    }

}
