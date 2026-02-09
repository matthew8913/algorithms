package ru.matthew8913.arrays_and_hashing;

class NumMatrix {

    private final int[][] sums;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length + 1;      // количество строк (rows)
        int m = matrix[0].length + 1;   // количество столбцов (columns)
        sums = new int[n][m];       // создаем массив той же размерности
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int left = sums[i][j - 1];
                int up = sums[i - 1][j];
                int cur = matrix[i - 1][j - 1];
                sums[i][j] = cur + left + up - sums[i - 1][j - 1];
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        NumMatrix numMatrix = new NumMatrix(matrix);

        System.out.println("Тест 1 (2,1,4,3): " + numMatrix.sumRegion(2, 1, 4, 3)); // Ожидается 8
        System.out.println("Тест 2 (1,1,2,2): " + numMatrix.sumRegion(1, 1, 2, 2)); // Ожидается 11
        System.out.println("Тест 3 (0,0,4,4): " + numMatrix.sumRegion(0, 0, 4, 4)); // Ожидается 58
        System.out.println("Тест 4 (0,0,0,0): " + numMatrix.sumRegion(0, 0, 0, 0)); // Ожидается 3
        System.out.println("Тест 5 (0,2,2,4): " + numMatrix.sumRegion(0, 2, 2, 4)); // Ожидается 20

        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        NumMatrix numMatrix2 = new NumMatrix(matrix2);
        System.out.println("\nВторая матрица:");
        System.out.println("Тест (0,0,2,2): " + numMatrix2.sumRegion(0, 0, 2, 2)); // Ожидается 45
        System.out.println("Тест (1,1,2,2): " + numMatrix2.sumRegion(1, 1, 2, 2)); // Ожидается 28

        int[][] matrix3 = {{1}};
        NumMatrix numMatrix3 = new NumMatrix(matrix3);
        System.out.println("\nТретья матрица (1x1):");
        System.out.println("Тест (0,0,0,0): " + numMatrix3.sumRegion(0, 0, 0, 0)); // Ожидается 1
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] + sums[row1][col1] - sums[row2 + 1][col1] - sums[row1][col2 + 1];
    }
}
