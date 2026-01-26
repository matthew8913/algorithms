package ru.matthew8913.arrays_and_hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();

        // Тест 1: Базовый случай
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        int[] result1 = solution.topKFrequent(nums1, k1);
        System.out.println("Тест 1: nums = [1,1,1,2,2,3], k = 2");
        System.out.println("Результат: " + java.util.Arrays.toString(result1));

        // Тест 2: Один элемент
        int[] nums2 = {1};
        int k2 = 1;
        int[] result2 = solution.topKFrequent(nums2, k2);
        System.out.println("\nТест 2: nums = [1], k = 1");
        System.out.println("Результат: " + java.util.Arrays.toString(result2));

        // Тест 3: Все элементы разные
        int[] nums3 = {1, 2, 3, 4, 5};
        int k3 = 3;
        int[] result3 = solution.topKFrequent(nums3, k3);
        System.out.println("\nТест 3: nums = [1,2,3,4,5], k = 3");
        System.out.println("Результат: " + java.util.Arrays.toString(result3));

        // Тест 4: Отрицательные числа
        int[] nums4 = {-1, -1, -2, -2, -2, -3};
        int k4 = 2;
        int[] result4 = solution.topKFrequent(nums4, k4);
        System.out.println("\nТест 4: nums = [-1,-1,-2,-2,-2,-3], k = 2");
        System.out.println("Результат: " + java.util.Arrays.toString(result4));

        // Тест 5: Большой k
        int[] nums5 = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
        int k5 = 4;
        int[] result5 = solution.topKFrequent(nums5, k5);
        System.out.println("\nТест 5: nums = [1,2,2,3,3,3,4,4,4,4], k = 4");
        System.out.println("Результат: " + java.util.Arrays.toString(result5));

        // Тест 6: Повторяющиеся числа
        int[] nums6 = {1, 1, 2, 2, 2, 3, 3, 3, 3};
        int k6 = 2;
        int[] result6 = solution.topKFrequent(nums6, k6);
        System.out.println("\nТест 6: nums = [1,1,2,2,2,3,3,3,3], k = 2");
        System.out.println("Результат: " + java.util.Arrays.toString(result6));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            if (!freqMap.containsKey(num)) freqMap.put(num, 0);
            freqMap.put(num, freqMap.get(num) + 1);
        }

        List[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> e : freqMap.entrySet()) {
            int ind = e.getValue();
            if (buckets[ind] == null) buckets[ind] = new ArrayList<Integer>();
            buckets[ind].add(e.getKey());
        }

        int[] res = new int[k];
        int resInd = 0;
        for (int i = buckets.length - 1; i > 0; i--) {
            if (buckets[i] != null) {
                for (int j = 0; j < buckets[i].size() && k > 0; j++) {
                    res[resInd] = (int) buckets[i].get(j);
                    resInd++;
                    k--;
                }
            }
        }

        return res;
    }
}
