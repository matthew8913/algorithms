package ru.matthew8913.priority_queue;

import java.util.PriorityQueue;

public class ReorganizeString {

    public static void main(String[] args) {
        ReorganizeString rs = new ReorganizeString();

        // Тест 1
        String s1 = "aab";
        System.out.println("Вход: " + s1);
        System.out.println("Выход: " + rs.reorganizeString(s1));
        System.out.println("Ожидается: aba");
        System.out.println();

        // Тест 2
        String s2 = "aaab";
        System.out.println("Вход: " + s2);
        System.out.println("Выход: " + rs.reorganizeString(s2));
        System.out.println("Ожидается: (пустая строка)");
        System.out.println();

        // Тест 3
        String s3 = "aabbcc";
        System.out.println("Вход: " + s3);
        System.out.println("Выход: " + rs.reorganizeString(s3));
        System.out.println("Ожидается: abcabc или acbacb и т.д.");
        System.out.println();

        // Тест 4
        String s4 = "vvvlo";
        System.out.println("Вход: " + s4);
        System.out.println("Выход: " + rs.reorganizeString(s4));
        System.out.println("Ожидается: vlvov");
        System.out.println();

        // Тест 5
        String s5 = "a";
        System.out.println("Вход: " + s5);
        System.out.println("Выход: " + rs.reorganizeString(s5));
        System.out.println("Ожидается: a");
        System.out.println();

        // Тест 6 (длинная строка)
        String s6 = "aaabbbbcc";
        System.out.println("Вход: " + s6);
        System.out.println("Выход: " + rs.reorganizeString(s6));
        System.out.println("Ожидается: bababcabc или аналогично");
        System.out.println();
    }

    public String reorganizeString(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) ++count[s.charAt(i) - 'a'];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) maxHeap.offer(new int[]{count[i], i});
        }

        int[] prev = null;
        StringBuilder sb = new StringBuilder();

        while (!maxHeap.isEmpty()) {

            int[] cur = maxHeap.poll();
            sb.append((char) (cur[1] + 'a'));
            cur[0]--;

            if (prev != null) {
                maxHeap.offer(prev);
                prev = null;
            }
            if (cur[0] > 0) prev = cur;
        }
        if (prev != null) return "";


        return sb.toString();
    }
}