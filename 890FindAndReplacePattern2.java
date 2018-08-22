package com.leetcode.FindAndReplacePattern;

import java.util.*;

public class FindAndReplacePattern2 {
    public static void main(String[] args) {
        String[] words = {"ef", "fq", "ao", "at", "lx"};
        String pattern = "ya";
        List<String> list = findAndReplacePattern(words, pattern);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] p = F(pattern);
        List<String> res = new ArrayList<String>();
        for (String w : words)
            if (Arrays.equals(F(w), p)) res.add(w);
        return res;
    }

    public static int[] F(String w) {
        HashMap<Character, Integer> m = new HashMap<>();
        int n = w.length();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            m.putIfAbsent(w.charAt(i), m.size());
            res[i] = m.get(w.charAt(i));
        }
        return res;
    }
}
