package ru.matthew8913.arrays_and_hashing;

public class ValidAnagram {

    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();

        System.out.println(solution.isAnagram("anagram", "nagaram"));
        System.out.println(solution.isAnagram("anagram", "nagaham"));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int len = s.length();

        int[] charCount = new int[26];
        for (int i = 0; i < len; i++) {
            charCount[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < len; i++) {
            charCount[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (charCount[i] != 0) return false;
        }
        return true;
    }
}
