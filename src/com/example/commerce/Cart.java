package com.example.commerce;

import java.util.List;

public class Cart {
    //1. 속성
    private List<Product> cartProducts;

    //2. 생성자
    //3. 기능
    //장바구니에 Product 정보를 등록하는 메서드
    public void setCart(Product product) {
        this.cartProducts.add(product);
    }

}
