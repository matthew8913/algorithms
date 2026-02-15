package ru.matthew8913.binary_search;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int l = 0;
        int r = 0;

        for (int num : nums) {
            l = Math.max(num, l);
            r += num;
        }
        int res = r;
        while (l <= r) {
            int capacity = l + (r - l) / 2;

            int count = countArrays(nums, capacity);

            if (count <= k) {
                res = capacity;
                r = capacity - 1;
            } else {
                l = capacity + 1;
            }
        }
        return res;

    }

    private int countArrays(int[] nums, int capacity) {
        int count = 0;
        int occupancy = 0;
        for (int num : nums) {
            occupancy += num;
            if (occupancy > capacity) {
                occupancy = num;
                count++;
            } else if (occupancy == capacity) {
                occupancy = 0;
                count++;
            }
        }

        if(occupancy > 0) count ++;
        return count;
    }

    public static void main(String[] args) {
        SplitArrayLargestSum sol = new SplitArrayLargestSum();

        int[] nums1 = {2, 4, 10, 1, 5}; //16
        int k1 = 2;
        System.out.println(sol.splitArray(nums1, k1));

        int[] nums2 = {1, 0, 2, 3, 5}; //5
        int k2 = 4;
        System.out.println(sol.splitArray(nums2, k2));
    }

}
