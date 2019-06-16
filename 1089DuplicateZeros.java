package com.leetcode.DuplicateZeros;

import java.util.Arrays;

public class DuplicateZeros {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void duplicateZeros(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        int cur = 0;
        int index = 0;
        while (cur < arr.length) {
            if (index >= arr.length) {
                break;
            }
            if (copy[cur] == 0) {
                arr[index] = 0;
                if(index + 1 < arr.length) {
                    arr[index + 1] = 0;
                }
                index += 2;
            } else {
                arr[index] = copy[cur];
                index++;
            }
            cur++;
        }
    }
}
