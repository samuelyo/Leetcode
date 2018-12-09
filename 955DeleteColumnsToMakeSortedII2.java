package com.leetcode.DeleteColumnsToMakeSortedII;

public class DeleteColumnsToMakeSortedII2 {
    public static void main(String[] args) {
        String[] A = {"ca", "bb", "ac"};
        int res = minDeletionSize(A);
        System.out.println(res);
    }

    public static int minDeletionSize(String[] A) {
        int count = 0;
        String[] cur = new String[A.length];
        for (int i = 0; i < A[0].length(); i++) {
            String[] temp = cur.clone();
            for (int j = 0; j < A.length; j++) {
                temp[j] += A[j].charAt(i);
            }
            if (isValid(temp)) {
                cur = temp;
            } else {
                count++;
            }
        }
        return count;
    }

    public static boolean isValid(String[] str) {
        boolean res = true;
        for (int i = 1; i < str.length; i++) {
            String cur = str[i];
            String pre = str[i - 1];
            if (cur.compareTo(pre) < 0) {
                res = false;
                break;
            }
        }
        return res;
    }
}
