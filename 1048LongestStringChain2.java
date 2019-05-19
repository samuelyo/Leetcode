package com.leetcode.LongestStringChain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain2 {
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
        int[] dp = new int[words.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int res = 0;
        for (int i = 1; i < words.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (words[i].length() - words[j].length() > 1) {
                    break;
                }
                if (isPredecessor(words[i], words[j])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static boolean isPredecessor(String s1, String s2) {
        int i = 0, j = 0;
        boolean flag = false;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) != s2.charAt(j)) {
                if (flag) {
                    return false;
                }
                flag = true;
                i++;
            } else {
                i++;
                j++;
            }
        }
        return (flag && i == s1.length() && j == s2.length()) || (!flag && i == s1.length() - 1 && j == s2.length());
    }
}
