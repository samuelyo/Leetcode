package com.leetcode.RandomFlipMatrix;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomFlipMatrix {
    Map<Integer, Integer> map;
    int row, col, total;
    Random random;

    public RandomFlipMatrix(int n_rows, int n_cols) {
        map = new HashMap<Integer, Integer>();
        random = new Random();
        row = n_rows;
        col = n_cols;
        total = row * col;
    }

    public int[] flip() {
        int r = random.nextInt(total);
        total--;
        int x = map.getOrDefault(r, r);
        map.put(r, map.getOrDefault(total, total));
        return new int[]{x / col, x % col};
    }

    public void reset() {
        map.clear();
        total = row * col;
    }
}
