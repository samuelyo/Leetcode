package com.leetcode.ReorderedPowerOf2;

import java.util.ArrayList;
import java.util.List;

public class ReorderedPowerOf22 {
    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(24));
    }

    public static boolean reorderedPowerOf2(int N) {
        for (int i = 0, c = counter(N); i < 32; i++)
            if (counter(1 << i) == c) return true;
        return false;
    }

    public static int counter(int N) {
        int res = 0;
        for (; N > 0; N /= 10) res += (int) Math.pow(10, N % 10);
        return res;
    }
}
