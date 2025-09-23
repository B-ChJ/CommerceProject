package com.example.commerce;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("상품을 등록하시겠습니까? 종료를 원할 경우 exit를 입력하세요.\nEnter yes to console...");
        Product product = new Product();
        int number = 1;
        CommerceSystem commerceSystem = new CommerceSystem();
        commerceSystem.start();

        System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
        commerceSystem.getProducts();
        System.out.println("0. 종료 | 프로그램 종료");
        if(input.next().equals("0")){ return; }
        else commerceSystem.start();
        input.close();
    }
}
