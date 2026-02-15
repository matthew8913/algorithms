package ru.matthew8913.sliding_window;

import java.util.HashSet;
import java.util.Set;

public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k >= nums.length) return false;

        int l = 0;
        int r = 0;
        Set<Integer> window = new HashSet<>();
        while(r<nums.length){
            if(r-l>k) window.remove(nums[l++]);
            if(window.contains(nums[r])) return true;
            else window.add(nums[r++]);
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyDuplicate c = new ContainsNearbyDuplicate();
        System.out.println(c.containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
        System.out.println(c.containsNearbyDuplicate(new int[]{2,1,2}, 1));
        System.out.println(c.containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
        System.out.println(c.containsNearbyDuplicate(new int[]{1,2,3,4,5,1}, 4));
        System.out.println(c.containsNearbyDuplicate(new int[]{99,99}, 2));
    }
}