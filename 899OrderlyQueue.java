package com.leetcode.OrderlyQueue;

import java.util.Arrays;

public class OrderlyQueue {
    public static void main(String[] args) {
        String S = "baaca";
        int K = 3;
        String res = orderlyQueue(S, K);
        System.out.println(res);
    }

    public static String orderlyQueue(String S, int K) {
        if (K > 1) {
            char S2[] = S.toCharArray();
            Arrays.sort(S2);
            return new String(S2);
        }
        String res = S;
        for (int i = 1; i < S.length(); i++) {
            String tmp = S.substring(i) + S.substring(0, i);
            if (res.compareTo(tmp) > 0) res = tmp;
        }
        return res;
    }
}
