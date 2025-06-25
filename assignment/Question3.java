package assignment;

import java.util.Stack;

public class Question3 {

    public static void main(String[] args) {
        SpecialStack stk = new SpecialStack(10);
        stk.push(100);
        stk.push(1000);
        stk.push(18);
        stk.push(18);
        System.out.println(stk + " min value: " + stk.getMin());
        stk.pop();
        stk.pop();
        System.out.println(stk + " min value: " + stk.getMin());
    }
}

class SpecialStack {
    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> minStack = new Stack<>();
    int maxSize;

    SpecialStack(int capacity) {
        this.maxSize=capacity;
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public boolean isFull() {
        return stack.size() == maxSize;
    }

    public int getMin(){
        return minStack.peek();
    }

    public boolean push(int x) {
        if(isFull())return false;
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
        return true;
    }

    public int pop(){
        if(isEmpty()) return Integer.MIN_VALUE;
        int val = stack.pop();
        if (val == minStack.peek()){
            minStack.pop();
        }
        return val;
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}