package com.example.commerce;

import java.util.List;
import java.util.Scanner;

/**프로그램 비즈니스 로직
 * 상품을 관리
 * 사용자의 입력값을 처리하는 클래스*/
public class CommerceSystem {
    //1. 속성
    Scanner input = new Scanner(System.in);
    private List<Category> categories;
    Product choiceProduct;
    int index, choice;
    public Cart cart;

    //2. 생성자
    //3. 기능
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    //프로그램 비즈니스를 실행하는 start() 메서드
    public void start(List<Category> category) {
        setCategories(category); // 카테고리 세팅
        this.cart = new Cart();
        Administrator admin = new Administrator();
        //do-while 반복문으로 일단 상품 목록 1회 출력 후 조건문 check
        do {
        systemStart();
            //장바구니가 비어있는지 Check
            if ( this.cart.getCart().size() != 0 ) {
                //장바구니가 null이 아닐 경우 Cart 관련 동작을 보여줌
                System.out.println("\n[ 주문 관리 ]");
                System.out.println("4. 장바구니 확인 | 장바구니를 확인 후 주문합니다.");
                System.out.println("5. 주문 취소 | 진행 중인 주문을 취소합니다.");
            }
        // (메인페이지) 분기점 1. 카테고리 내 상품 조회 | 2. 장바구니 | 3. 관리자 모드 | 0. 프로그램 종료
        choice = input.nextInt(); // 메뉴 선택지 번호 입력
        //카테고리 내 상품 정보 조회
        if (0 < choice && choice < 4) { //1~3번 선택지 동작 루트
            this.choiceCategory(choice, categories); // 카테고리의 가격대별 조회 화면으로 이동
            System.out.println("0. 뒤로가기");
            choice = input.nextInt();
            //while문이 종료되지 않도록 입력값 임의의 int 값으로 변경
            if(choice==0){
                choice = 10;
            }
        } else if(choice != 0) {
            switch (choice) {
                case 4: //장바구니 확인
                    System.out.println("아래와 같이 주문하시겠습니까?");
                    int total = cart.printCart();
                    System.out.println("1. 주문 확정     2. 메인으로 돌아가기");
                    choice = input.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("고객 등급을 입력해 주세요: ");
                            for (CustomerRank rank : CustomerRank.values()) {
                                System.out.println((rank.ordinal() + 1) + rank.toString());
                            }
                            int rankNum = input.nextInt();
                            checkRank(total, rankNum);
                            for(index = 0; index < cart.getCart().size(); index++) {
                                for(int i = 0; i < categories.size(); i++) {
                                    categories.get(i).setProductQuantity(cart.getCart().get(index));
                                }
                            }
                            cart.removeAllProduct();
                            break;
                        case 2:
                            break;
                        default:
                            throw new IllegalArgumentException("1 또는 2를 입력해 주세요.");
                    }
                    break;
                case 5:
                    cart.removeAllProduct();
                    break;
                case 6:
                    admin.adminMode(cart, categories);
                    break;
                case 7:
                    searchProduct();
                default:
                    throw new IllegalArgumentException("유효하지 않은 카테고리 번호입니다.");
            }
        }
        } while (choice!=0);
        input.close();

