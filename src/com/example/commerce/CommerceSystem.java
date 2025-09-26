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
        Product choiceProduct;
        int choice;
        Cart cart = new Cart();

        //do-while 반복문으로 일단 상품 목록 1회 출력 후 조건문 check
        do {
            //메인에서 조회할 카테고리를 고르도록 카테고리 이름을 출력
            System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
            for (Category c : Category.values()) {
                System.out.println((c.ordinal()+1) + ". " + c.getCategoryName());
            }
            System.out.println("0. 종료 | 프로그램 종료");
            System.out.println("6. 관리자 모드");
            //장바구니가 비어있으면 다음 단계로 진행
            if(!(cart.getCart() == null || cart.getCart().isEmpty())){
            //장바구니가 null이 아닐 경우 Cart 관련 동작을 보여줌
                System.out.println("\n[ 주문 관리 ]");
                System.out.println("4. 장바구니 확인 | 장바구니를 확인 후 주문합니다.");
                System.out.println("5. 주문 취소 | 진행 중인 주문을 취소합니다.");
            }
            int numCategory = input.nextInt();
            if(numCategory == 0){ break; } //프로그램 종료
            //카테고리 내 상품 정보 조회
            else if(numCategory < 4) {
                switch (numCategory) {
                    case 1:
                        Category.printProducts(Category.ELECTRONICS);
                        choiceProduct = Category.printProductQuantity(Category.ELECTRONICS, input.nextInt());
                        System.out.println("위 상품을 장바구니에 추가하시겠습니까?\n1. 확인       2. 취소");
                        choice = input.nextInt();
                        this.checkChoice(cart, choiceProduct, choice);
                        break;
                    case 2:
                        Category.printProducts(Category.CLOTHES);
                        choiceProduct = Category.printProductQuantity(Category.CLOTHES, input.nextInt());
                        System.out.println("위 상품을 장바구니에 추가하시겠습니까?\n1. 확인       2. 취소");
                        choice = input.nextInt();
                        this.checkChoice(cart, choiceProduct, choice);
                        break;
                    case 3:
                        Category.printProducts(Category.FOODS);
                        choiceProduct = Category.printProductQuantity(Category.FOODS, input.nextInt());
                        System.out.println("위 상품을 장바구니에 추가하시겠습니까?\n1. 확인       2. 취소");
                        choice = input.nextInt();
                        this.checkChoice(cart, choiceProduct, choice);
                        break;
                    default: throw new IllegalArgumentException("유효하지 않은 카테고리 번호입니다.");
                }
                System.out.println("0. 뒤로가기");
                int num = input.nextInt();
                //while문이 종료되지 않도록 입력값 임의의 int 값으로 변경
                if(num==0){ num = 10; }
            }
            else {
                switch (numCategory) {
                    case 4:
                        System.out.println("아래와 같이 주문하시겠습니까?");
                        int total = cart.printCart();
                        System.out.println("1. 주문 확정     2. 메인으로 돌아가기");
                        choice = input.nextInt();
                        switch (choice) {
                            case 1:
                                System.out.println("주문이 완료되었습니다! 총 금액: " + total + "원");
                                cart.subProductQuantity();
                                Category.setProductQuantity(cart);
                                cart.removeAllProduct();
                                break;
                            case 2: break;
                            default: throw new IllegalArgumentException("1 또는 2를 입력해 주세요.");
                        } break;
                    case 5: cart.removeAllProduct(); break;
                    case 6: Administrator.adminMode(cart); break;
                    default: throw new IllegalArgumentException("유효하지 않은 카테고리 번호입니다.");
                }
            }
        }while(!input.nextLine().equals("0"));
        input.close();

        System.out.println("입력을 종료합니다.");
    }
    public void checkChoice(Cart cart, Product product, int choice) {
        switch (choice) {
            case 1:
                cart.setCart(product);
                System.out.println(product.getName() + "이(가) 장바구니에 추가되었습니다.");
                break;
            case 2: break;
            default: throw new IllegalArgumentException("1 또는 2를 입력해 주세요.");
        }
    }
}
