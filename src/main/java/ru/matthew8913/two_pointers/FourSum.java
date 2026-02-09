package ru.matthew8913.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();

        // Тест 1: Базовый случай
        int[] nums1 = {2, 2, 2, 2};
        int target1 = 8;
        System.out.println("Test 1: " + fourSum.fourSum(nums1, target1));

        // Тест 2: Массив с повторяющимися числами
        int[] nums2 = {2, 2, 2, 2, 2};
        int target2 = 8;
        System.out.println("Test 2: " + fourSum.fourSum(nums2, target2));

        // Тест 3: Пустой массив
        int[] nums3 = {};
        int target3 = 0;
        System.out.println("Test 3: " + fourSum.fourSum(nums3, target3));

        // Тест 4: Массив недостаточной длины
        int[] nums4 = {1, 2, 3};
        int target4 = 6;
        System.out.println("Test 4: " + fourSum.fourSum(nums4, target4));

        // Тест 5: Отрицательный target
        int[] nums5 = {-3, -2, -1, 0, 1, 2, 3};
        int target5 = -4;
        System.out.println("Test 5: " + fourSum.fourSum(nums5, target5));

        // Тест 6: Большие числа
        int[] nums6 = {1000000000, 1000000000, 1000000000, 1000000000};
        int target6 = -294967296;
        System.out.println("Test 6: " + fourSum.fourSum(nums6, target6));

        // Тест 7: Обычный случай
        int[] nums7 = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        int target7 = 9;
        System.out.println("Test 7: " + fourSum.fourSum(nums7, target7));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int threeSumTarget = target - nums[i];
            res.addAll(threeSum(nums, i + 1, nums[i], threeSumTarget));
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums, int start, int firstEl, int threeSumTarget) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = start; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            int target = threeSumTarget - nums[i];
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum > target) r--;
                else if (sum < target) l++;
                else {
                    result.add(List.of(firstEl, nums[i], nums[l], nums[r]));
                    do l++; while (l < r && nums[l] == nums[l - 1]);
                    do r--; while (l < r && nums[r] == nums[r + 1]);
                }
            }

        }
        return result;

    }
}