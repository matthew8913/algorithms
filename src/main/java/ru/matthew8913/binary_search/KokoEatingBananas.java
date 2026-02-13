package ru.matthew8913.binary_search;

import java.util.Arrays;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        //[l,r] - границы скорости поедания бананов
        int l = 1;
        //максимальная скорость = максимальному числу бананов в куче
        int r = Arrays.stream(piles).max().getAsInt();
        while (l <= r) {
            int k = l + (r - l) / 2; //выбираем скорость посередине

            int totalTime = 0;
            for (int p : piles) {
                totalTime += Math.ceil((double) p / k);
            }

            //если общее время с такой скоростью больше
            //ограничения - сдвигаем левую границу, так как нужно увеличить скорость
            if (totalTime > h) {
                l = k + 1;
            }
            //иначе мы можем успеваем съесть бананы и можем посмотреть ещё слева
            else {
                r = k - 1;
            }

        }
        return l;
    }
}
