package com.example.commerce;

import java.util.List;

public class Cart {
    //1. 속성
    private List<Product> cartProducts;

    //2. 생성자
    //3. 기능
    //장바구니에 Product 정보를 등록하는 메서드
    public void setCart(Product product) {
        //재고가 있으면 장바구니에 상품 추가
        int count = 0;
        if(product.getQuantity() > 0) {
            if(!cartProducts.contains(product)) {
                count = product.getCount() + 1;
                this.cartProducts.add(product);
            }
            else count = product.getCount() + 1;
        }
        else throw new ArrayIndexOutOfBoundsException("재고가 부족합니다.");

        this.cartProducts.get(cartProducts.indexOf(product)).setCount(count);
    }
    //장바구니의 모든 상품과 총 금액을 출력하는 메서드
    public int printCart() {
        int total = 0;
        System.out.println("[ 장바구니 내역 ]");
        for(Product product : cartProducts) {
            System.out.println(product.toString());
            total += product.getPrice();
        }
        System.out.println("[ 총 주문 금액 ]");
        System.out.println(total+"원");
        return total;
    }
    public List<Product> getCart() {
        return this.cartProducts;
    }

    //장바구니의 내역을 삭제하는 메서드
    public void removeProduct(Product product) {
        if(this.cartProducts.contains(product)) {
            this.cartProducts.remove(product);
        }
    }

}
