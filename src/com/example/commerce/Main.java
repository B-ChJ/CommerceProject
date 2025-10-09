package com.example.commerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 전자제품 상품
        Product electronics1 = new Product("Galaxy S25", "최신 안드로이드 스마트폰", 1200000, 100);
        Product electronics2 = new Product("iPhone 16", "Apple의 최신 스마트폰", 1350000, 120);
        Product electronics3 = new Product("MacBook Pro", "M3 칩셋이 탑재된 노트북", 2400000, 70);
        Product electronics4 = new Product("AirPods Pro", "노이즈 캔슬링 무선 이어폰", 350000, 56);
        Category electronics = new Category("전자제품", electronics1, electronics2, electronics3, electronics4);
        // 의류 상품
        Product clothes1 = new Product("WoolSweater", "울 소재 스웨터", 34000, 200);
        Product clothes2 = new Product("Shirt", "기본 하얀 와이셔츠", 9900, 489);
        Product clothes3 = new Product("T-shirt", "반팔 무지 티셔츠", 5000, 326);
        Product clothes4 = new Product("Wide-pants", "통 넓은 슬랙스 바지", 27000, 175);
        Category clothes = new Category("의류", clothes1, clothes2, clothes3, clothes4);
        // 음식 상품
        Product foods1 = new Product("돼지국밥", "머릿고기, 깍두기 제공", 8500, 34);
        Product foods2 = new Product("베이컨 크림 파스타", "꾸덕촉촉한 크림과 짭짤한 베이컨의 조화", 13000, 13);
        Product foods3 = new Product("중화비빔밥", "불맛 가득 건더기 듬뿍(계란후라이는 완숙)", 11000, 8);
        Product foods4 = new Product("새우튀김우동", "뜨끈한 우동 위에 왕새우 튀김 2마리", 12000, 3);
        Category foods = new Category("음식", foods1, foods2, foods3, foods4);

        List<Category> categories = new ArrayList<>();
        categories.add(electronics);
        categories.add(clothes);
        categories.add(foods);
        Scanner input = new Scanner(System.in);
        System.out.println("검색할 상품명을 입력해 주세요.");
        String productName = input.nextLine();
        Product p = new Product("", "", 0, 0);

        for(Category c : categories) {
            SearchEngine searchEngine = new SearchEngine(c);
            int left = 0;
            int right = c.getCategoryList().size()-1;
            p = searchEngine.binarySearchRecursive(productName, left, right);
            if(p != null) {break;}
        }
        System.out.println(p.toString());

        CommerceSystem commerceSystem = new CommerceSystem();
        commerceSystem.start(categories); // 비즈니스 로직 시작
    }
}
