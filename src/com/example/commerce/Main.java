package com.example.commerce;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Product product = new Product();

        System.out.println("상품명을 입력해 주세요.");
        String name = input.nextLine();
        System.out.println("상품의 가격을 입력해 주세요.");
        String price = input.next();
        System.out.println("상품의 설명을 입력해 주세요.");
        String description = input.nextLine();

    }
}
