package ru.matthew8913.two_pointers;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray r = new RemoveDuplicatesFromSortedArray();
        int[] arr = new int[]{2, 10, 10, 30, 30, 30};
        System.out.println(r.removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }

    public int removeDuplicates(int[] nums) {
        int offset = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                offset++;
            } else {
                nums[i - offset] = nums[i];
            }
        }
        return nums.length - offset;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
