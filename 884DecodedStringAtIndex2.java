package com.leetcode.DecodedStringAtIndex;

public class DecodedStringAtIndex2 {
    public static void main(String[] args) {
        String S = "a2345678999999999999999";
        int K = 1;
        String res = decodeAtIndex(S, K);
        System.out.println(res);
    }

    public static String decodeAtIndex(String S, int K) {
        long N = 0L;
        int i;
        char[] chs = S.toCharArray();
        for (i = 0; N < K; i++) {
            N = chs[i] >= '0' && chs[i] <= '9' ? N * (chs[i] - '0') : N + 1;
        }
        i--;
        while (true) {
            if (chs[i] >= '0' && chs[i] <= '9') {
                N /= chs[i] - '0';
                K %= N;
            } else if (K % N == 0) return "" + chs[i];
            else N--;
            i--;
        }
    }
}
