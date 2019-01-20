package com.leetcode.SquaresOfASortedArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        int[] A = {-7, -3, 2, 3, 11};
        int[] res = sortedSquares(A);
        System.out.println(Arrays.toString(res));

    }

    public static int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        for (int num : A) {
            list.add(num * num);
        }
        Collections.sort(list);
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
