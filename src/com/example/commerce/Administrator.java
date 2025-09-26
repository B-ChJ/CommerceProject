package com.example.commerce;

import java.util.Arrays;
import java.util.Scanner;

public class Administrator {
    //1. 속성
    private final String password = "admin123"; //비밀번호

    //3. 기능
    public String getPassword() {
        return password;
    }

    public static void adminMode() {
        Scanner input = new Scanner(System.in);
        Administrator admin = new Administrator();
        System.out.println("관리자 비밀번호를 입력해 주세요: ");
        int chance = 3;
        while (chance != 0) {
            String answer = input.nextLine();
            if(!answer.equals(admin.getPassword())) {
                System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해 주세요.\n3회 이상 실패할 경우 메인으로 돌아갑니다.");
                chance--;
                System.out.println("남은 횟수: " + chance);
            } else if (answer.equals(admin.getPassword())) {
                break;
            }
        }
        if (chance == 0) {
            System.out.println("비밀번호를 3회 이상 틀리셨습니다. 메인으로 돌아갑니다.");
            return;
        }

        System.out.println("[ 관리자 모드 ]");
        System.out.println("1. 상품 추가\n2. 상품 수정\n3. 상품 삭제\n4. 전체 상품 현황\n0. 메인으로 돌아가기");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
        }
    }
    //새로운 상품을 추가하는 과정을 수행하는 메서드
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
    //기등록된 상품의 정보를 수정하는 메서드
    public void getUpdateProduct() {
        Scanner input = new Scanner(System.in);
        System.out.println("수정할 상품명을 입력해 주세요:");
        String name = input.nextLine();
        Product p = null;
        int index = 0;
        for (Category c : Category.values()) {
            if (c.getCategoryList().contains(name)) {
                p = c.getCategoryList().get(c.getCategoryList().indexOf(name));
                index = c.getCategoryList().indexOf(p);
            }
        }
        System.out.println("현재 상품 정보: " + p.toString() + " | 재고: " + p.getQuantity() + "개");
        int beforePrice = p.getPrice();
        String beforeDescription = p.getDescription();
        int beforeQuantity = p.getQuantity();
        System.out.println("\n수정할 항목을 선택해 주세요:");
        System.out.println("1. 가격\n2. 설명\n3. 재고 수량");
        int c = input.nextInt();
        switch (c) {
            case 1:
                System.out.println("현재 가격: " + beforePrice + "원");
                System.out.print("새로운 가격을 입력해 주세요: ");
                p.setPrice(input.nextInt());
                System.out.println(p.getName() + "의 가격이 " + beforePrice + "원 → " + p.getPrice() + "원으로 수정되었습니다.");
                break;
            case 2:
                System.out.println("현재 상품 설명: " + beforeDescription);
                System.out.print("새로운 상품 설명을 입력해 주세요: ");
                p.setDescription(input.nextLine());
                System.out.println(p.getName() + "의 상품 설명이 [ " + beforeDescription + " ] → [ " + p.getDescription() + "으로 수정되었습니다.");
                break;
            case 3:
                System.out.println("현재 재고 수량: " + beforeQuantity + "개");
                System.out.print("새로운 재고 수량을 입력해 주세요: ");
                p.setQuantity(input.nextInt());
                System.out.println(p.getName() + "의 재고 수량이 " + beforePrice + "개 → " + p.getPrice() + "개로 수정되었습니다.");
                break;
            default:
                throw new IllegalArgumentException("유효하지 않은 선택지입니다.");
        }
        Category.replaceProduct(index, p);
    }
}
