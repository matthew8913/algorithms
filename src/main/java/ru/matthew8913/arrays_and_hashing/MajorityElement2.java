package ru.matthew8913.arrays_and_hashing;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        int can1 = 0;
        int can2 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int num : nums) {
            if (count1 == 0) can1 = num;
            else if (count2 == 0) can2 = num;

            if (can1 == num) count1++;
            else if (can2 == num) count2++;
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == can1) count1++;
            else if (num == can2) count2++;
        }

        List<Integer> res = new ArrayList<>();
        if (count1 > nums.length / 3) res.add(can1);
        if (count2 > nums.length / 3) res.add(can2);


        return res;
    }

}
