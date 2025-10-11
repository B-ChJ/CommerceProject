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
        CartAction action = undoStack.pop();
        redoStack.push(action);

        applyUndoAction(cart, action);
        return true;
    }

    public void applyUndoAction(Cart cart, CartAction action) {
        CartItem item = cart.getCartItem(action.getProduct());
        switch(action.getActionType()) {
            case ADD:
                cart.removeCartItem(item);
                break;
            case REMOVE:
                cart.addCart(action.getProduct());
                break;
        }
    }

    public void applyRedoAction(Cart cart, CartAction action) {
        CartItem item = cart.getCartItem(action.getProduct());
        switch(action.getActionType()) {
            case ADD:
                cart.addCart(action.getProduct());
                break;
            case REMOVE:
                cart.removeCartItem(item);
                break;

        }
    }

    public boolean redo(Cart cart) {
        CartAction action = redoStack.pop();
        if(redoStack.isEmpty()) {
            System.out.println("되돌릴 동작이 없습니다");
            return false;
        }
        undoStack.push(action);

        applyRedoAction(cart, action);
        return true;
    }
}
