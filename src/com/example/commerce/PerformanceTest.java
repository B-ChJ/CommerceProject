package com.example.commerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PerformanceTest {
    public List<Category> testCategory;
    boolean success = true;
    int count = 0;
    int searchCountLinear, searchCountBinary;

    PerformanceTest() {
        this.testCategory = new ArrayList<>();
        this.testCategory.add(new Category("test", (Product) null));
    }

    public void createProduct(int count) {
        System.out.println("[대용량 데이터 생성 중...]");
        this.testCategory.get(0).removeNullProduct();
        for (int i = 1; i <= count; i++) {
            this.testCategory.get(0).getCategoryList().add(new Product("Product_" + String.format("%05d", i), "", 0, 0));
        }
        System.out.println(count + "개 상품 데이터 생성 완료\n");
    }

    public void compareSearchPerformance() {
        System.out.println("=== 상품 검색 성능 테스트 ===\n");
        createProduct(10000);
        Random random = new Random();
        String productName = "Product_" + String.format("%05d", random.nextInt(10000)+1);
        System.out.println("[검색 성능 비교 테스트]");
        System.out.println("검색어: " + productName);

        long linearTime = measureLinearSearch(productName);
        boolean linearSuccess = this.success;
        this.success = true;
        long binaryTime = measureBinarySearch(productName);
        boolean binarySuccess = this.success;

        System.out.println("완전탐색 결과: ");
        printResult(linearTime, searchCountLinear, linearSuccess);
        System.out.println("이진탐색 결과: ");
        printResult(binaryTime, searchCountBinary, binarySuccess);
        System.out.println("성능향상: " + (linearTime / binaryTime) + "배");
    }
    public void printResult(long time, int searchCount, boolean searchSuccess) {
        System.out.println(" - 실행시간: " + time + "ns (" + time*0.000001 + "ms)");
        System.out.println(" - 비교횟수: " + searchCount + "회");
        System.out.println(searchSuccess ? " - 결과: 검색 성공" : " - 결과: 검색 실패");
    }

    private long measureBinarySearch(String productName) {
        SearchEngine search = new SearchEngine(testCategory);
        search.setCount(0);

        //count = 0;
        long startTime = System.nanoTime(); //시작 시간

        //while (count < 1000) {
            Product result = search.binarySearchRecursive(productName, 0, testCategory.get(0).getCategoryList().size()-1);
            if(result == null){ this.success = false; }
            //count++;
        //}

        long endTime = System.nanoTime(); //검색 1,000회 종료 시간
        this.searchCountBinary = search.getCount();
        return endTime - startTime;
    }

    private long measureLinearSearch(String productName) {
        SearchEngine search = new SearchEngine(testCategory);
        //count = 0;
        long startTime = System.nanoTime(); //시작 시간

        //while (count < 1000) {
            Product result = search.testBruteForceSearch(productName);
            if(result == null){ this.success = false; }
            //count++;
        //}

        long endTime = System.nanoTime(); //검색 1,000회 종료 시간
        this.searchCountLinear = search.getCount();
        return endTime - startTime;
    }
}
