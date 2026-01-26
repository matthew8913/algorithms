package ru.matthew8913.arrays_and_hashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        ValidSudoku solution = new ValidSudoku();

        // Test Case 1: Валидная доска (стандартный пример LeetCode)
        char[][] board1 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println("Test 1 (Valid): " + (solution.isValidSudoku(board1) ? "PASS" : "FAIL"));

        // Test Case 2: Ошибка в строке (две '3' в первой строке)
        char[][] board2 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '3'}, // <-- Дубликат 3
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println("Test 2 (Invalid Row): " + (!solution.isValidSudoku(board2) ? "PASS" : "FAIL"));

        // Test Case 3: Ошибка в столбце (две '8' в первом столбце)
        char[][] board3 = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, // <-- Дубликат 8 в 1-м столбце
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println("Test 3 (Invalid Col): " + (!solution.isValidSudoku(board3) ? "PASS" : "FAIL"));

        // Test Case 4: Ошибка в квадрате 3x3 (две '5' в верхнем левом углу)
        // Заменил '5' на 'X' для наглядности, но в коде это '5'
        char[][] board4 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '5', '.', '.', '.', '.', '6', '.'}, // <-- Вторая '5' в квадрате 3x3
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println("Test 4 (Invalid Box): " + (!solution.isValidSudoku(board4) ? "PASS" : "FAIL"));

        // Test Case 5: Почти пустая доска (валидная)
        char[][] board5 = new char[9][9];
        for (int i = 0; i < 9; i++) java.util.Arrays.fill(board5[i], '.');
        board5[0][0] = '1';
        board5[8][8] = '9';
        System.out.println("Test 5 (Sparse Valid): " + (solution.isValidSudoku(board5) ? "PASS" : "FAIL"));
    }

    public boolean isValidSudoku(char[][] board) {

        Set<Character> col = new HashSet<>();
        Set<Character> row = new HashSet<>();

        //строки и столбцы
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (row.contains(board[i][j])) return false;
                    row.add(board[i][j]);
                }
                if (board[j][i] != '.') {
                    if (col.contains(board[j][i])) return false;
                    col.add(board[j][i]);
                }
            }
            row.clear();
            col.clear();
        }

        Set<Character> square = new HashSet<>();
        //квадраты
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (board[k][l] != '.') {
                            if (square.contains(board[k][l])) return false;
                            square.add(board[k][l]);
                        }
                    }
                }
                square.clear();
            }
        }

        return true;
    }
}