        System.out.println("입력을 종료합니다.");
    }

    private void searchProduct() {
        System.out.println("=== 상품 검색 시스템 ===");
        System.out.println("검색어를 입력하세요: ");
        String productName = input.nextLine();

        System.out.println("[ " + productName + "으로 시작하는 상품" + " ]");

    }

    private void checkRank(int total, int rankNum) {
        String rank = "";
        double discount = 0;
        int discountTotal = 0;
        switch (rankNum) {
            case 1:
                discountTotal = (int) (total * (1 - CustomerRank.BRONZE.getDiscount()));
                rank = CustomerRank.BRONZE.getRank();
                discount = CustomerRank.BRONZE.getDiscount();
                break;
            case 2:
                discountTotal = (int) (total * (1 - CustomerRank.SILVER.getDiscount()));
                rank = CustomerRank.SILVER.getRank();
                discount = CustomerRank.SILVER.getDiscount();
                break;
            case 3:
                discountTotal = (int) (total * (1 - CustomerRank.GOLD.getDiscount()));
                rank = CustomerRank.GOLD.getRank();
                discount = CustomerRank.GOLD.getDiscount();
                break;
            case 4:
                discountTotal = (int) (total * (1 - CustomerRank.PLATINUM.getDiscount()));
                rank = CustomerRank.PLATINUM.getRank();
                discount = CustomerRank.PLATINUM.getDiscount();
                break;
            default:
                break;
        }
        System.out.println("주문이 완료되었습니다!");
        System.out.println("할인 전 금액: " + total + "원");
        System.out.println(rank + "등급 할인(" + discount * 100 + "%): -" + (total - discountTotal) + "원");
        System.out.println("최종 결제 금액: " + discountTotal + "원");
    }

    // 메인 페이지 내용을 출력하는 메서드
    public void systemStart() {
            //메인에서 조회할 카테고리를 고르도록 카테고리 이름을 출력
            System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
            index = 1;
            for (Category c : this.categories) { //카테고리 번호 + 이름 출력
                System.out.println(index + ". " + c.getCategoryName());
                index++;
            }
            System.out.println("0. 종료 | 프로그램 종료");
            System.out.println("6. 관리자 모드");
            System.out.println("7. 상품 검색 성능 테스트");
    }

    public void checkChoice(Cart cart, Product product, int choice) {
        switch (choice) {
            case 1:
                this.cart.addCart(product);
                System.out.println(product.getName() + "이(가) 장바구니에 추가되었습니다.");
                break;
            case 2:
                break;
            default:
                throw new IllegalArgumentException("1 또는 2를 입력해 주세요.");
        }
    }

    public void choiceCategory(int number, List<Category> categories) {
        int standard = 10000;
        if(number == 1) {
            standard = 1000000;
        }
        System.out.println("[ " + categories.get(number-1).getCategoryName() + " 카테고리 ]");
        System.out.println("1. 전체 상품 보기\n2. 가격대별 필터링 ( ~ " + standard + "원");
        System.out.println("3. 가격대별 필터링 (" + standard + "원 ~ )\n0. 뒤로 가기");
        choice = input.nextInt();
        if(choice==0) { return; }
        choiceProduct = filterProduct(choice, standard, categories.get(number-1));
        System.out.println("위 상품을 장바구니에 추가하시겠습니까?\n1. 확인       2. 취소");
        choice = input.nextInt();
        this.checkChoice(cart, choiceProduct, choice);
    }
    //가격대 필터를 적용해 상품 목록을 보여주는 분기점 메서드
    public Product filterProduct(int choice, int standard, Category category) {
        List<Product> tmp;
        switch (choice) {
            case 1:
                Category.printProducts(category);
                choiceProduct = category.getCategoryList().get(input.nextInt()-1);
                break;
            case 2:
                tmp = category.getCategoryList().stream().filter(product -> product.getPrice() < standard).toList();
                choiceProduct = filteredList(tmp);
                break;
            case 3:
                tmp = category.getCategoryList().stream().filter(product -> product.getPrice() > standard).toList();
                choiceProduct = filteredList(tmp);
                break;
            default: throw new ArrayIndexOutOfBoundsException("유효하지 않은 번호입니다.");
        }
        System.out.println("선택한 상품: " + choiceProduct.toString() + " | 재고수량: " + choiceProduct.getQuantity() + "개");
        return choiceProduct;
    }
    public Product filteredList(List<Product> tmp) {
        int i=1;
        for (Product p : tmp) {
            if(p==null) { break; }
            else System.out.println(i + ". " + p);
            i++;
        }
        choiceProduct = tmp.get(input.nextInt()-1);
        return choiceProduct;
    }
}
