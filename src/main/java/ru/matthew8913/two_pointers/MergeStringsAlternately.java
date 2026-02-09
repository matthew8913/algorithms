package ru.matthew8913.two_pointers;

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length(), j = 0;
        int n = word2.length(), i = 0;

        StringBuilder merged = new StringBuilder();
        while (j < m && i < n) {
            merged.append(word1.charAt(j++));
            merged.append(word2.charAt(i++));
        }

        merged.append(word1.substring(j));
        merged.append(word2.substring(i));

        return merged.toString();
    }

    public String mergeAlternately1(String word1, String word2) {
        String longString = word1.length() > word2.length() ? word1 : word2;
        String shortString = word1.length() > word2.length() ? word2 : word1;

        StringBuilder merged = new StringBuilder();
        for (int i = 0; i < shortString.length(); i++) {
            merged.append(word1.charAt(i));
            merged.append(word2.charAt(i));
        }

        for (int i = shortString.length(); i < longString.length(); i++) {
            merged.append(longString.charAt(i));
        }

        return merged.toString();
    }
}
