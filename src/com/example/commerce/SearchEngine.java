package com.example.commerce;

import java.util.*;

public class SearchEngine {
    public List<Product> sortedProducts;
    public List<Product> result = new ArrayList<>();
    private int count;

    SearchEngine(List<Category> categories) {
        this.sortedProducts = new ArrayList<>();
        for(Category c : categories) {
            this.sortedProducts.addAll(c.getCategoryList());
        }
        this.sortedProducts.sort(Comparator.comparing(Product::getName));
    }

    public List<Product> bruteforceSearch(String productName) { //완전탐색 검색 메서드
        count = 0;
        for (Product product : this.sortedProducts) {
            if (product.getName().contains(productName)) {
                this.result.add(product);
            }
            count++;
        }
        if (result.isEmpty()) { throw new IllegalArgumentException("상품을 찾을 수 없습니다."); }
        return result; // 상품 검색 결과 반환
    }

    public Product binarySearchRecursive(String productName, int left, int right) {
        if (left <= right) {
            int middle = (left + right) / 2;
            if(this.sortedProducts.get(middle).getName().contains(productName)) {
                return this.sortedProducts.get(middle);
            }
            else if(this.sortedProducts.get(middle).getName().compareTo(productName) > 0) { // middle > target : middle 상품의 문자가 productName보다 사전상 뒷 순서에 있으면
                right = middle - 1; // middle의 왼쪽으로 검색 범위 이동
            }
            else { left = middle + 1; } // middle < target : middle 상품의 문자가 productName보다 사전상 앞 순서에 있으면 오른쪽으로 검색 범위 이동
        }
        else {return null;}
        count++;
        return binarySearchRecursive(productName, left, right);
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public Product testBruteForceSearch(String productName) { //완전탐색 검색 메서드
        count = 0;
        for (Product product : this.sortedProducts) {
            if (product.getName().contains(productName)) {
                return product;
            }
            count++;
        }
        if (result.isEmpty()) { throw new IllegalArgumentException("상품을 찾을 수 없습니다."); }
        return null; // 상품 검색 결과 반환
    }

    public Product binarySearchIterative(String productName) {
        int left = 0;
        int right = this.sortedProducts.size() - 1;
        Product result = null;
        while(left <= right) {
            int middle = (left + right) / 2;
            if(this.sortedProducts.get(middle).getName().compareTo(productName) > 0) {
                right = middle - 1;
            }
            else if (this.sortedProducts.get(middle).getName().compareTo(productName) < 0) {
                left = middle + 1;
            }
            else { result = this.sortedProducts.get(middle); break;}
        }
        return result;
    }
}
