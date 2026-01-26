package ru.matthew8913.arrays_and_hashing;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();

        // Тест 1: Базовый случай
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSum.twoSum(nums1, target1);
        System.out.println("Тест 1: nums = [2, 7, 11, 15], target = 9");
        System.out.println("Результат: [" + result1[0] + ", " + result1[1] + "]");

        // Тест 2: Числа не в начале массива
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoSum.twoSum(nums2, target2);
        System.out.println("\nТест 2: nums = [3, 2, 4], target = 6");
        System.out.println("Результат: [" + result2[0] + ", " + result2[1] + "]");

        // Тест 3: Одинаковые числа
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = twoSum.twoSum(nums3, target3);
        System.out.println("\nТест 3: nums = [3, 3], target = 6");
        System.out.println("Результат: [" + result3[0] + ", " + result3[1] + "]");

        // Тест 4: Отрицательные числа
        int[] nums4 = {-1, -2, -3, -4, -5};
        int target4 = -8;
        int[] result4 = twoSum.twoSum(nums4, target4);
        System.out.println("\nТест 4: nums = [-1, -2, -3, -4, -5], target = -8");
        System.out.println("Результат: [" + result4[0] + ", " + result4[1] + "]");

        // Тест 5: Большой массив
        int[] nums5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target5 = 17;
        int[] result5 = twoSum.twoSum(nums5, target5);
        System.out.println("\nТест 5: nums = [1..10], target = 17");
        System.out.println("Результат: [" + result5[0] + ", " + result5[1] + "]");

        // Тест 6: Нет решения (должен вернуть [0, 0] или выбросить исключение)
        int[] nums6 = {1, 2, 3};
        int target6 = 10;
        try {
            int[] result6 = twoSum.twoSum(nums6, target6);
            System.out.println("\nТест 6: nums = [1, 2, 3], target = 10");
            System.out.println("Результат: [" + result6[0] + ", " + result6[1] + "]");
        } catch (Exception e) {
            System.out.println("\nТест 6: Решение не найдено");
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[]{0, 0};
    }
}
