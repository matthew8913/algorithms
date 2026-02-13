package ru.matthew8913.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {
    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString("3[a2[c]]"));
    }

    public String decodeString(String s) {
        Deque<Integer> countSt = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                countSt.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                int count = countSt.pop();
                StringBuilder prefix = stringStack.pop();
                for (int i = 0; i < count; i++) {
                    prefix.append(currentString);
                }
                currentString = prefix;
            } else {
                currentString.append(c);
            }
        }
        return currentString.toString();
    }
}
