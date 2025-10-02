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
    private String name;
    private String description;
    private int price;
    private int quantity;
    //private int count=0;

    // 2. 생성자
    public Product(String name, String description, int price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    // 3. 기능
    /**Getter Method*/
    //상품명을 String으로 return
    public String getName() {
        return name;
    }
    //상품 설명을 String으로 return
    public String getDescription() {
        return description;
    }
    //가격을 int로 return
    public int getPrice() {
        return price;
    }
    //재고 수량을 int로 return
    public int getQuantity() {
        return quantity;
    }
    //주문 수량을 int로 return
//    public int getCount() {
//        return count;
//    }

    /**Setter Method*/
    //입력값 String name을 Product의 상품명으로 입력
    public void setName(String name) {
        this.name = name;
    }
    //입력값 int price를 Product의 가격으로 입력
    public void setPrice(int price) {
        this.price = price;
    }
    //입력값 int quantity를 Product의 재고 수량으로 입력
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    //입력값 String description을 Product의 상품 설명으로 입력
    public void setDescription(String description) {
        this.description = description;
    }
    //입력값 int count를 Product의 주문 수량으로 입력
//    public void setCount(int count) {
//        this.count = count;
//    }

    // 출력되는 형태를 "상품명 | 가격 | 상품설명" 방식으로 고정한다.
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("###,###");
        String str = String.format("%s | %s원 | %s", name, df.format(price), description);
        return str;
    }

}