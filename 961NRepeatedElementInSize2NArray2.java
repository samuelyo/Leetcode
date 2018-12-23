package com.leetcode.NRepeatedElementInSize2NArray;

import java.util.HashMap;
import java.util.Map;

public class NRepeatedElementInSize2NArray2 {
    public static void main(String[] args) {
        int[] A = {5, 1, 5, 2, 5, 3, 5, 4};
        int res = repeatedNTimes(A);
        System.out.println(res);

    }

    public static int repeatedNTimes(int[] A) {
        int[] count = new int[10000];
        for (int a : A)
            if (count[a]++ == 1)
                return a;
        return -1;
    }
}
