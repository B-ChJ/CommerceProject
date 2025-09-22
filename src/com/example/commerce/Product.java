package com.example.commerce;

import java.util.ArrayList;
import java.util.List;

/**개별 상품 정보*/
public enum Product {
    NAME,
    PRICE,
    DESCRIPTION,
    QUANTITY;

    Product(String name, int price, String description, int quantity) {}
}
