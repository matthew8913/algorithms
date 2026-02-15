package ru.matthew8913.sliding_window;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0;
        int[] freq = new int[26];
        int maxFreq = 0;
        int res = 0;

        while (r < s.length()) {
            //добавили элемент и обновили инфу
            int rCharInd = s.charAt(r) - 'A';
            maxFreq = Math.max(maxFreq, ++freq[rCharInd]);

            //сужаем окно, пока невалидно
            while ((r - l + 1) - maxFreq > k) {
                freq[s.charAt(l++) - 'A']--;
            }

            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}
