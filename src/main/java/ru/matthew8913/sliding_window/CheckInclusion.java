package ru.matthew8913.sliding_window;

class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] freq = new int[26];
        int[] permutation = new int[26];

        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }

        int l = 0;
        int r = 0;

        while (r < s2.length()) {
            char rChar = s2.charAt(r);
            boolean beforeAddEqual = freq[rChar - 'a'] == permutation[rChar - 'a'];
            freq[rChar - 'a'] ++;



        }


        return false;
    }

}
