package com.example.commerce;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    //1. 속성
    private List<CartItem> cart = new ArrayList<>();
    public int index = 0;
    //2. 생성자
    //3. 기능
    //장바구니에 Product 정보를 등록하는 메서드
    public Cart addCart(Cart carts, Product product) {
        for (CartItem cartItem : carts.getCart()) {
            if (cartItem.getProduct().getName().equals(product.getName())) { // CartItem의 상품명과 Product의 상품명이 같으면(=상품이 이미 장바구니에 있으면)
                cartItem.setCountOrder(cartItem.getCountOrder() + 1); // CartItem의 주문수량 countOrder를 기존 값에 1을 더한 값으로 setting
            }
            else {
                CartItem c = new CartItem(product, 1);
                carts.getCart().add(c);
            }
        }
        return carts;
    }
    //장바구니의 모든 상품과 총 금액을 출력하는 메서드
    public int printCart() {
        int total = 0;
        System.out.println("[ 장바구니 내역 ]");
        for(CartItem product : cart) {
            System.out.println(product.getProductInfo()); // 장바구니의 Product 한줄씩 출력
            total += product.getCartItemPrice(); // 장바구니의 총 금액 total 연산
            if(product.getCountOrder() > product.getProduct().getQuantity()) { //상품의 주문 수량이 재고 수량보다 많을 경우
                throw new ArrayIndexOutOfBoundsException("주문하시려는 수량이 재고 수량보다 많습니다."); //예외 처리
            }
        }
        System.out.println("[ 총 주문 금액 ]");
        System.out.println(total+"원");
        return total;
    }
    //장바구니 목록을 반환하는 Getter 메서드
    public List<CartItem> getCart() {
        return this.cart;
    }
    public void setCart(Cart carts) {
        this.cart = carts.getCart();
    }
    public CartItem getCartItem(Product product) {
        for (CartItem cartItem : cart) {
            if (cartItem.getProduct().getName().equals(product.getName())) {
                return cartItem;
            }
        }
        return null;
    }

    //장바구니의 내역을 삭제(초기화)하는 메서드
    public void removeAllProduct() {
        this.cart.clear();
    }
    //장바구니에서 특정 상품을 삭제하는 메서드
    public void removeCartItem(CartItem product) {
        this.cart.remove(product);
    }

}
