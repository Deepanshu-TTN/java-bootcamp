package assignment;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Question3 {
}

class SpecialStack {
    int [] stack;
    int top;
    int min;

    SpecialStack(int capacity){
        stack = new int[capacity];
        top = -1;
    }

    public boolean isEmpty(){
        return top < 0;
    }

    public boolean isFull(){
        return top >= stack.length - 2;
    }

    public boolean push(int x) {
        if(isFull())return false;
        top++;
        stack[top] = x;
        return true;
    }

    public int pop(){
        if(isEmpty()) return Integer.MIN_VALUE;
        int ret = stack[top];
        stack[top] = Integer.MIN_VALUE;
        top--;
        return ret;
    }
}