package ru.matthew8913.sliding_window;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        int maxLength = 0;
        while (r < s.length()) {
            while (l < r && set.contains(s.charAt(r))) {
                set.remove(s.charAt(l++));
            }
            set.add(s.charAt(r++));
            maxLength = Math.max(set.size(), maxLength);
        }
        return maxLength;
    }
}
