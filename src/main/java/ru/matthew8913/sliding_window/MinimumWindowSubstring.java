package ru.matthew8913.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> windowFreq = new HashMap<>();
        for (char c : t.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);

        int l = 0;
        int r = 0;
        int matches = 0;
        int ansL = 0;
        int ansR = 0;
        int minLen = Integer.MAX_VALUE;
        while (r < s.length()) {
            char rChar = s.charAt(r);

            int amountInT = freq.getOrDefault(rChar, 0);

            windowFreq.put(rChar, windowFreq.getOrDefault(rChar, 0) + 1);
            int amountInW = windowFreq.get(rChar);

            if(amountInW == amountInT) matches ++;

            while(matches == freq.size()){
                if(r-l+1<minLen){
                    ansL = l;
                    ansR = r+1;
                    minLen = r - l + 1;
                }
                char lChar = s.charAt(l);
                amountInT = freq.getOrDefault(lChar, 0);
                windowFreq.put(lChar, windowFreq.getOrDefault(lChar, 1) - 1);
                amountInW = windowFreq.get(lChar);
                if(amountInW == 0) windowFreq.remove(lChar);
                if(amountInT - amountInW == 1 ) matches --;
                l++;
            }

            r++;

        }

        return s.substring(ansL, ansR);
    }


    public static void main(String[] args) {
        MinimumWindowSubstring solver = new MinimumWindowSubstring();
        String s;
        String t;
        if (args.length >= 2) {
            s = args[0];
            t = args[1];
        } else {
            s = "cabwefgewcwaefgcf";
            t = "cae";
        }
        String res = solver.minWindow(s, t);
        System.out.println(res);
    }

}
