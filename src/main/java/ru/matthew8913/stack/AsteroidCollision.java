package ru.matthew8913.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class AsteroidCollision {
    public static void main(String[] args) {
        AsteroidCollision ac = new AsteroidCollision();
        System.out.println(Arrays.toString(ac.asteroidCollision(new int[]{2, 4, -4, -1})));
    }

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        boolean destroyed = false;
        for (int cur : asteroids) {
            destroyed = false;
            while (!stack.isEmpty() && !destroyed && stack.peek() > 0 && cur < 0) {
                int lastMass = Math.abs(stack.peek());
                int curMass = Math.abs(cur);
                if (curMass > lastMass) stack.pop();
                else if (curMass < lastMass) destroyed = true;
                else {
                    stack.pop();
                    destroyed = true;
                }
            }
            if (!destroyed) stack.push(cur);
        }

        int[] res = new int[stack.size()];
        int ind = 0;
        while (!stack.isEmpty()) {
            res[ind++] = stack.pollFirst();
        }

        return res;
    }
}
