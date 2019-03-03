package com.leetcode.FindCommonCharacters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacters {
    public static void main(String[] args) {
        String[] A = {"bella", "label", "roller"};
        List<String> res = commonChars(A);
        for (String s : res) {
            System.out.print(s + " ");
        }
    }

    public static List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        if (A == null || A.length == 0) {
            return res;
        }
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String s : A) {
            char[] chs = s.toCharArray();
            int[] temp = new int[26];
            for (char ch : chs) {
                temp[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                count[i] = Math.min(count[i], temp[i]);
            }
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != Integer.MAX_VALUE) {
                int times = count[i];
                for (int j = 0; j < times; j++) {
                    char ch = (char) ('a' + i);
                    res.add("" + ch);
                }
            }
        }
        return res;
    }
}
