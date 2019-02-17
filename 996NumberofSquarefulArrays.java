package com.leetcode.NumberofSquarefulArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberofSquarefulArrays {
    public static void main(String[] args) {

    }

    int cnt;

    public int numSquarefulPerms(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        findPerm(A, new boolean[n], new ArrayList<Integer>());
        return cnt;
    }

    private void findPerm(int[] A, boolean[] used, List<Integer> cur) {
        int n = A.length;
        if (cur.size() == n) {
            cnt++;
            return;
        }
        int lastE = (cur.size() == 0 ? -1 : cur.get(cur.size() - 1));
        for (int i = 0; i < n; i++) {
            if (used[i] || (i > 0 && A[i] == A[i - 1] && !used[i - 1])) {
                continue;
            }
            if (lastE == -1 || isSquarePair(lastE, A[i])) {
                cur.add(A[i]);
                used[i] = true;
                findPerm(A, used, cur);
                used[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isSquarePair(int a, int b) {
        double c = Math.sqrt(a + b);
        return c == Math.floor(c); //why this works... but a + b == c * c not work... precision???
    }
}
