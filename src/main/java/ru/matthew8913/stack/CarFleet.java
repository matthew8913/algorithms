package ru.matthew8913.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CarFleet {
    public static void main(String[] args) {
        CarFleet solution = new CarFleet();

        // Тест кейс 1: Пример из LeetCode
        int target1 = 10;
        int[] position1 = {6, 8};
        int[] speed1 = {3, 2};

        int result1 = solution.carFleet(target1, position1, speed1);
        System.out.println("Test 1 Result: " + result1); // Ожидается: 3

        // Тест кейс 2: 1
        int target2 = 10;
        int[] position2 = {1, 4};
        int[] speed2 = {3, 2};

        int result2 = solution.carFleet(target2, position2, speed2);
        System.out.println("Test 2 Result: " + result2); // Ожидается: 1

        // Тест кейс 3: Автомобили уже в порядке убывания скорости (все объединятся, если логика верна)
        int target3 = 100;
        int[] position3 = {0, 2, 4};
        int[] speed3 = {4, 2, 1};

        int result3 = solution.carFleet(target3, position3, speed3);
        System.out.println("Test 3 Result: " + result3); // Ожидается: 1
    }

    public int carFleet(int target, int[] position, int[] speed) {
        Deque<CarInfo> carsStack = new ArrayDeque<>(getSortedCars(position, speed));
        int count = 0;
        while (!carsStack.isEmpty()) {
            CarInfo lastCar = carsStack.pop();
            if (!carsStack.isEmpty() && isFleet(carsStack.peek(), lastCar, target)) {
                carsStack.pop();
                carsStack.push(lastCar);
            } else {
                count++;
            }

        }

        return count;
    }

    private boolean isFleet(CarInfo first, CarInfo second, int target) {
        double timeToTarget1 = (double) (target - first.position) / first.speed;
        double timeToTarget2 = (double) (target - second.position) / second.speed;
        return timeToTarget1 <= timeToTarget2;
    }

    private List<CarInfo> getSortedCars(int[] position, int[] speed) {
        List<CarInfo> cars = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            cars.add(new CarInfo(position[i], speed[i]));
        }
        cars.sort((car1, car2) -> car2.position - car1.position);

        return cars;
    }

    public record CarInfo(int position, int speed) {
    }
}
