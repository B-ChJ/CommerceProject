package com.example.commerce;

import java.util.Scanner;

public class Administrator {
    //1. 속성
    private final String password = "admin123"; //비밀번호

    public Product getNewProduct() {
        Scanner input = new Scanner(System.in);
        System.out.println("어느 카테고리에 상품을 추가하시겠습니까?");
        for (Category c : Category.values()) {
            System.out.println((c.ordinal()+1) + ". " + c.getCategoryName());
        }
        int index = input.nextInt();
        System.out.println("[ " + Category.values()[index].getCategoryName() + " 카테고리에 상품 추가 ]");
        System.out.print("상품명을 입력해 주세요: ");
        String name = input.nextLine();
        if (Category.values()[index].getCategoryName().equals(name)) {
            System.out.println("이미 같은 상품명이 등록되어 있습니다.");
            return null;
        }
        System.out.print("상품 설명을 입력해 주세요: ");
        String description = input.nextLine();
        System.out.print("가격을 입력해 주세요: ");
        int price = input.nextInt();
        System.out.print("재고 수량을 입력해 주세요: ");
        int quantity = input.nextInt();

        Product product = new Product(name, description, price, quantity);
        System.out.println(product.toString() + " | 재고: " + quantity + "개");
        System.out.println("위 정보로 상품을 추가하시겠습니까?");
        System.out.println("1. 확인     2. 취소");

        if(input.nextInt() == 1) {
            Category.addProduct(index, product);
            System.out.println("상품이 성공적으로 추가되었습니다!");
            return product;
        }
        else if(input.nextInt() == 2) {
            System.out.println("상품 추가를 취소하였습니다. 관리자 모드로 돌아갑니다.");
            return null;
        }
        else throw new IllegalArgumentException("1 또는 2를 입력해 주세요.");
    }
}
