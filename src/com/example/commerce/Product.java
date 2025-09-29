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
    private int count=0;

    // 2. 생성자
    public Product(String name, String description, int price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
    // 전자제품 상품
    Product electronics1 = new Product("Galaxy S25", "최신 안드로이드 스마트폰", 1200000, 100);
    Product electronics2 = new Product("iPhone 16", "Apple의 최신 스마트폰", 1350000, 120);
    Product electronics3 = new Product("MacBook Pro", "M3 칩셋이 탑재된 노트북", 2400000, 70);
    Product electronics4 = new Product("AirPods Pro", "노이즈 캔슬링 무선 이어폰", 350000, 56);
    // 의류 상품
    Product clothes1 = new Product("WoolSweater", "울 소재 스웨터", 34000, 200);
    Product clothes2 = new Product("Shirt", "기본 하얀 와이셔츠", 10000, 489);
    Product clothes3 = new Product("T-shirt", "반팔 무지 티셔츠", 5000, 326);
    Product clothes4 = new Product("Wide-pants", "통 넓은 슬랙스 바지", 27000, 175);
    // 음식 상품
    Product foods1 = new Product("돼지국밥", "머릿고기, 깍두기 제공", 8500, 34);
    Product foods2 = new Product("베이컨 크림 파스타", "꾸덕촉촉한 크림과 짭짤한 베이컨의 조화", 13000, 13);
    Product foods3 = new Product("중화비빔밥", "불맛 가득 건더기 듬뿍(계란후라이는 완숙)", 11000, 8);
    Product foods4 = new Product("새우튀김우동", "뜨끈한 우동 위에 왕새우 튀김 2마리", 12000, 3);

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
    public int getCount() {
        return count;
    }

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
    public void setCount(int count) {
        this.count = count;
    }

    // 출력되는 형태를 "상품명 | 가격 | 상품설명" 방식으로 고정한다.
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("###,###");
        String str = String.format("%s | %s원 | %s", name, df.format(price), description);
        return str;
    }
}