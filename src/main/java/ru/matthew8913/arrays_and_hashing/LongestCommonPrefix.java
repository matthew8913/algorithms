package ru.matthew8913.arrays_and_hashing;

/**
 * Фиксируем первую строку как префикс и уменьшаем её, пока не совпадает)
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        for(int i = 0; i<strs[0].length();i++){
            char c = strs[0].charAt(i);
            for (String s: strs){
                if(!(s.length()>i && s.charAt(i) == c)){
                    return prefix.toString();
                }
            }
            prefix.append(c);
        }
        return prefix.toString();
    }

}
