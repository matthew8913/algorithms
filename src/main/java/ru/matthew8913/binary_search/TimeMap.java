package ru.matthew8913.binary_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeMap {
    Map<String, List<Integer>> keyTimes;
    Map<String, List<String>> keyValues;

    public TimeMap() {
        keyTimes = new HashMap<>();
        keyValues = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        keyTimes.computeIfAbsent(key, k -> new ArrayList<>()).add(timestamp);
        keyValues.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }

    public String get(String key, int timestamp) {
        List<Integer> times = keyTimes.get(key);
        if(times == null || times.isEmpty()){
            return "";
        }

        int ind = floorIndex(times, timestamp);

        if(ind == -1){
            return "";
        }else return keyValues.get(key).get(ind);

    }

    private int floorIndex(List<Integer> nums, int target) {
        int l = 0;
        int r = nums.size() - 1;
        int res = -1;

        while(l<=r){
            int mid = l + (r-l)/2;
            int midVal = nums.get(mid);

            if(midVal <= nums.get(r)){
                res = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return res;

    }

}