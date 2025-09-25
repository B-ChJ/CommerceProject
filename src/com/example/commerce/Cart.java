package com.example.commerce;

import java.util.List;

public class Cart {
    //1. 속성
    private List<Product> cartProducts;

    //2. 생성자
    //3. 기능
    //장바구니에 Product 정보를 등록하는 메서드
    public void setCart(Product product) {
        if(product.quantity > 0) {
            this.cartProducts.add(product);
        }
        else throw new ArrayIndexOutOfBoundsException("재고가 부족합니다.");
    }
    public List<Product> getCart() {
        //장바구니의 모든 상품과 총 금액을 출력
        int total = 0;
        for(Product product : cartProducts) {
            System.out.println(product.toString());
            total += product.price;
        }
        System.out.println(total+"원");
        return this.cartProducts;
    }
    public void removeProduct(Product product) {
        if(this.cartProducts.contains(product)) {
            this.cartProducts.remove(product);
        }
    }


}
