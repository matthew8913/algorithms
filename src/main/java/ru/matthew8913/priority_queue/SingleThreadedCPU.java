package ru.matthew8913.priority_queue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SingleThreadedCPU {

    public static void main(String[] args) {
        SingleThreadedCPU cpu = new SingleThreadedCPU();

        // Тест 1
        int[][] tasks1 = {{1, 4}, {3, 3}, {2, 1}};
        System.out.println("Тест 1: " + Arrays.toString(cpu.getOrder(tasks1)));
        // Ожидаемый результат: [0, 2, 1]

        // Тест 2
        int[][] tasks2 = {{5, 2}, {4, 4}, {4, 1}, {2, 1}, {3, 3}};
        System.out.println("Тест 2: " + Arrays.toString(cpu.getOrder(tasks2)));
        // Ожидаемый результат: [3, 4, 2, 0, 1]

        // Тест 3 (дополнительный)
        int[][] tasks3 = {{1, 2}, {2, 4}, {3, 2}};
        System.out.println("Тест 3: " + Arrays.toString(cpu.getOrder(tasks3)));

        // Тест 4 (задачи с одинаковым временем поступления)
        int[][] tasks4 = {{1, 3}, {1, 2}, {1, 1}};
        System.out.println("Тест 4: " + Arrays.toString(cpu.getOrder(tasks4)));
        // Ожидаемый результат: [2, 1, 0] (сначала самая короткая)
    }

    /**
     * Метод для вашей реализации
     *
     * @param tasks - массив задач, где tasks[i] = [enqueueTime, processingTime]
     * @return порядок индексов выполнения задач
     */
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;


        //создаем массив отсортированный по времени поступления
        Task[] taskList = new Task[n];
        for (int i = 0; i < n; i++) {
            taskList[i] = new Task(i, tasks[i][0], tasks[i][1]);
        }
        Arrays.sort(taskList, (a, b) -> a.enqTime - b.enqTime);

        //создаем очередь доступных для исполнения задач. Сначала идут самые короткие, потом смотрим на индекс.
        PriorityQueue<Task> availableTasks = new PriorityQueue<>((a, b) -> a.procTime == b.procTime ? a.ind - b.ind : a.procTime - b.procTime);


        int[] res = new int[n];
        int resInd = 0;
        int taskInd = 0;
        int time = 0;

        //пока не заполнили рез. массив
        while (resInd < n) {
            //добавляем пришедшие задачи в очередь доступных
            while (taskInd < n && taskList[taskInd].enqTime <= time) availableTasks.offer(taskList[taskInd++]);

            //если пусто - значит подождем до след задачи
            if (availableTasks.isEmpty()) {
                time = taskList[taskInd].enqTime;
                continue;
            }

            // когда добавили доступные и не попали в пусто - мы можем честно достать задачу и выполнить её
            Task t = availableTasks.poll();
            res[resInd++] = t.ind;
            time += t.procTime;
        }
        return res;

    }

    private record Task(
            int ind,
            int enqTime,
            int procTime
    ) {
    }
}
