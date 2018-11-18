package com.leetcode.DeleteColumnsToMakeSorted;

public class DeleteColumnsToMakeSorted {
    public static void main(String[] args) {
        String[] A = {"zyx", "wvu", "tsr"};
        int res = minDeletionSize(A);
        System.out.println(res);
    }

    public static int minDeletionSize(String[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int count = 0;
        int len = A[0].length();
        for (int i = 0; i < len; i++) {
            boolean isValid = true;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < A.length; j++) {
                if (sb.length() > 0) {
                    if (A[j].charAt(i) < sb.charAt(sb.length() - 1)) {
                        isValid = false;
                        break;
                    }
                }
                sb.append(A[j].charAt(i));
            }
            if (!isValid) {
                count++;
            }
        }
        return count;
    }
}
