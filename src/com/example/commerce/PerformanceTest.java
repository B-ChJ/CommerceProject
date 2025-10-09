package com.example.commerce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PerformanceTest {
    public Category testCategory;
    int count = 0;
    int searchCountLinear, searchCountBinary;

    PerformanceTest() {
        this.testCategory = new Category("test", (Product) null);
    }

    public void createProduct(int count) {
        this.testCategory.removeNullProduct();
        for (int i = 1; i <= count; i++) {
            this.testCategory.getCategoryList().add(new Product("Product_" + String.format("%05d", i), "", 0, 0));
        }
        System.out.println(count + "개 상품 데이터 생성 완료");
    }

    public void compareSearchPerformance() {
        createProduct(10000);

        long linearTime = measureLinearSearch();
        long binaryTime = measureBinarySearch();

        System.out.println("완전탐색 결과: ");
        printResult(linearTime, searchCountLinear);
        System.out.println("이진탐색 결과: ");
        printResult(binaryTime, searchCountBinary);
        System.out.println("성능향상: " + (linearTime / binaryTime) + "배");
    }
    public void printResult(long time, int searchCount) {
        System.out.println(" - 실행시간: " + time + "ns (" + time*1000000 + "ms)");
        System.out.println(" - 비교횟수: " + searchCount + "회");
    }

    private long measureBinarySearch() {
        SearchEngine search = new SearchEngine(testCategory);
        Random random = new Random();
        count = 0;
        long startTime = System.nanoTime(); //시작 시간

        //while (count < 1000) {
            String productName = "Product_" + String.format("%05d", random.nextInt(10000)+1);
            search.binarySearchRecursive(productName, 0, testCategory.getCategoryList().size()-1);
            count++;
        //}

        long endTime = System.nanoTime(); //검색 1,000회 종료 시간
        this.searchCountBinary = search.getCount();
        return endTime - startTime;
    }

    private long measureLinearSearch() {
        SearchEngine search = new SearchEngine(testCategory);
        Random random = new Random();
        count = 0;
        long startTime = System.nanoTime(); //시작 시간

        //while (count < 1000) {
            String productName = "Product_" + String.format("%05d", random.nextInt(10000)+1);
            search.bruteforceSearch(productName);
            count++;
        //}

        long endTime = System.nanoTime(); //검색 1,000회 종료 시간
        this.searchCountLinear = search.getCount();
        return endTime - startTime;
    }
}
