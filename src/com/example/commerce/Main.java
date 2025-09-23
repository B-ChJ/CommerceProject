package com.example.commerce;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("상품명을 입력해 주세요.");
        String name = input.nextLine();
        System.out.println("상품의 가격을 입력해 주세요.");
        int price = input.nextInt();
        System.out.println("상품의 설명을 입력해 주세요.");
        String description = input.nextLine();
        System.out.println("상품의 재고수량을 입력해 주세요.");
        int quantity = input.nextInt();


        Product product = new Product(name, price, description, quantity);


    }
}
