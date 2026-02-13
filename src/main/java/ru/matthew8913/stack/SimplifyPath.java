package ru.matthew8913.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
    public static void main(String[] args) {
        SimplifyPath sp = new SimplifyPath();
        System.out.println(sp.simplifyPath("/..//_home/a/b/..///"));
    }

    public String simplifyPath(String path) {
        Deque<String> st = new ArrayDeque<>();

        int start = 0;
        int end;
        while (start < path.length()) {
            while (start < path.length() && path.charAt(start) == '/') start++;
            end = path.indexOf('/', start);
            if (end == -1) end = path.length();

            String dir = path.substring(start, end);
            if (dir.equals("..")) {
                if (!st.isEmpty()) st.pop();
            } else if (!dir.equals(".") && !dir.isEmpty()) {
                st.push(dir);
            }
            start = end;
        }

        if (st.isEmpty()) return "/";
        else {
            StringBuilder sb = new StringBuilder();
            while (!st.isEmpty()) {
                sb.append('/');
                sb.append(st.pollLast());
            }
            return sb.toString();
        }
    }
}
