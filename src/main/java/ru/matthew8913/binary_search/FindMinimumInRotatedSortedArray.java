package ru.matthew8913.binary_search;

import java.util.HashMap;

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int l = 0; int r = nums.length - 1;
        while(l<=r){
            // когда концы отсороированы - возвращаем
            if(nums[l] <= nums[r]) return nums[l];


            int mid = l + (r - l)/2;

            // если середина больше правого элемента, то минимум 100% слева.
            if(nums[mid] > nums[r]){
                l = mid + 1;//левый к середине

            }
            //если середина меньше левого, то минимум либо слева либо у мида
            else if(nums[mid] < nums[l]){
                r = mid;//правый к середине
            }
        }
        return nums[l];

    }

        public static void main(String[] args) {
            FindMinimumInRotatedSortedArray s = new FindMinimumInRotatedSortedArray();
            int[] nums = {4, 5, 6, 7, 0, 1, 2};
            int[] nums1 = {3,4,5,6,1,2};
            int[] nums2 = {1};
            int res = s.findMin(nums1);
            System.out.println(res);
        }

}
