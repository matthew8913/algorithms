package ru.matthew8913.arrays_and_hashing;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int removedAmount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                removedAmount++;
            } else {
                nums[i - removedAmount] = nums[i];
            }
        }
        return nums.length - removedAmount;
    }
}
