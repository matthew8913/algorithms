package ru.matthew8913.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;

class FreqStack {
    private Map<Integer, Integer> valueToFreq;
    private Map<Integer, Deque<Integer>> freqToValues;
    private int maxFreq;

    public FreqStack() {
        valueToFreq = new HashMap<>();
        freqToValues = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        int currentFreq = valueToFreq.getOrDefault(val, 0) + 1;
        valueToFreq.put(val, currentFreq);

        maxFreq = max(currentFreq, maxFreq);

        freqToValues.computeIfAbsent(currentFreq, values -> new ArrayDeque<>()).push(val);
    }

    public int pop() {
        Deque<Integer> mostFrequentElements = freqToValues.get(maxFreq);

        int mostFrequentElement = mostFrequentElements.pop();
        valueToFreq.put(mostFrequentElement, valueToFreq.get(mostFrequentElement) - 1);
        if (valueToFreq.get(mostFrequentElement) == 0) {
            valueToFreq.remove(mostFrequentElement);
        }


        if (mostFrequentElements.isEmpty()) {
            freqToValues.remove(maxFreq);
            maxFreq--;
        }


        return mostFrequentElement;
    }
}
