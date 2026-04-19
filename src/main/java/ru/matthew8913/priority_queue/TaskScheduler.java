package ru.matthew8913.priority_queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {

    // psvm с тестовыми данными
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Тест 1
        char[] tasks1 = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n1 = 2;
        System.out.println("Тест 1: " + scheduler.leastInterval(tasks1, n1));
        // Ожидаемый результат: 8 (A -> B -> idle -> A -> B -> idle -> A -> B)

        // Тест 2
        char[] tasks2 = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n2 = 0;
        System.out.println("Тест 2: " + scheduler.leastInterval(tasks2, n2));
        // Ожидаемый результат: 6

        // Тест 3
        char[] tasks3 = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int n3 = 2;
        System.out.println("Тест 3: " + scheduler.leastInterval(tasks3, n3));
        // Ожидаемый результат: 16
    }

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;

        //посчитали частоты
        int[] charCount = new int[26];
        for (char task : tasks) {
            charCount[task - 'A']++;
        }

        //очередь задач, которые можно взять в работу
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int count : charCount) {
            if (count > 0) maxHeap.offer(count);
        }

        //очередь задач, которые простаивают
        //{количество_задач, время_до_которого_ждут}
        Queue<int[]> q = new ArrayDeque<>();

        int time = 0;

        while (!maxHeap.isEmpty() || !q.isEmpty()) {

            if (!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.offer(q.poll()[0]);
            }

            if (!maxHeap.isEmpty()) {
                int count = maxHeap.poll() - 1;

                if (count > 0) q.offer(new int[]{count, time + n + 1});
            }

            time++;

        }

        return time;


    }
}