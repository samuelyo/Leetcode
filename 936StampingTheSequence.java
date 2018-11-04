package com.leetcode.StampingTheSequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StampingTheSequence {
    public static void main(String[] args) {

    }

    public int[] movesToStamp(String s, String t) {
        List<Integer> res = new ArrayList<>();
        char[] tmp = new char[t.length()];
        Arrays.fill(tmp, '*');
        String dst = new String(tmp);

        while (!t.equals(dst)) if ((t = unDo(t, s, res)) == null) return new int[0];

        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) ret[i] = res.get(res.size() - i - 1);
        return ret;
    }

    public String unDo(String cur, String s, List<Integer> res) {
        char[] a = cur.toCharArray();
        for (int i = 0; i <= a.length - s.length(); i++) {
            int idx0 = i, idx1 = 0;
            boolean hasChar = false;
            while (idx0 < a.length && idx1 < s.length() && (a[idx0] == '*' || a[idx0] == s.charAt(idx1))) {
                if (!hasChar && a[idx0] != '*') hasChar = true;
                idx0++;
                idx1++;
            }

            if (idx1 == s.length() && hasChar) {
                res.add(i);
                Arrays.fill(a, i, i + s.length(), '*');
                return new String(a);
            }
        }
        return null;
    }
}
