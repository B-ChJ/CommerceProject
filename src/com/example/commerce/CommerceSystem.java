package com.example.commerce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**프로그램 비즈니스 로직
 * 상품을 관리
 * 사용자의 입력값을 처리하는 클래스*/
public class CommerceSystem {
    //1. 속성
    //private Category category = new Category();
    //2. 생성자
    //3. 기능
    //상품 목록 products의 값을 가져오는 메서드

    public void start() {
        Scanner input = new Scanner(System.in);

        //do-while 반복문으로 일단 상품 목록 1회 출력 후 조건문 check
        do {
            //메인에서 조회할 카테고리를 고르도록 카테고리 이름을 출력
            System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
            for (Category c : Category.values()) {
                System.out.println((c.ordinal()+1) + ". " + c.getCategoryName());
            }
            System.out.println("0. 종료 | 프로그램 종료");
            int numCategory = input.nextInt();
            if(numCategory == 0){ break; }
            else {
                switch (numCategory) {
                    case 1:
                        this.getProductInfo(Category.ELECTRONICS);
                        break;
                        case 2:
                            this.getProductInfo(Category.CLOTHES);
                            break;
                            case 3:
                                this.getProductInfo(Category.FOODS);
                                break;
                    default: throw new IllegalArgumentException("유효하지 않은 카테고리 번호입니다.");
                }
                System.out.println("0. 뒤로가기");

            }

            System.out.println("0. 종료 | 프로그램 종료\n다시 전체 상품 목록을 조회하시겠습니까? (yes/0)");
        }while(!input.nextLine().equals("0"));
        input.close();

        System.out.println("입력을 종료합니다.");
    }
    //카테고리 목록의 상품 정보를 조회하는 메서드
    public void getProductInfo(Category category) {
            String oneLine = (category.ordinal()+1) + ". " + category.getCategoryList().stream().map(product -> product.toString()).collect(Collectors.joining("\n"));
            System.out.println(oneLine);
        }
}
