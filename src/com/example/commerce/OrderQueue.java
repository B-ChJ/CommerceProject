package com.example.commerce;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class OrderQueue {
    private Queue<Order> waitingQueue = new LinkedList<>();
    private Queue<Order> processingQueue = new LinkedList<>();
    private int maxProcessingCount = 3; // 동시 처리 가능한 주문 수
    private int completeOrderCount = 0;
    Random random = new Random();

    public void addOrder(Order order) {
        order.setProcessingTime(random.nextInt(3)+1);
        order.setWaitingTime();
        waitingQueue.offer(order);
    }

    public void processNextOrder() {
        if(processingQueue.size() >= maxProcessingCount) {
            return;
        }
        else if(waitingQueue.isEmpty()) {
            System.out.println("처리할 주문이 없습니다.");
        }
        Order order = waitingQueue.poll();
        processingQueue.offer(order);
        System.out.println("처리 중:");
        System.out.println(order.getCustomerName() + "님 주문 처리 중... (예상 완료: " + order.getProcessingTime() + "분");
    }

    public void completeOrder() {
        if(processingQueue.isEmpty()) {
            System.out.println("완료할 주문이 없습니다.");
            return;
        }
        Order completeOrder = processingQueue.poll();
        System.out.println(completeOrder.getCustomerName() + "님의 주문이 완료되었습니다.");
        this.completeOrderCount++;
        if(!waitingQueue.isEmpty() && (processingQueue.size() < maxProcessingCount)) {
            processNextOrder();
        }
    }
    public void printOrderStatus() {
        System.out.println("=== 주문 대기열 시스템 ===\n");
        System.out.println("[ 현재 주문 현황 ]");
        System.out.println("대기 중인 주문: " + waitingQueue.size() + "건");
        System.out.print("처리 중인 주문: " + processingQueue.size() + "건");
        if(processingQueue.size()==3) { System.out.print(" (최대 동시 처리)"); }
        System.out.println("\n완료된 주문: " + completeOrderCount + "건");

        System.out.println("대기열:");
        int index = 1;
        for(Order order : waitingQueue) {
            System.out.println(index + "순위: " + order.getCustomerName() + "님 주문 (" + order.getCart().toString() + ") - 대기시간: " + order.getWaitingTime());
            index++;
        }
    }
}
