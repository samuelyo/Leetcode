package com.leetcode.CamelcaseMatching;

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {
    public static void main(String[] args) {
        String[] queries = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern = "FoBa";
        List<Boolean> res = camelMatch(queries, pattern);
        for (Boolean b : res) {
            System.out.print(b + " ");
        }
    }

    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        char[] pArr = pattern.toCharArray();
        for (String query : queries) {
            res.add(helper(query.toCharArray(), pArr));
        }

        return res;
    }

    private static boolean helper(char[] query, char[] pattern) {
        int j = 0;
        for (int i = 0; i < query.length; i++) {
            if (j < pattern.length && query[i] == pattern[j]) {
                j++;
            } else if (query[i] >= 'A' && query[i] <= 'Z') {
                return false;
            }
        }

        return j == pattern.length;
    }
}
