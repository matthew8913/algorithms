package ru.matthew8913.binary_search;

public class BinarySearch {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length, target);
    }

    private int binarySearch(int[] nums, int l, int r, int target) {
        if (l == r) return -1;
        int midInd = l + (r - l) / 2;


        if (target > nums[midInd]) {
            l = midInd + 1;
        } else if (target < nums[midInd]) {
            r = midInd;
        } else {
            return midInd;
        }

        return binarySearch(nums, l, r, target);
    }
}
