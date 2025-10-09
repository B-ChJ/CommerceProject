package com.example.commerce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**Product 클래스를 리스트로 관리*/
public class Category {
    //1. 속성
    private String categoryName;
    private List<Product> products = new ArrayList<>();

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
    public void removeNullProduct() {
        for (Product p : products) {
            if (p == null) {
                products.remove(p);
                break;
            }
        }
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
    //카테고리 이름을 반환하는 getter 메서드
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    //주문 완료 후 변경된 재고수량을 갖고 있는 Cart를 Category의 Product에 반영하는 메서드
    // + 재고수량의 변경 사실을 출력
    public void setProductQuantity(CartItem item) {
        for(Product p : this.products) {
            int beforeQuantity = p.getQuantity();
            if(p.equals(item.getProduct())) {
                p.setQuantity(p.getQuantity()-item.getCountOrder());
                System.out.println(p.getName() + " 재고가 " + beforeQuantity + "개 → " + p.getQuantity() + "개로 업데이트 되었습니다.");
            }
        }
    }
    //각 카테고리에 새로운 상품을 추가하는 메서드
    public static void addProduct(int index, Product product) {

    }
    //상품의 상세 정보를 수정하는 메서드
    public void replaceProduct(Product product) {
        int index = this.products.indexOf(product);
        this.getCategoryList().set(index, product);
    }
    /**등록되어 있던 상품을 삭제하는 메서드
     * @param product 삭제할 상품 Product element*/
    public void removeProduct(Product product) {
        boolean success; //삭제 성공 여부를 확인하기 위한 flag 용도
        success = this.products.remove(product);
        if(success) { System.out.println("상품을 성공적으로 삭제하였습니다."); }
        else throw new IllegalArgumentException("상품이 전자제품 카테고리에 존재하지 않습니다.");

    }

}
