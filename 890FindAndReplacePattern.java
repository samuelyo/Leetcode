package com.leetcode.FindAndReplacePattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {
    public static void main(String[] args) {
        String[] words = {"ef", "fq", "ao", "at", "lx"};
        String pattern = "ya";
        List<String> list = findAndReplacePattern(words, pattern);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        if (words == null || words.length == 0 || pattern == null || pattern.length() == 0) {
            return list;
        }
        for (String word : words) {
            if (isValid(word, pattern)) {
                list.add(word);
            }
        }
        return list;
    }

    private static boolean isValid(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }
        char[] chs1 = word.toCharArray();
        char[] chs2 = pattern.toCharArray();
        boolean flag1 = true;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < chs1.length; i++) {
            char ch = chs1[i];
            if (map.containsKey(ch)) {
                if (map.get(ch) != chs2[i]) {
                    flag1 = false;
                    break;
                }
            } else {
                map.put(ch, chs2[i]);
            }
        }
        boolean flag2 = true;
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < chs2.length; i++) {
            char ch = chs2[i];
            if (map2.containsKey(ch)) {
                if (map2.get(ch) != chs1[i]) {
                    flag2 = false;
                    break;
                }
            } else {
                map2.put(ch, chs1[i]);
            }
        }
        return flag1 & flag2;
    }
}
