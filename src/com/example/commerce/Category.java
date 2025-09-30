package com.example.commerce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**Product 클래스를 리스트로 관리*/
public class Category {
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
