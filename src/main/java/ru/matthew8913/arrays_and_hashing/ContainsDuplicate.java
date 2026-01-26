package ru.matthew8913.arrays_and_hashing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();
        System.out.println(solution.hasDuplicate(new int[]{1, 2, 3, 4, 5}));
        System.out.println(solution.hasDuplicate(new int[]{1, 2, 3, 4, 4}));
    }

    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() != nums.length;
    }
}
