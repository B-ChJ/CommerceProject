package com.example.commerce;

public enum CustomerRank {
    BRONZE("Bronze", 0.0),
    SILVER("Silver", 0.05),
    GOLD("Gold", 0.1),
    PLATINUM("Platinum", 0.15);

    private String rank;
    private double discount;

    CustomerRank(String rank, double discount) {
        this.rank = rank;
        this.discount = discount;
    }

    @Override
    public String toString() {
        String str = ". " + rank + " : " + discount*100 + "% 할인";
        return str;
    }
    public String getRank() {
        return rank;
    }
    public double getDiscount() {
        return discount;
    }
}
