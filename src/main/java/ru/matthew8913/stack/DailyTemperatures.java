package ru.matthew8913.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {
    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();

        // Тест 1: Классический пример с LeetCode
        // Ожидание: [1, 1, 4, 2, 1, 1, 0, 0]
        int[] temps1 = {30, 38, 30, 36, 35, 40, 28};
        runTestCase(solution, temps1, new int[]{1, 1, 4, 2, 1, 1, 0, 0});

        // Тест 2: Монотонное возрастание (завтра всегда теплее)
        // Ожидание: [1, 1, 1, 0]
        int[] temps2 = {30, 40, 50, 60};
        runTestCase(solution, temps2, new int[]{1, 1, 1, 0});

        // Тест 3: Монотонное убывание (теплее не становится)
        // Ожидание: [0, 0, 0]
        int[] temps3 = {30, 20, 10};
        runTestCase(solution, temps3, new int[]{0, 0, 0});

        // Тест 4: Повторяющиеся температуры
        // Ожидание: [1, 1, 0]
        int[] temps4 = {30, 60, 90};
        runTestCase(solution, temps4, new int[]{1, 1, 0});
    }

    private static void runTestCase(DailyTemperatures solution, int[] input, int[] expected) {
        // Клонируем input, чтобы не испортить данные для вывода, если метод их меняет
        int[] result = solution.dailyTemperatures(input.clone());
        boolean isPassed = Arrays.equals(result, expected);

        System.out.println(isPassed ? "✅ PASS" : "❌ FAIL");
        System.out.println("Input:    " + Arrays.toString(input));
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Got:      " + Arrays.toString(result));
        System.out.println("--------------------------------------------------");
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> indices = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!indices.isEmpty() && temperatures[i] > temperatures[indices.peek()]) {
                result[indices.peek()] = i - indices.pop();
            }
            indices.push(i);
        }
        return result;
    }
}
