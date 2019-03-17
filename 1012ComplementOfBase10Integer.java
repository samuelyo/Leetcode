package com.leetcode.ComplementOfBase10Integer;

public class ComplementOfBase10Integer {
    public static void main(String[] args) {
        int res = bitwiseComplement(5);
        System.out.println(res);
    }

    public static int bitwiseComplement(int N) {
        String s = Integer.toBinaryString(N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        return Integer.valueOf(sb.toString(), 2);
    }
}
