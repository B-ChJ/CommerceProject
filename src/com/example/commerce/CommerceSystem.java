package com.example.commerce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**프로그램 비즈니스 로직
 * 상품을 관리
 * 사용자의 입력값을 처리하는 클래스*/
public class CommerceSystem {
    private final List<Product> listProduct =  new ArrayList<>();

    public void start() {
        Scanner sc = new Scanner(System.in);
        Product p = new Product();

        while(!sc.nextLine().equals("exit")){

            System.out.println("상품명을 입력해 주세요.");
            String name = sc.nextLine();
            System.out.println("상품의 설명을 입력해 주세요.");
            String description = sc.nextLine();
            System.out.println("상품의 가격을 입력해 주세요.");
            String price = sc.nextLine();
            System.out.println("상품의 재고수량을 입력해 주세요.");
            String quantity = sc.next();

            p.addProducts(name, description, price, quantity);
            this.listProduct.add(p);

            System.out.println("새로운 상품을 추가하시겠습니까?\nexit 입력 시 상품 추가 종료");
            sc.nextLine();
        }

        System.out.println("입력을 종료합니다.");
    }

    public ArrayList<String> getProducts() {
        ArrayList<String> products = new ArrayList<>();
        int number = 1;
        for (Product p : this.listProduct) {
            System.out.println(number + ". " + this.listProduct.get(number-1));
        }
        return products;
    }

    public List<Product> getListProduct() {
        return listProduct;
    }
}
