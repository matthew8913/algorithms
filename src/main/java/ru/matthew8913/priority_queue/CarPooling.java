package ru.matthew8913.priority_queue;

import java.util.PriorityQueue;

public class CarPooling {

    public static void main(String[] args) {
        CarPooling cp = new CarPooling();

        // Тест 1
        int[][] trips1 = {{2, 1, 5}, {3, 3, 7}};
        System.out.println("Тест 1: " + cp.carPooling(trips1, 4));
        System.out.println("Ожидается: false");
        System.out.println();

        // Тест 2
        int[][] trips2 = {{2, 1, 5}, {3, 3, 7}};
        System.out.println("Тест 2: " + cp.carPooling(trips2, 5));
        System.out.println("Ожидается: true");
        System.out.println();

        // Тест 3
        int[][] trips3 = {{2, 1, 5}, {3, 5, 7}};
        System.out.println("Тест 3: " + cp.carPooling(trips3, 3));
        System.out.println("Ожидается: true");
        System.out.println();

        // Тест 4
        int[][] trips4 = {{3, 2, 7}, {3, 7, 9}, {8, 3, 9}};
        System.out.println("Тест 4: " + cp.carPooling(trips4, 11));
        System.out.println("Ожидается: true");
        System.out.println();

        // Тест 5
        int[][] trips5 = {{3, 2, 7}, {3, 7, 9}, {8, 3, 9}};
        System.out.println("Тест 5: " + cp.carPooling(trips5, 10));
        System.out.println("Ожидается: false");
        System.out.println();

        // Тест 6 (пустая поездка)
        int[][] trips6 = {{1, 0, 1}};
        System.out.println("Тест 6: " + cp.carPooling(trips6, 1));
        System.out.println("Ожидается: true");
        System.out.println();

        // Тест 7 (много маленьких поездок)
        int[][] trips7 = {{2, 0, 3}, {1, 1, 2}, {3, 2, 4}};
        System.out.println("Тест 7: " + cp.carPooling(trips7, 4));
        System.out.println("Ожидается: false");
    }

    /**
     * Метод для вашей реализации
     *
     * @param trips    массив поездок [numPassengers, from, to]
     * @param capacity вместимость автомобиля
     * @return true если можно подобрать всех пассажиров, иначе false
     */
    public boolean carPooling(int[][] trips, int capacity) {
        if (trips.length == 0) return true;
        PriorityQueue<int[]> remainingTrips = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> currentTrips = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int[] trip : trips) {
            remainingTrips.offer(trip);
        }
        int passengers = 0;
        while (!remainingTrips.isEmpty()) {
            int position = remainingTrips.peek()[1];

            //высадили всех, кто выходит сейчас
            while (!currentTrips.isEmpty() && currentTrips.peek()[2] == position) {
                int[] polled = currentTrips.poll();
                passengers -= polled[0];
            }

            while (!remainingTrips.isEmpty() && remainingTrips.peek()[1] == position) {
                int[] polled = remainingTrips.poll();
                if (passengers + polled[0] > capacity) return false;
                currentTrips.offer(polled);
                passengers += polled[0];
            }
        }

        return true;
    }
}