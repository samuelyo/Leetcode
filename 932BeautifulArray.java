package com.leetcode.BeautifulArray;

import java.util.ArrayList;
import java.util.Arrays;

public class BeautifulArray {
    public static void main(String[] args) {
        int[] res = beautifulArray(5);
        System.out.println(Arrays.toString(res));

    }

    public static int[] beautifulArray(int N) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        while (res.size() < N) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i : res) if (i * 2 - 1 <= N) tmp.add(i * 2 - 1);
            for (int i : res) if (i * 2 <= N) tmp.add(i * 2);
            res = tmp;
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
