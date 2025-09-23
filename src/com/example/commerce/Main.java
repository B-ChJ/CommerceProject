package com.example.commerce;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("상품을 등록하시겠습니까? 종료를 원할 경우 exit를 입력하세요.\nEnter yes to console...");
        String name, description, price, quantity;
        Product product = new Product();
        int number = 0;

        while(!input.nextLine().equals("exit")){

            System.out.println("상품명을 입력해 주세요.");
            name = input.nextLine();
            System.out.println("상품의 설명을 입력해 주세요.");
            description = input.nextLine();
            System.out.println("상품의 가격을 입력해 주세요.");
            price = input.nextLine();
            System.out.println("상품의 재고수량을 입력해 주세요.");
            quantity = input.next();

            product.addProducts(name, price, description, quantity);
            number++;

            System.out.println("새로운 상품을 추가하시겠습니까?\nexit 입력 시 프로그램 종료");
            input.nextLine();
        }
        for (int i = 0; i < product.size(); i=i+4) {
            System.out.print(number + ". ");
            product.getProductInfo(i);
        }

        input.close();
    }
}
