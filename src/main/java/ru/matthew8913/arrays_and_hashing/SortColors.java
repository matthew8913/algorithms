package ru.matthew8913.arrays_and_hashing;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] arr1 = new int[]{2, 2, 2, 1, 0, 2, 1, 0, 1};
        sortColors.sortColors(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = new int[]{0, 0, 0};
        sortColors.sortColors(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = new int[]{2, 2, 2};
        sortColors.sortColors(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = new int[]{1, 1, 1};
        sortColors.sortColors(arr4);
        System.out.println(Arrays.toString(arr4));


    }

    public void sortColors(int[] nums) {
        int oneInd = 0, zeroInd = 0, twoInd = 0;
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    nums[twoInd++] = 2;
                    nums[oneInd++] = 1;
                    nums[zeroInd++] = 0;
                    break;
                case 1:
                    nums[twoInd++] = 2;
                    nums[oneInd++] = 1;
                    break;
                case 2:
                    nums[twoInd++] = 2;
                    break;
            }
        }
    }
}
