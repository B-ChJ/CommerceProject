package com.example.commerce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**프로그램 비즈니스 로직
 * 상품을 관리
 * 사용자의 입력값을 처리하는 클래스*/
public class CommerceSystem {
    private List<Product> products =  new ArrayList<>();
    //3. 기능
    //Product 클래스 객체 p를 CommerceSystem 클래스에서 List 내용으로 추가하는 setter 메서드
    public void addProduct(Product p) {
        Collections.addAll(products, p);
    }
    //상품 목록 products의 값을 가져오는 메서드
    public List<Product> getProductList() {
        return products;
    }

    public void start() {
        Scanner input = new Scanner(System.in);

        //do-while 반복문으로 일단 상품 목록 1회 출력 후 조건문 check
        do {
            System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
            for(int i=0; i<products.size(); i++) {
                System.out.println((i+1) + ". " + products.get(i));
            }
            System.out.println("0. 종료 | 프로그램 종료\n다시 전체 상품 목록을 조회하시겠습니까? (yes/0)");
        }while(!input.nextLine().equals("0"));
        input.close();

        System.out.println("입력을 종료합니다.");
    }
    //상품 목록 중 한 상품의 정보와 재고 수량을 조회하는 메서드
    public List<Product> getProductInfo(int index) {
        if(index==0) {
            throw new IllegalArgumentException("상품 번호는 1번부터 시작합니다.");
        }
        else System.out.println((index-1) + ". " + products.get(index-1) + " | " + products.get(index-1).quantity + "개");
        return products;
    }

}
