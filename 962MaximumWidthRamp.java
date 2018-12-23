package com.leetcode.MaximumWidthRamp;

import java.util.Stack;

public class MaximumWidthRamp {
    public static void main(String[] args) {
        int[] A = {9, 8, 1, 0, 1, 9, 4, 0, 4, 1};
        int res = maxWidthRamp(A);
        System.out.println(res);
    }

    public static int maxWidthRamp(int[] A) {
        Stack<Integer> s = new Stack<>();
        int res = 0, n = A.length;
        for (int i = 0; i < n; ++i)
            if (s.empty() || A[s.peek()] > A[i])
                s.add(i);
        for (int i = n - 1; i >= 0; --i)
            while (!s.empty() && A[s.peek()] <= A[i])
                res = Math.max(res, i - s.pop());
        return res;
    }
}
