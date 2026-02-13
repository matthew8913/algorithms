package ru.matthew8913.binary_search;

public class GuessGame {
    int guess(int num) {
        return 1;
    }

    public int guessNumber(int n) {
        return guessNumber(0, n);
    }

    private int guessNumber(int l, int r) {
        if (l == r) return l;
        int myGuess = l + (r - l) / 2;

        int res = guess(myGuess);
        if (res == 0) return myGuess;
        else if (res == -1) r = myGuess;
        else if (res == 1) l = myGuess + 1;

        return guessNumber(l, r);
    }
}
