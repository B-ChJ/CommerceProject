package com.example.commerce;

import java.util.ArrayList;
import java.util.Collections;
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
    private final List<String> products =  new ArrayList<>();

    // 2. 생성자

    // 3. 기능
    public void addProducts(String name, String price, String description, String quantity) {
        Collections.addAll(products, name, price, description, quantity);
    }

    public void getProductInfo(int index) {
        System.out.println(products.get(index) + " | "
                + products.get(index+1) + "원 | "
                + products.get(index+2));
    }

    public int size() {
        return products.size();
    }
}