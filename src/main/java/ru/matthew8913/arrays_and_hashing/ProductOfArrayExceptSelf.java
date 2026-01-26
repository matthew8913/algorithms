package ru.matthew8913.arrays_and_hashing;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();

        // Test Case 1: Базовый случай
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = solution.productExceptSelf(nums1);
        System.out.println("Input: [1,2,3,4]");
        System.out.print("Output: [");
        printArray(result1);
        System.out.println("Expected: [24,12,8,6]\n");

        // Test Case 2: Случай с нулём
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = solution.productExceptSelf(nums2);
        System.out.println("Input: [-1,1,0,-3,3]");
        System.out.print("Output: [");
        printArray(result2);
        System.out.println("Expected: [0,0,9,0,0]\n");

        // Test Case 3: Отрицательные числа
        int[] nums3 = {-1, -2, -3, -4};
        int[] result3 = solution.productExceptSelf(nums3);
        System.out.println("Input: [-1,-2,-3,-4]");
        System.out.print("Output: [");
        printArray(result3);
        System.out.println("Expected: [-24,-12,-8,-6]\n");

        // Test Case 4: Массив из двух элементов
        int[] nums4 = {3, 7};
        int[] result4 = solution.productExceptSelf(nums4);
        System.out.println("Input: [3,7]");
        System.out.print("Output: [");
        printArray(result4);
        System.out.println("Expected: [7,3]\n");

        // Test Case 5: Случай с несколькими нулями
        int[] nums5 = {0, 0, 1, 2};
        int[] result5 = solution.productExceptSelf(nums5);
        System.out.println("Input: [0,0,1,2]");
        System.out.print("Output: [");
        printArray(result5);
        System.out.println("Expected: [0,0,0,0]\n");

        // Test Case 6: Единицы в массиве
        int[] nums6 = {1, 1, 1, 1};
        int[] result6 = solution.productExceptSelf(nums6);
        System.out.println("Input: [1,1,1,1]");
        System.out.print("Output: [");
        printArray(result6);
        System.out.println("Expected: [1,1,1,1]\n");

        // Test Case 7: Большие числа
        int[] nums7 = {10, 3, 5, 6, 2};
        int[] result7 = solution.productExceptSelf(nums7);
        System.out.println("Input: [10,3,5,6,2]");
        System.out.print("Output: [");
        printArray(result7);
        System.out.println("Expected: [180,600,360,300,900]\n");
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if (n <= 1) return nums;
        int[] prev = new int[n];
        int[] post = new int[n];
        prev[0] = 1;
        post[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            prev[i] = prev[i - 1] * nums[i - 1];
            post[n - i - 1] = post[n - i] * nums[n - i];
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = post[i] * prev[i];
        }
        return result;
    }
}
