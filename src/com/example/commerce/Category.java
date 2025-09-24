package com.example.commerce;

import java.util.ArrayList;
import java.util.List;

/**Product 클래스를 리스트로 관리*/
public class Category {
    //1. 속성
    private String categoryName;
    private List<Product> products = new ArrayList<>();

    //2. 생성자
    public Category(String categoryName, Product... product) {
        this.categoryName = categoryName;
        for(Product p : product) {
            products.add(p);
        }
    }
    //3. 기능
    public void initialCategory() {
    Category electronics = new Category("electronics", new Product("Galaxy S25", "최신 안드로이드 스마트폰", 1200000, 100),
            new Product("iPhone 16", "Apple의 최신 스마트폰", 1350000, 120),
            new Product("MacBook Pro", "M3 칩셋이 탑재된 노트북", 2400000, 70),
            new Product("AirPods Pro", "노이즈 캔슬링 무선 이어폰", 350000, 56));

    Category clothes = new Category("clothes", new Product("WoolSweater", "울 소재 스웨터", 34000, 200),
            new Product("Shirt", "기본 하얀 와이셔츠", 10000, 489),
            new Product("T-shirt", "반팔 무지 티셔츠", 5000, 326),
            new Product("Wide-pants", "통 넓은 슬랙스 바지", 27000, 175));

    Category foods = new Category("foods", new Product("돼지국밥", "머릿고기, 깍두기 제공", 8500, 50),
            new Product("베이컨 크림 파스타", "꾸덕촉촉한 크림과 짭짤한 베이컨의 조화", 13000, 85),
            new Product("중화비빔밥", "불맛 가득 건더기 듬뿍(계란후라이는 완숙)", 11000, 61),
            new Product("새우튀김우동", "뜨끈한 우동 위에 왕새우 튀김 2마리", 12000, 20));
    }
}
