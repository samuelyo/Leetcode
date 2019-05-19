package com.leetcode.LongestStringChain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {
    public static void main(String[] args) {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        int res = longestStrChain(words);
        System.out.println(res);
    }

    public static int longestStrChain(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, 1);
        }
        int res = 1;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                String pre = word.substring(0, i) + word.substring(i + 1);
                if (map.containsKey(pre)) {
                    map.put(word, Math.max(map.get(word), map.get(pre) + 1));
                }
            }
            res = Math.max(res, map.get(word));
        }
        return res;
    }
}
