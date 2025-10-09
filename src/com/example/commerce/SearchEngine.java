package com.example.commerce;

import java.util.Comparator;
import java.util.List;

public class SearchEngine {
    public List<Product> sortedProducts;
    public Category category;

    public SearchEngine(Category category) {
        this.sortedProducts = category.getCategoryList();
        this.sortedProducts.sort(Comparator.comparing(Product::getName));
        this.category = category;
    }

    public Product binarySearchRecursive(String productName, int left, int right) {
        if (left <= right) {
            int middle = (left + right) / 2;
            if(category.getCategoryList().get(middle).getName().equals(productName)) {
                return sortedProducts.get(middle);
            }
            else if(category.getCategoryList().get(middle).getName().compareTo(productName) > 0) { // middle > target : middle 상품의 문자가 productName보다 사전상 뒷 순서에 있으면
                right = middle - 1; // middle의 왼쪽으로 검색 범위 이동
            }
            else { left = middle + 1; } // middle < target : middle 상품의 문자가 productName보다 사전상 앞 순서에 있으면 오른쪽으로 검색 범위 이동
        }
        else {return null;}
        return binarySearchRecursive(productName, left, right);
    }

    public Product binarySearchIterative(String productName) {
        int left = 0;
        int right = this.sortedProducts.size() - 1;
        Product result = null;
        while(left <= right) {
            int middle = (left + right) / 2;
            if(category.getCategoryList().get(middle).getName().compareTo(productName) > 0) {
                right = middle - 1;
            }
            else if (category.getCategoryList().get(middle).getName().compareTo(productName) < 0) {
                left = middle + 1;
            }
            else { result = category.getCategoryList().get(middle); break;}
        }
        return result;
    }
}
