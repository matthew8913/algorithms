package ru.matthew8913.stack;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {

    private final Deque<Long> stack;

    private long min;

    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(0L);
            min = val;
        }else{
            stack.push(val - min);
            if(val<min) min = val;
        }
    }

    public void pop() {
        if(stack.isEmpty()) return;
        long pop = stack.pop();
        if(pop<0){
            min = min - pop;
        }
    }

    public int top() {
        long peek = stack.peek();
        if(peek<0) return Math.toIntExact(min);
        else return Math.toIntExact(min + peek);
    }

    public int getMin() {
        return Math.toIntExact(min);
    }
}
