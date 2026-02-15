package ru.matthew8913.binary_search;

import java.util.Arrays;

public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int days) {
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();
        int res = r;
        while(l<=r){
            int mid = l + (r-l)/2;
            int totalDays = countDays(mid, weights);
            if(totalDays > days){
                l = mid+1;
            }else{
                res = mid;
                r = mid -1;
            }
        }
        return res;
    }

    public int countDays(int capacity, int[] weights){
        int count = 0;
        int occupancy = 0;
        for (int weight : weights) {
            occupancy += weight;
            if (occupancy >= capacity) {
                count++;
                occupancy = occupancy == capacity ? 0 : weight;
            }
        }

        if(occupancy !=0) count ++;

        return count;
    }

    public static void main(String[] args) {
        ShipWithinDays s = new ShipWithinDays();

        int[] w1 = {2, 4, 6, 1, 3, 10};
        int d1 = 4;
        System.out.println("Test 1: " + s.shipWithinDays(w1, d1) + " (expected: 10)");

        int[] w2 = {1, 2, 3, 4, 5};
        int d2 = 5;
        System.out.println("Test 2: " + s.shipWithinDays(w2, d2) + " (expected: 5)");

        int[] w3 = {1, 5, 4, 4, 2, 3};
        int d3 = 3;
        System.out.println("Test 3: " + s.shipWithinDays(w3, d3) + " (expected: 8)");

        int[] w4 = {10};
        int d4 = 1;
        System.out.println("Test 4: " + s.shipWithinDays(w4, d4) + " (expected: 10)");

        int[] w5 = {7, 2, 5, 10, 8};
        int d5 = 2;
        System.out.println("Test 5: " + s.shipWithinDays(w5, d5) + " (expected: 18)");

        int[] w6 = {3, 3, 3, 3, 3, 3};
        int d6 = 3;
        System.out.println("Test 6: " + s.shipWithinDays(w6, d6) + " (expected: 6)");

        int[] w7 = {5, 5, 5, 5};
        int d7 = 4;
        System.out.println("Test 7: " + s.shipWithinDays(w7, d7) + " (expected: 5)");

        int[] w8 = {1, 1, 1, 1, 1, 1, 1};
        int d8 = 2;
        System.out.println("Test 8: " + s.shipWithinDays(w8, d8) + " (expected: 4)");

        int[] w9 = {500, 400, 300, 200, 100};
        int d9 = 5;
        System.out.println("Test 9: " + s.shipWithinDays(w9, d9) + " (expected: 500)");

        int[] w10 = {2, 2, 2, 2, 2};
        int d10 = 1;
        System.out.println("Test 10: " + s.shipWithinDays(w10, d10) + " (expected: 10)");
    }


}
