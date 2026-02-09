package ru.matthew8913.two_pointers;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        reverse(nums, 0, nums.length);
        reverse(nums, 0, k);
        reverse(nums, k, nums.length);
    }

    public void reverse(int[] nums, int i, int j) {
        int l = i;
        int r = j - 1;
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}