package ru.matthew8913.arrays_and_hashing;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
        public int subarraySum(int[] nums, int k) {
            int[] prefixSums = new int[nums.length+1];
            Map<Integer, Integer> sumToCount = new HashMap<>();
            sumToCount.put(0, 1);
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                prefixSums[i+1] = prefixSums[i] + nums[i];

                if(sumToCount.containsKey(prefixSums[i+1]-k)){
                    count += sumToCount.get(prefixSums[i+1]-k);
                }

                sumToCount.put(prefixSums[i+1], sumToCount.getOrDefault(prefixSums[i+1], 0)+1);
            }

            return count;
           
        }
}
