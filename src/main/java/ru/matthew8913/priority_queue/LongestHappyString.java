package ru.matthew8913.priority_queue;

import java.util.PriorityQueue;

public class LongestHappyString {

    public static void main(String[] args) {
        LongestHappyString lhs = new LongestHappyString();

        // Тест 1
        System.out.println("Тест 1: a=1, b=1, c=7 -> " + lhs.longestDiverseString(0, 1, 5));
        System.out.println("Ожидается: ccaccbcc или ccbccacc");
        System.out.println();

        // Тест 2
        System.out.println("Тест 2: a=7, b=1, c=0 -> " + lhs.longestDiverseString(7, 1, 0));
        System.out.println("Ожидается: aabaa");
        System.out.println();

        // Тест 3
        System.out.println("Тест 3: a=0, b=0, c=7 -> " + lhs.longestDiverseString(0, 0, 7));
        System.out.println("Ожидается: cc");
        System.out.println();

        // Тест 4
        System.out.println("Тест 4: a=2, b=2, c=1 -> " + lhs.longestDiverseString(2, 2, 1));
        System.out.println("Ожидается: aabbc или ababc и т.д.");
        System.out.println();

        // Тест 5
        System.out.println("Тест 5: a=100, b=100, c=100 -> " + lhs.longestDiverseString(100, 100, 100));
        System.out.println("Ожидается: строка длины 300");
        System.out.println();

        // Тест 6 (граничный)
        System.out.println("Тест 6: a=0, b=0, c=1 -> " + lhs.longestDiverseString(0, 0, 1));
        System.out.println("Ожидается: c");
        System.out.println();

        // Тест 7 (с нулями)
        System.out.println("Тест 7: a=5, b=0, c=0 -> " + lhs.longestDiverseString(5, 0, 0));
        System.out.println("Ожидается: aa");
    }

    /**
     * Метод для вашей реализации
     *
     * @param a максимальное количество букв 'a'
     * @param b максимальное количество букв 'b'
     * @param c максимальное количество букв 'c'
     * @return самая длинная возможная счастливая строка
     */
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        //просто по частоте заносим
        if (a > 0) maxHeap.offer(new int[]{a, 'a'});
        if (b > 0) maxHeap.offer(new int[]{b, 'b'});
        if (c > 0) maxHeap.offer(new int[]{c, 'c'});

        //пока очередь не пуста
        while (!maxHeap.isEmpty()) {
            //берем самую приоритетную букву
            int[] polled = maxHeap.poll();

            //можем добавить?
            if (canAdd((char) polled[1], sb)) {
                //добавляем
                add(polled, maxHeap, sb);
            } else {
                //очередь пуста - значит больше нет вариантов
                if (maxHeap.isEmpty()) return sb.toString();

                //можем достать следующую букву
                int[] polled1 = maxHeap.poll();

                //если можем добавить - добавляем
                if (canAdd((char) polled1[1], sb)) {
                    add(polled1, maxHeap, sb);
                }

                //возвращаем первую
                maxHeap.offer(polled);
            }
        }

        return sb.toString();
    }

    private void add(int[] polled, PriorityQueue<int[]> maxHeap, StringBuilder sb) {
        sb.append((char) polled[1]);
        polled[0]--;
        if (polled[0] > 0) maxHeap.offer(polled);
    }

    private boolean canAdd(char c, StringBuilder sb) {
        int l = sb.length();
        return !(l >= 2 && sb.charAt(l - 1) == c && sb.charAt(l - 2) == c);
    }
}