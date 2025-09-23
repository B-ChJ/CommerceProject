package com.example.commerce;

import java.text.DecimalFormat;
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
    String name;
    String description;
    int price;
    int quantity;

    // 2. 생성자
    public Product(String name, String description, int price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    // 3. 기능
    public void addProducts(String name, String price, String description, String quantity) {

    }

    // 출력되는 형태를 "상품명 | 가격 | 상품설명" 방식으로 고정한다.
@Override
public String toString() {
        DecimalFormat df = new DecimalFormat("###,###");
        String str = name + " | " + df.format(price) + "원 | " + description;
        return str;
}

//    public void getProductInfo(int index) {
//        System.out.println(products.get(index) + " | "
//                + products.get(index+1) + "원 | "
//                + products.get(index+2));
//    }

}