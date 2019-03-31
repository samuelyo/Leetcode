package com.leetcode.BinaryPrefixDivisibleBy5;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {
    public static void main(String[] args) {
        int[] A = {0, 1, 1, 1, 1, 1};
        List<Boolean> res = prefixesDivBy5(A);
        for (Boolean b : res) {
            System.out.print(b + " ");
        }
    }

    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        if (A == null || A.length == 0) {
            return res;
        }
        long sum = 0;
        for (int cur : A) {
            sum = sum * 2 + cur;
            sum %= 5;
            if (sum == 0) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}
