package com.example.commerce;

import java.util.Stack;

public class CartHistory {
    private Stack<CartAction> undoStack = new Stack<>();
    private Stack<CartAction> redoStack = new Stack<>();

    public void addAction(CartAction action) {
        undoStack.push(action);
        redoStack.clear(); // 새 액션이 추가되면 redo 스택 초기화
    }

    public boolean undo(Cart cart) {
        if(undoStack.isEmpty()) {
            System.out.println("추가한 상품이 없습니다.");
            return false;
        }
        redoStack.push(undoStack.pop());
        return true;
    }

    public boolean redo(Cart cart) {
        if(redoStack.isEmpty()) {
            System.out.println("되돌릴 동작이 없습니다");
            return false;
        }
        undoStack.push(redoStack.pop());
        return true;
    }
}
