package ru.matthew8913.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {

    private Deque<Integer> st;

    private int min;

    public MinStack() {
        st = new ArrayDeque<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        st.push(val - min);
        if (val < min) min = val;
    }

    public void pop() {
        int popped = st.pop();
        if (popped < 0) {
            min -= popped;
        }
    }

    public int top() {
        int last = st.peek();
        if (last < 0) {
            return min;
        } else {
            return min + last;
        }
    }

    public int getMin() {
        return min;
    }
}
