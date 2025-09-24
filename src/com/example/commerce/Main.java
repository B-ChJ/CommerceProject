package com.example.commerce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product elecP1 = new Product("Galaxy S25", "최신 안드로이드 스마트폰", 1200000, 100);
        Product elecP2 = new Product("iPhone 16", "Apple의 최신 스마트폰", 1350000, 120);
        Product elecP3 = new Product("MacBook Pro", "M3 칩셋이 탑재된 노트북", 2400000, 70);
        Product elecP4 = new Product("AirPods Pro", "노이즈 캔슬링 무선 이어폰", 350000, 56);

        List<Product> products = new ArrayList<>();
        Collections.addAll(products, elecP1, elecP2, elecP3, elecP4);
        Scanner input = new Scanner(System.in);

        //do-while 반복문으로 일단 상품 목록 1회 출력 후 조건문 check
        do {
            System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
            for(int i=0; i<products.size(); i++) {
            System.out.println((i+1) + ". " + products.get(i));
        }
        System.out.println("0. 종료 | 프로그램 종료\n재고 수량을 조회하고 싶은 상품의 번호를 입력해 주세요.");
            int i = input.nextInt();
            if(i==0) {
                break;
            }
            else products.get(i-1);
        }while(!input.next().equals("0"));
        input.close();
    }
}
