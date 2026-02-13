package ru.matthew8913.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class MyQueue {

    Deque<Integer> inputStack;
    Deque<Integer> outputStack;


    public MyQueue() {
        inputStack = new ArrayDeque<>();
        outputStack = new ArrayDeque<>();
    }

    public void push(int x) {
        inputStack.push(x);
    }

    public int pop() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) outputStack.push(inputStack.pop());
        }
        return outputStack.pop();
    }

    public int peek() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) outputStack.push(inputStack.pop());
        }
        return outputStack.peek();
    }

    public boolean empty() {
        return outputStack.isEmpty();
    }
}

