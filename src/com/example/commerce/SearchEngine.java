package com.example.commerce;

import java.util.*;

public class SearchEngine {
    public List<Product> sortedProducts;
    public List<Product> result = new ArrayList<>();
    private int count;

    SearchEngine(Category category) {
        this.sortedProducts = new ArrayList<>(category.getCategoryList() == null ? Collections.emptyList() : category.getCategoryList());
        this.sortedProducts.sort(Comparator.comparing(Product::getName));
    }
//    SearchEngine(List<Category> categories) {
//        this.sortedProducts = new ArrayList<>();
//        for(Category c : categories) {
//            this.sortedProducts.addAll(c.getCategoryList());
//        }
//        this.sortedProducts.sort(Comparator.comparing(Product::getName));
//    }

//    public List<Product> bruteforceSearch(String productName) { //완전탐색 검색 메서드
//        for (Product product : this.sortedProducts) {
//            if (product.getName().contains(productName)) {
//                result.add(product);
//            }
//        }
//        if (result.isEmpty()) { throw new IllegalArgumentException("상품을 찾을 수 없습니다."); }
//        return result; // 상품 검색 결과 반환
//    }
public Product bruteforceSearch(String productName) { //완전탐색 검색 메서드
        count = 0;
        for (Product product : this.sortedProducts) {
        if (product.getName().equals(productName)) {
            System.out.println(" - 결과: " + productName + " 찾음");
            return product;
        }
        count++;
    }
    return null;
}

public int getCount() {
    return count;
}

    public Product binarySearchRecursive(String productName, int left, int right) {
        count = 0;
        if (left <= right) {
            int middle = (left + right) / 2;
            if(this.sortedProducts.get(middle).getName().equals(productName)) {
                System.out.println(" - 결과: " + productName + " 찾음");
                return sortedProducts.get(middle);
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
