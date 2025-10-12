package com.example.commerce;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class OrderQueue {
    private Queue<Order> waitingQueue = new LinkedList<>();
    private Queue<Order> processingQueue = new LinkedList<>();
    private int maxProcessingCount = 3; // 동시 처리 가능한 주문 수
    Random random = new Random();

    public void addOrder(Order order) {
        order.setProcessingTime(random.nextInt(3)+1);
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
    }

    public void completeOrder() {
        if(processingQueue.isEmpty()) {
            System.out.println("완료할 주문이 없습니다.");
            return;
        }
        Order completeOrder = processingQueue.poll();
        System.out.println(completeOrder.getCustomerName() + "님 주문 (" + completeOrder.getProduct().toString() + ") - 대기시간: " + completeOrder.getProcessingTime());
        processNextOrder();
    }
}
