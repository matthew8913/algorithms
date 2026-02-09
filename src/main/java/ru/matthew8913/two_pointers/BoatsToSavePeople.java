package ru.matthew8913.two_pointers;

import java.util.Arrays;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0;
        int r = people.length - 1;
        int count = 0;
        while (l <= r) {
            int remain = limit - people[r--];
            count++;
            if (l < r && people[l] <= remain) l++;
        }
        return count;
    }
}