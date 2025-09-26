package com.example.commerce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**Product 클래스를 리스트로 관리*/
public enum Category {
    ELECTRONICS("전자제품", new Product("Galaxy S25", "최신 안드로이드 스마트폰", 1200000, 100),
            new Product("iPhone 16", "Apple의 최신 스마트폰", 1350000, 120),
            new Product("MacBook Pro", "M3 칩셋이 탑재된 노트북", 2400000, 70),
            new Product("AirPods Pro", "노이즈 캔슬링 무선 이어폰", 350000, 56)),
    CLOTHES("의류", new Product("WoolSweater", "울 소재 스웨터", 34000, 200),
            new Product("Shirt", "기본 하얀 와이셔츠", 10000, 489),
            new Product("T-shirt", "반팔 무지 티셔츠", 5000, 326),
            new Product("Wide-pants", "통 넓은 슬랙스 바지", 27000, 175)),
    FOODS("음식", new Product("돼지국밥", "머릿고기, 깍두기 제공", 8500, 34),
            new Product("베이컨 크림 파스타", "꾸덕촉촉한 크림과 짭짤한 베이컨의 조화", 13000, 13),
            new Product("중화비빔밥", "불맛 가득 건더기 듬뿍(계란후라이는 완숙)", 11000, 8),
            new Product("새우튀김우동", "뜨끈한 우동 위에 왕새우 튀김 2마리", 12000, 3));

    //1. 속성
    private final String categoryName;
    private final List<Product> products = new ArrayList<>();

    //2. 생성자
    Category(String categoryName, Product... product) {
        this.categoryName = categoryName;
        products.addAll(Arrays.asList(product));
    }

    //3. 기능
//Category의 Product 객체들을 반환하는 getter 메서드
    public List<Product> getCategoryList() {
        return products;
    }
    //입력받은 상품명name과 일치하는 Product 정보를 반환하는 메서드
    public Product findProduct(String productName) {
        for (Product product : getCategoryList()) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }
    //Product 객체를 목록으로 출력하는 메서드
    public static void printProducts(Category category) {
        String[] str = category.products.stream().map(product -> product.toString()).toArray(String[]::new);
        for (int i=0; i<category.products.size(); i++) {
            System.out.println((i+1) + ". " + str[i]);
        }
    }
    //선택한 상품 정보와 재고 수량을 출력하고 해당 Product를 반환하는 메서드
    public static Product printProductQuantity(Category category, int i) {
        if(i > category.products.size()) {
            throw new IllegalArgumentException("존재하지 않는 상품 번호입니다.");
        }
        System.out.println("선택한 상품: " + category.products.get(i-1).toString() + " | 재고수량: " + category.products.get(i-1).getQuantity() + "개");
        return category.products.get(i-1);
    }
    //카테고리 이름을 반환하는 getter 메서드
    public String getCategoryName() {
        return categoryName;
    }
    //주문 완료 후 변경된 재고수량을 갖고 있는 Cart를 Category의 Product에 반영하는 메서드
    public static void setProductQuantity(Cart cart) {
        for(Product p : cart.getCart()) {
            Arrays.stream(Category.values()).map(category -> category.products.set(category.products.indexOf(p), p));
        }
    }
    //각 카테고리에 새로운 상품을 추가하는 메서드
    public static void addProduct(int index, Product product) {
        switch (index) {
            case 1: ELECTRONICS.products.add(product); break;
            case 2: CLOTHES.products.add(product); break;
            case 3: FOODS.products.add(product); break;
            default: throw new ArrayIndexOutOfBoundsException(index + "은(는) 존재하지 않는 카테고리 번호입니다.");
        }
    }
    //상품의 상세 정보를 수정하는 메서드
    public static void replaceProduct(int index, Product product) {
        Product set = Category.values()[index].getCategoryList().set(index, product);
    }
    /**등록되어 있던 상품을 삭제하는 메서드
     * @param index 삭제할 상품의 카테고리 번호
     * @param product 삭제할 상품 Product element*/
    public static void removeProduct(int index, Product product) {
        boolean success; //삭제 성공 여부를 확인하기 위한 flag 용도
        switch (index) {
            case 1: success = ELECTRONICS.products.remove(product);
            if(success) { System.out.println("상품을 성공적으로 삭제하였습니다."); }
            else throw new IllegalArgumentException("상품이 전자제품 카테고리에 존재하지 않습니다.");
            break;
            case 2: success = CLOTHES.products.remove(product);
                if(success) { System.out.println("상품을 성공적으로 삭제하였습니다."); }
                else throw new IllegalArgumentException("상품이 의류 카테고리에 존재하지 않습니다.");
                break;
            case 3: success = FOODS.products.remove(product);
                if(success) { System.out.println("상품을 성공적으로 삭제하였습니다."); }
                else throw new IllegalArgumentException("상품이 음식 카테고리에 존재하지 않습니다.");
                break;
            default: throw new ArrayIndexOutOfBoundsException(index + "은(는) 존재하지 않는 카테고리 번호입니다.");
        }
    }
}
