package ru.matthew8913.linked_list;

class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        int slow2 = 0;
        while(slow != slow2){
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow;
    }

    public static void main(String[] args) {
        FindTheDuplicateNumber findTheDuplicateNumber = new FindTheDuplicateNumber();

        // Test case 1: [1,3,4,2,2] -> duplicate is 2
        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println("Test 1: " + findTheDuplicateNumber.findDuplicate(nums1));

        // Test case 2: [3,1,3,4,2] -> duplicate is 3
        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println("Test 2: " + findTheDuplicateNumber.findDuplicate(nums2));

        // Test case 3: [2,2,2,2,2] -> duplicate is 2
        int[] nums3 = {2, 2, 2, 2, 2};
        System.out.println("Test 3: " + findTheDuplicateNumber.findDuplicate(nums3));

        // Test case 4: [1,2,3,4,5,6,7,8,9,5] -> duplicate is 5
        int[] nums4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 5};
        System.out.println("Test 4: " + findTheDuplicateNumber.findDuplicate(nums4));

        // Test case 5: [1,2,2] -> duplicate is 2
        int[] nums5 = {1, 2, 2};
        System.out.println("Test 5: " + findTheDuplicateNumber.findDuplicate(nums5));
    }
}
