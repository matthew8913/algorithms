package ru.matthew8913.sliding_window;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        int l = 0;
        int r = 0;
        Set<Integer> window = new HashSet<>();
        while (r < nums.length) {
            if (r - l > k) window.remove(nums[l++]);
            if (window.contains(nums[r])) return true;
            else window.add(nums[r++]);
        }

        return false;
    }
}
