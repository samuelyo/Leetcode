package com.leetcode.CamelcaseMatching;

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching3 {
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
        for (String query : queries) {
            res.add(helper(query, pattern));
        }
        return res;
    }

    private static boolean helper(String query, String pattern) {
        int i = 0, j = 0;
        char[] q = query.toCharArray();
        char[] p = pattern.toCharArray();
        while (i < q.length) {
            if (j< p.length && q[i] == p[j]) {
                j++;
            } else if (q[i] - 'A' >= 0 && q[i] - 'Z' <= 0) {
                return false;
            }
            i++;
        }
        return j == p.length;
    }
}
