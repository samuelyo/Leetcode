package com.leetcode.BinaryGap;

public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(binaryGap(8));
    }

    public static int binaryGap(int N) {
        String s = Integer.toBinaryString(N);
        int res = 0;
        char[] chs = s.toCharArray();
        Integer pre = null;
        for (int i = 0; i < chs.length; i++) {
            char cur = chs[i];
            if (cur == '1') {
                if (pre != null) {
                    res = Math.max(res, i - pre);
                }
                pre = i;
            }
        }
        return res;
    }
}
