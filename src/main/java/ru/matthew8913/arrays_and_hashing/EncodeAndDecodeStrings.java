package ru.matthew8913.arrays_and_hashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
    public static void main(String[] args) {
        EncodeAndDecodeStrings codec = new EncodeAndDecodeStrings();


        // Тест 3: Несколько строк
        List<String> test3 = List.of("hello", "world", "test");
        String encoded3 = codec.encode(test3);
        List<String> decoded3 = codec.decode(encoded3);
        System.out.println("\nТест 3 (несколько строк):");
        System.out.println("Исходный: " + test3);
        System.out.println("Закодирован: " + encoded3);
        System.out.println("Раскодирован: " + decoded3);
        System.out.println("Совпадает: " + test3.equals(decoded3));


    }

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int index = 0;
        while (index < str.length()) {
            int startOfWord = str.indexOf("#", index);
            int len = Integer.parseInt(str.substring(index, startOfWord));
            String word = str.substring(startOfWord + 1, startOfWord + len + 1);
            res.add(word);
            index = startOfWord + len + 1;
        }
        return res;
    }

}
