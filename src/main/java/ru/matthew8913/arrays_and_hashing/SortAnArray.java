package ru.matthew8913.arrays_and_hashing;

import java.util.Arrays;

class SortAnArray {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 6, 3, 1, 7, 2, 3};
        SortAnArray sortAnArray = new SortAnArray();
        sortAnArray.sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public void sort(int[] nums, int lStart, int rStart) {
        if (lStart >= rStart) return;

        int pivot = nums[lStart];

        int l = lStart, r = rStart;

        while (l <= r) {
            while (nums[l] < pivot) l++;
            while (nums[r] > pivot) r--;

            if (l <= r) {
                swap(nums, l, r);
                l++;
                r--;
            }
        }

        sort(nums, lStart, r);
        sort(nums, l, rStart);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}