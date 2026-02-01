package ru.matthew8913.arrays_and_hashing;

public class MajorityElement {
        public int majorityElement(int[] nums) {
            int candidate = 0, count = 0;

            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                }
                if (candidate == num) count++;
                else count--;
            }
            return candidate;
        }

        public static void main(String[] args) {
            MajorityElement sol = new MajorityElement();

            int[] t1 = {3, 2, 3};
            int[] t2 = {2, 2, 1, 1, 1, 2, 2};
            int[] t3 = {6, 6, 6, 7, 7};
            int[] t4 = {1};

            System.out.println("Test 1: " + sol.majorityElement(t1)); // ожидается 3
            System.out.println("Test 2: " + sol.majorityElement(t2)); // ожидается 2
            System.out.println("Test 3: " + sol.majorityElement(t3)); // ожидается 6
            System.out.println("Test 4: " + sol.majorityElement(t4)); // ожидается 1
        }
    }
