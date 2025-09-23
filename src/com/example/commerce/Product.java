package com.example.commerce;

import java.util.ArrayList;
import java.util.List;

/**개별 상품 정보
 * Product 클래스는 개별 상품에 관한 이름, 설명, 가격, 재고수량 정보를 관리하는 클래스입니다.
 * @param name 상품명
 * @param price 상품의 가격
 * @param description 상품 설명
 * @param quantity 재고 수량*/
public class Product {
    // 1. 속성
    String name;
    String description;
    int price;
    int quantity;

    // 2. 생성자
    Product(String name, int price, String description, int quantity) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    // 3. 기능
    public void getProducts() {
    }
    public List<Product> setProducts(String name, int price, String description, int quantity) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(name, price, description, quantity));
        return products;
    }
}
