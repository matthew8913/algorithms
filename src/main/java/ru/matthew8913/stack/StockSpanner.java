package ru.matthew8913.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class StockSpanner {

    Deque<Pair> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek().price() <= price) {
            span += stack.pop().spread();
        }
        stack.push(new Pair(price, span));

        return span;
    }

    private record Pair(int price, int spread) {

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */