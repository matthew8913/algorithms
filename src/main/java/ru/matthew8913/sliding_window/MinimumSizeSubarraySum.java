package ru.matthew8913.sliding_window;

public class MinimumSizeSubarraySum {
        public int minSubArrayLen(int target, int[] nums) {
            int minLen = Integer.MAX_VALUE;
            int l = 0;
            int r = 0;
            int curSum = 0;
            while (r < nums.length) {
                curSum += nums[r];

                while (l <= r && curSum >= target) {
                    int windowLen = r - l + 1;
                    minLen = Math.min(minLen, windowLen);
                    curSum -= nums[l++];
                }


                r++;
            }

            return minLen;
        }

        public static void main(String[] args) {
            MinimumSizeSubarraySum s = new MinimumSizeSubarraySum();
            int target = 4;
            int[] nums = {1,4,4};
            System.out.println(s.minSubArrayLen(target, nums));
        }
}
