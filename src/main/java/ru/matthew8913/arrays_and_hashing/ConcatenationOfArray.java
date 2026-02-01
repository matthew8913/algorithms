package ru.matthew8913.arrays_and_hashing;

/**
 * Создаём новый массив и заполняем nums[i%n]
 */
public class ConcatenationOfArray {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] res = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            res[i] = nums[i % n];
        }
        return res;
    }
}
