package com.leetcode.BinaryPrefixDivisibleBy5;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy52 {
    public static void main(String[] args) {
        int[] A = {0, 1, 1, 1, 1, 1};
        List<Boolean> res = prefixesDivBy5(A);
        for (Boolean b : res) {
            System.out.print(b + " ");
        }
    }

    public static List<Boolean> prefixesDivBy5(int[] A) {
        int k = 0;
        List<Boolean> ans = new ArrayList<>();
        for (int a : A) {
            k = (k << 1 | a) % 5;
            ans.add(k == 0);
        }
        return ans;
    }
}
