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

        // Тест кейс 2: Один автомобиль
        int target2 = 10;
        int[] position2 = {3};
        int[] speed2 = {3};

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
        // Сортируем: в начале списка те, кто ближе к финишу (большая позиция)
        Deque<Car> cars = new ArrayDeque<>(getSortedCars(position, speed));

        int fleets = 0;
        while (cars.size() >= 2) {
            Car carAhead = cars.pop();
            Car carBehind = cars.pop();

            if (isFleet(carBehind, carAhead, target)) {
                cars.push(carAhead);
            } else {
                fleets++;
                cars.push(carBehind);
            }
        }

        if (!cars.isEmpty()) {
            fleets++;
        }

        return fleets;
    }

    public List<Car> getSortedCars(int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            cars.add(new Car(position[i], speed[i]));
        }
        cars.sort((car1, car2) -> car2.position - car1.position);
        return cars;
    }

    public boolean isFleet(Car behind, Car ahead, int target) {
        double timeBehind = (double) (target - behind.position) / behind.speed;
        double timeAhead = (double) (target - ahead.position) / ahead.speed;

        return timeBehind <= timeAhead;
    }

    public record Car(int position, int speed) {
    }
}
