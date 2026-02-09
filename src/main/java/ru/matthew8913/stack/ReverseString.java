package ru.matthew8913.stack;

public class ReverseString {
        public void reverseString(char[] s) {
            int l = 0;
            int r = s.length;

            while(l<r){
                swap(s, l, r);
                l++; r--;
            }
        }

        public void swap(char[] s, int i, int j){
            char temp = s[i];
            s[i] = s[j];
            s[j]  = temp;
        }
}
