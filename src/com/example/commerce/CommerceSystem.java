package com.example.commerce;

import java.util.Scanner;

/**프로그램 비즈니스 로직
 * 상품을 관리
 * 사용자의 입력값을 처리하는 클래스*/
public class CommerceSystem {
    //1. 속성
    //2. 생성자
    //3. 기능
    //프로그램 비즈니스를 실행하는 start() 메서드
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
                Product choiceProduct;
                int choice;
                switch (numCategory) {
                    case 1:
                        Category.printProducts(Category.ELECTRONICS);
                        choiceProduct = Category.printProductQuantity(Category.ELECTRONICS, input.nextInt());
                        System.out.println("위 상품을 장바구니에 추가하시겠습니까?\n1. 확인       2. 취소");
                        choice = input.nextInt();
                        this.checkChoice(choiceProduct, choice);
                        break;
                    case 2:
                        Category.printProducts(Category.CLOTHES);
                        choiceProduct = Category.printProductQuantity(Category.CLOTHES, input.nextInt());
                        System.out.println("위 상품을 장바구니에 추가하시겠습니까?\n1. 확인       2. 취소");
                        choice = input.nextInt();
                        this.checkChoice(choiceProduct, choice);
                        break;
                    case 3:
                        Category.printProducts(Category.FOODS);
                        choiceProduct = Category.printProductQuantity(Category.FOODS, input.nextInt());
                        System.out.println("위 상품을 장바구니에 추가하시겠습니까?\n1. 확인       2. 취소");
                        choice = input.nextInt();
                        this.checkChoice(choiceProduct, choice);
                        break;
                    default: throw new IllegalArgumentException("유효하지 않은 카테고리 번호입니다.");
                }
                System.out.println("0. 뒤로가기");
                int num = input.nextInt();
                //while문이 종료되지 않도록 입력값 임의의 int 값으로 변경
                if(num==0){ num = 10; }
            }
        }while(!input.nextLine().equals("0"));
        input.close();

        System.out.println("입력을 종료합니다.");
    }
    public void checkChoice(Product product, int choice) {
        switch (choice) {
            case 1: Cart cart = new Cart();
                cart.setCart(product);
                System.out.println(product.name + "이(가) 장바구니에 추가되었습니다.");
                break;
            case 2: break;
            default: throw new IllegalArgumentException("1 또는 2를 입력해 주세요.");
        }
    }
}
