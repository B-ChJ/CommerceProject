package com.example.commerce;

public enum CustomerRank {
    BRONZE("Bronze", 0.0),
    SILVER("Silver", 0.05),
    GOLD("Gold", 0.1),
    PLATINUM("Platinum", 0.15);

    private String rank;
    private double discount;

    CustomerRank(String rank, double price) {
        this.rank = rank;
        this.discount = price;
    }

    public String getRank() {
        return rank;
    }
    public double getDiscount() {
        return discount;
    }
}
