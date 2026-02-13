package ru.matthew8913.stack;

import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {
    private Queue<Integer> mainQueue;

    private Queue<Integer> helperQueue;

    public MyStack() {
        mainQueue = new ArrayDeque<>();
        helperQueue = new ArrayDeque<>();
    }

    public void push(int x) {
        helperQueue.offer(x);

        while (!mainQueue.isEmpty()) {
            helperQueue.offer(mainQueue.poll());
        }
        Queue<Integer> temp = mainQueue;
        mainQueue = helperQueue;
        helperQueue = temp;
    }

    public int pop() {
        if (!empty()) return mainQueue.poll();
        return 0;
    }

    public int top() {
        return mainQueue.peek();
    }

    public boolean empty() {
        return mainQueue.isEmpty();
    }
}