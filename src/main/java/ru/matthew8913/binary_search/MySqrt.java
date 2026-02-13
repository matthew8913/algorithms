package ru.matthew8913.binary_search;

class MySqrt {
    public int mySqrt(int x) {
        int l = 0, r = x;
        int res = 0;

        while (l <= r) {
            int m = l + (r - l) / 2;
            long square = (long) m * m;
            if (square > x) {
                r = m - 1;
            } else if (square < x) {
                l = m + 1;
                res = m;
            } else {
                return m;
            }
        }

        return res;
    }
}
