package ru.matthew8913.arrays_and_hashing;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();

        // Тест 1: Базовый случай
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result1 = groupAnagrams.groupAnagrams(strs1);
        System.out.println("Тест 1: [\"eat\", \"tea\", \"tan\", \"ate\", \"nat\", \"bat\"]");
        System.out.println("Результат: " + result1);

        // Тест 2: Пустой массив
        String[] strs2 = {};
        List<List<String>> result2 = groupAnagrams.groupAnagrams(strs2);
        System.out.println("\nТест 2: []");
        System.out.println("Результат: " + result2);

        // Тест 3: Одно слово
        String[] strs3 = {"hello"};
        List<List<String>> result3 = groupAnagrams.groupAnagrams(strs3);
        System.out.println("\nТест 3: [\"hello\"]");
        System.out.println("Результат: " + result3);

        // Тест 4: Слова разной длины
        String[] strs4 = {"a", "b", "ab", "ba", "abc", "cab", "bac"};
        List<List<String>> result4 = groupAnagrams.groupAnagrams(strs4);
        System.out.println("\nТест 4: [\"a\", \"b\", \"ab\", \"ba\", \"abc\", \"cab\", \"bac\"]");
        System.out.println("Результат: " + result4);

        // Тест 5: Слова с повторяющимися буквами
        String[] strs5 = {"aaa", "aa", "a", "aaaa", "aa", "aaa"};
        List<List<String>> result5 = groupAnagrams.groupAnagrams(strs5);
        System.out.println("\nТест 5: [\"aaa\", \"aa\", \"a\", \"aaaa\", \"aa\", \"aaa\"]");
        System.out.println("Результат: " + result5);


        // Тест 7: Длинные слова
        String[] strs7 = {"abcdefgh", "hgfedcba", "acbedfgh", "abcdefghij", "jihgfedcba"};
        List<List<String>> result7 = groupAnagrams.groupAnagrams(strs7);
        System.out.println("\nТест 7: [\"abcdefgh\", \"hgfedcba\", \"acbedfgh\", \"abcdefghij\", \"jihgfedcba\"]");
        System.out.println("Результат: " + result7);

        // Тест 8: Слова с одинаковыми буквами, но разными количествами
        String[] strs8 = {"aab", "aba", "baa", "abb", "bab", "bba"};
        List<List<String>> result8 = groupAnagrams.groupAnagrams(strs8);
        System.out.println("\nТест 8: [\"aab\", \"aba\", \"baa\", \"abb\", \"bab\", \"bba\"]");
        System.out.println("Результат: " + result8);

        // Тест 9: Пограничный случай - пустые строки
        String[] strs9 = {"", "", "a", "ab", "ba"};
        List<List<String>> result9 = groupAnagrams.groupAnagrams(strs9);
        System.out.println("\nТест 9: [\"\", \"\", \"a\", \"ab\", \"ba\"]");
        System.out.println("Результат: " + result9);

        // Тест 10: Большой набор данных
        String[] strs10 = {"listen", "silent", "enlist", "google", "googel", "golego", "goggle", "inlets", "tinsel"};
        List<List<String>> result10 = groupAnagrams.groupAnagrams(strs10);
        System.out.println("\nТест 10: [\"listen\", \"silent\", \"enlist\", \"google\", \"googel\", \"golego\", \"goggle\", \"inlets\", \"tinsel\"]");
        System.out.println("Результат: " + result10);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] charsCount = new int[26];
            for (int i = 0; i < s.length(); i++) {
                charsCount[s.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(charsCount);
            map.computeIfAbsent(key, k -> new ArrayList<>());
            map.get(key).add(s);
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> e : map.entrySet()) {
            res.add(e.getValue());
        }

        return res;
    }
}
