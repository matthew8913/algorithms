package ru.matthew8913.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();

        // Список тест-кейсов
        String[] testCases = {
                "()",           // Ожидается: true
                "()[]{}",       // Ожидается: true
                "(]",           // Ожидается: false
                "([)]",         // Ожидается: false
                "{[]}",         // Ожидается: true
                "]",            // Ожидается: false
                "((",           // Ожидается: false
                ""              // Ожидается: true (пустая строка валидна)
        };

        System.out.println("--- Запуск тестов ---");

        for (String s : testCases) {
            boolean result = solution.isValid(s);
            System.out.printf("Input: \"%-8s\" | Result: %b%n", s, result);
        }
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') stack.push(c);
            else if (!stack.isEmpty() && isValidPair(stack.peek(), c)) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValidPair(char c1, char c2) {
        if (c1 == '(') return c2 == ')';
        else if (c1 == '{') return c2 == '}';
        else if (c1 == '[') return c2 == ']';
        return false;
    }

}
