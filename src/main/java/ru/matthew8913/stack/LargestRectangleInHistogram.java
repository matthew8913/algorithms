package ru.matthew8913.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Deque<Pair> st = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            int curH = i == heights.length ? 0 : heights[i];
            while (!st.isEmpty() && curH < st.peek().height) {
                Pair popped = st.pop();

                int width = st.isEmpty() ? i : i - st.peek().ind - 1;

                maxArea = Math.max(maxArea, width * popped.height);
            }
            st.push(new Pair(i, heights[i]));
        }
        return maxArea;
    }

    private record Pair(int ind, int height) {
    }

}
