package ru.matthew8913.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum solver = new ThreeSum();

        int[][] testCases = {
                {-2, 0, 0, 2, 2},           // С дубликатами
        };

        for (int[] nums : testCases) {
            System.out.println("Input: " + Arrays.toString(nums));
            // Копируем массив, чтобы сортировка внутри метода не ломала вывод "Input" (если нужно)
            // Но здесь для простоты передаем напрямую
            try {
                List<List<Integer>> result = solver.threeSum(nums.clone());
                System.out.println("Output: " + result);
            } catch (Exception e) {
                System.out.println("Exception: " + e);
                e.printStackTrace();
            }
            System.out.println("-----------------");
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return res;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1;
            int r = nums.length - 1;
            int target = -nums[i];

            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum > target) r--;
                else if (sum < target) l++;
                else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                }
            }

        }
        return res;


    }
}
