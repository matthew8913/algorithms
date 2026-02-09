package ru.matthew8913.arrays_and_hashing;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for(int i = 0; i< n; i++){
            while(1<=nums[i]&&nums[i]<=n&& nums[i]!=i+1){
                int correctPos = nums[i] - 1;

                if(nums[correctPos] == nums[i]) break;

                swap(nums, correctPos, i);
            }
        }

        for (int i = 0; i < n; i++) {
            if(nums[i] != i + 1) return i+1;
        }

        return n+1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
