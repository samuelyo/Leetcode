package com.leetcode.ReorderedPowerOf2;

import java.util.ArrayList;
import java.util.List;

public class ReorderedPowerOf2 {
    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(24));
    }

    public static boolean reorderedPowerOf2(int N) {
        int[] dp = new int[10];
        int count = 0;
        while (N > 0) {
            count++;
            int cur = N % 10;
            dp[cur]++;
            N /= 10;
        }
        List<Integer> list = generate(count);
        for (Integer num : list) {
            if (isValid(num, dp)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValid(Integer num, int[] dp) {
        int[] temp = new int[10];
        while (num > 0) {
            int cur = num % 10;
            temp[cur]++;
            num /= 10;
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] != temp[i]) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> generate(int count) {
        double max = Math.pow(10, count);
        int num = 1;
        List<Integer> list = new ArrayList<Integer>();
        while (num <= max) {
            list.add(num);
            num *= 2;
        }
        return list;
    }
}
