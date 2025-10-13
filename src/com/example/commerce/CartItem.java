package com.example.commerce;

public class CartItem {
    //1. 속성
    private Product product; // 주문하는 상품 정보
    private int countOrder; // 주문수량

    //2. 생성자
    public CartItem(Product product, int countOrder) {
        this.product = product;
        this.countOrder = countOrder;
    }
    //3. 기능
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getCountOrder() {
        return countOrder;
    }
    public void setCountOrder(int countOrder) {
        this.countOrder = countOrder;
    }
    public String getProductInfo() {
        return product.getName() + " | " + product.getPrice() +"원 | " + product.getDescription() + " | " + countOrder + "개";
    }
    public int getCartItemPrice() {
        return product.getPrice()*countOrder;
    }

    @Override
    public String toString() {
        return product.toString() + " | " + countOrder + "개";
    }
}
