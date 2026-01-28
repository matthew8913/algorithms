package ru.matthew8913.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Objects;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> operands = new ArrayDeque<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                int op2 = operands.pop();
                int op1 = operands.pop();
                operands.push(evaluate(op1, op2, token));
            } else {
                operands.push(Integer.parseInt(token));

            }
        }
        return operands.pop();

    }

    public boolean isOperator(String s){
       return Objects.equals(s, "/") || Objects.equals(s, "*") || Objects.equals(s, "+") || Objects.equals(s, "-");
    }

    public int evaluate(int op1, int op2, String operator){
        return switch (operator) {
            case "+" -> op1 + op2;
            case "-" -> op1 - op2;
            case "*" -> op1 * op2;
            case "/" -> op1 / op2;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();

        // Тест 1: Простая арифметика ((2 + 1) * 3)
        // Ожидаемый результат: 9
        runTest(solution, new String[]{"2", "1", "+", "3", "*"}, 9);

        // Тест 2: Деление и сложение (4 + (13 / 5))
        // Ожидаемый результат: 6 (целочисленное деление 13/5 = 2)
        runTest(solution, new String[]{"4", "13", "5", "/", "+"}, 6);

        // Тест 3: Сложное выражение с отрицательными числами (LeetCode Example)
        // Ожидаемый результат: 22
        runTest(solution, new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}, 22);

        // Тест 4: Один элемент
        // Ожидаемый результат: 18
        runTest(solution, new String[]{"18"}, 18);

        // Тест 5: Порядок вычитания (3 - 4)
        // Ожидаемый результат: -1
        runTest(solution, new String[]{"3", "4", "-"}, -1);

        // Тест 6: Отрицательный результат
        // Ожидаемый результат: -5
        runTest(solution, new String[]{"0", "5", "-"}, -5);
    }

    private static void runTest(EvaluateReversePolishNotation solution, String[] tokens, int expected) {
        try {
            int result = solution.evalRPN(tokens);
            boolean passed = result == expected;
            String status = passed ? "✅ PASS" : "❌ FAIL";
            System.out.printf("%s | Input: %s | Expected: %d | Got: %d%n",
                    status, Arrays.toString(tokens), expected, result);
        } catch (Exception e) {
            System.out.printf("❌ CRASH | Input: %s | Expected: %d | Exception: %s%n",
                    Arrays.toString(tokens), expected, e.getClass().getSimpleName());
        }
    }
}
