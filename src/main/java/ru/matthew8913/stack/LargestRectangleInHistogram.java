package ru.matthew8913.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Integer> st = new ArrayDeque<>(); // indices
        for (int i = 0; i <= heights.length; i++) {
            int curH = (i==heights.length)? 0:heights[i];

            while(!st.isEmpty()&&heights[st.peek()]>=curH){
                int h = heights[st.pop()];
                int leftInd = st.isEmpty()? -1 : st.peek();
                int width = i-1 -leftInd;
                maxArea = Math.max(maxArea, h*width);
            }

            st.push(i);
        }
        return maxArea;
    }


}
