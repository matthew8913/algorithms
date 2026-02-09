package ru.matthew8913.two_pointers;

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }

    public static void main(String[] args) {
        MergeSortedArrays solution = new MergeSortedArrays();

        int[] nums1 = new int[]{10, 20, 20, 40, 0, 0};
        int[] nums2 = new int[]{1, 2};
        solution.merge(nums1, 4, nums2, 2);
        System.out.print("Test 1: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println();

        nums1 = new int[]{4, 5, 6, 0, 0};
        nums2 = new int[]{1, 2};
        solution.merge(nums1, 3, nums2, 2);
        System.out.print("Test 2: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println();

        nums1 = new int[]{1, 3, 5, 0, 0, 0};
        nums2 = new int[]{2, 4, 6};
        solution.merge(nums1, 3, nums2, 3);
        System.out.print("Test 3: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println();

        nums1 = new int[]{0};
        nums2 = new int[]{1};
        solution.merge(nums1, 0, nums2, 1);
        System.out.print("Test 4: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println();

        nums1 = new int[]{2, 0};
        nums2 = new int[]{1};
        solution.merge(nums1, 1, nums2, 1);
        System.out.print("Test 5: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
