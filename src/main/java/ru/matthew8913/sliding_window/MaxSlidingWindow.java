package ru.matthew8913.sliding_window;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];

        int l = 0;
        int r = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        while (r < nums.length) {
            pq.add(nums[r]);
            if (r < k-1) {
                r++;
                continue;
            }
            res[r - k + 1] = pq.peek();
            if (nums[l++] == pq.peek()) pq.poll();
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        MaxSlidingWindow solver = new MaxSlidingWindow();

        int[] nums;
        int k;

        if (args.length >= 2) {
            k = Integer.parseInt(args[0]);
            nums = new int[args.length - 1];
            for (int i = 1; i < args.length; i++) {
                nums[i - 1] = Integer.parseInt(args[i]);
            }
        } else {
            nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
            k = 3;
        }

        int[] res = solver.maxSlidingWindow(nums, k);
        for (int x : res) System.out.print(x + " ");
    }
}
