package ru.matthew8913.binary_search;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int l = 0;
        int r = rows * cols - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (matrix[mid / cols][mid % cols] > target) {
                r = mid - 1;
            } else if (matrix[mid / cols][mid % cols] < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
