package ru.matthew8913.two_pointers;

public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome solver = new ValidPalindrome();

        // Набор тестовых данных (Input -> Expected Output)
        String[] testCases = {
                "A man, a plan, a canal: Panama", // true (Классика)
                "race a car",                     // false (Обычный false)
                " ",                              // true (Пустая строка/пробелы считаются палиндромом)
                "aba",                            // true (Простой палиндром)
                "Madam, I'm Adam",                // true (Смешанный регистр и пунктуация)
                "12321",                          // true (Числовой палиндром)
                "0P",                             // false (Граничный случай с цифрой и буквой)
                ".,"                              // true (Строка без букв/цифр схлопывается в пустую)
        };

        System.out.println("--- Запуск тестов ---");
        for (String test : testCases) {
            boolean result = solver.isPalindrome(test);
            System.out.printf("Input: \"%s\" \nResult: %b\n\n", test, result);
        }
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) return true;

        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;

            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;

            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
