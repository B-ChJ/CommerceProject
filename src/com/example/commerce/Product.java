package com.example.commerce;

import java.util.ArrayList;
import java.util.List;

/**개별 상품 정보
 * Product 클래스는 개별 상품에 관한 이름, 설명, 가격, 재고수량 정보를 관리하는 클래스입니다.
 * @param name 상품명
 * @param price 상품의 가격
 * @param description 상품 설명
 * @param quantity 재고 수량
 */
public class Product {
    // 1. 속성
    String name;
    String description;
    int price;
    int quantity;

    // 2. 생성자
    Product(String name, int price, String description, int quantity) {
        if(name == null || price < 0 || quantity < 0) {
            throw new IllegalArgumentException("적절하지 않은 입력입니다. 다시 정보를 확인해 주세요.");
        }

        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    // 3. 기능
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        String str = name + " | " + price + "원 | " + description + " | " + quantity;
        return str;
    }

    public void setProducts(String name, int price, String description, int quantity) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(name, price, description, quantity));
    }
}