package com.leetcode.RelativeSortArray;

public class RelativeSortArray2 {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] res = relativeSortArray(arr1, arr2);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        for (int n : arr1) cnt[n]++;
        int i = 0;
        for (int n : arr2) {
            while (cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        for (int n = 0; n < cnt.length; n++) {
            while (cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        return arr1;
    }
}
