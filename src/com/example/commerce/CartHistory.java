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
        // 구현하세요
    }

    public boolean redo(Cart cart) {
        // 구현하세요
    }
}
