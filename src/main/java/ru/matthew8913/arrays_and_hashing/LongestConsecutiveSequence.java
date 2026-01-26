package ru.matthew8913.arrays_and_hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();

        // Test Case 1: Базовый пример из LeetCode
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Test 1: " + (solution.longestConsecutive(nums1) == 4 ? "PASS" : "FAIL") +
                " (Expected: 4, Got: " + solution.longestConsecutive(nums1) + ")");

        // Test Case 2: Длинная последовательность с разрывами и нулями
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Test 2: " + (solution.longestConsecutive(nums2) == 9 ? "PASS" : "FAIL") +
                " (Expected: 9, Got: " + solution.longestConsecutive(nums2) + ")");

        // Test Case 3: Пустой массив
        int[] nums3 = {};
        System.out.println("Test 3: " + (solution.longestConsecutive(nums3) == 0 ? "PASS" : "FAIL") +
                " (Expected: 0, Got: " + solution.longestConsecutive(nums3) + ")");

        // Test Case 4: Массив из одного элемента
        int[] nums4 = {10};
        System.out.println("Test 4: " + (solution.longestConsecutive(nums4) == 1 ? "PASS" : "FAIL") +
                " (Expected: 1, Got: " + solution.longestConsecutive(nums4) + ")");

        // Test Case 5: Дубликаты (они не должны увеличивать длину последовательности)
        int[] nums5 = {1, 2, 0, 1};
        System.out.println("Test 5: " + (solution.longestConsecutive(nums5) == 3 ? "PASS" : "FAIL") +
                " (Expected: 3, Got: " + solution.longestConsecutive(nums5) + ")");

        // Test Case 6: Отрицательные числа
        int[] nums6 = {-5, -4, -3, -2, -1, 0};
        System.out.println("Test 6: " + (solution.longestConsecutive(nums6) == 6 ? "PASS" : "FAIL") +
                " (Expected: 6, Got: " + solution.longestConsecutive(nums6) + ")");

        // Test Case 7: Нет последовательности (длина 1)
        int[] nums7 = {10, 20, 30};
        System.out.println("Test 7: " + (solution.longestConsecutive(nums7) == 1 ? "PASS" : "FAIL") +
                " (Expected: 1, Got: " + solution.longestConsecutive(nums7) + ")");
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> uniqueNums = new HashSet<>();

        for (int num : nums) {
            uniqueNums.add(num);
        }

        int maxK = 1;
        for (int num : uniqueNums) {
            if (!uniqueNums.contains(num - 1)) {
                int k = 1;
                int next = num + 1;
                while (uniqueNums.contains(next)) {
                    k++;
                    if (k > maxK) maxK = k;
                    next++;
                }
            }
        }
        return maxK;
    }
}
