package ru.matthew8913.sliding_window;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int distanceSum = 0;



        for(int i = arr.length-1; i >= arr.length-k; i--){
            distanceSum += distance(arr[i], x);
        }
        int minDistanceSum = distanceSum;
        int l = arr.length-k;
        int r = arr.length-1;
        int lInd= l;
        int rInd = r;
        while(l>0){
            distanceSum += distance(arr[--l], x);
            distanceSum -= distance(arr[r--], x);
            if(distanceSum <= minDistanceSum){
                minDistanceSum = distanceSum;
                lInd = l;
                rInd = r;
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i = lInd; i<= lInd + (rInd-lInd); i++){
            res.add(arr[i]);
        }
        return res;
    }

    public int distance(int a, int b){
        return Math.abs(a-b);
    }

    public static void main(String[] args) {
        FindKClosestElements s = new FindKClosestElements();

        int[] arr1 = {2, 4, 5, 8};
        int k1 = 2;
        int x1 = 6;
        System.out.println(s.findClosestElements(arr1, k1, x1));

        int[] arr2 = {2, 3, 4};
        int k2 = 3;
        int x2 = 1;
        System.out.println(s.findClosestElements(arr2, k2, x2));
    }
}