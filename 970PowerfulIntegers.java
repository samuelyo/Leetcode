package com.leetcode.PowerfulIntegers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers {
    public static void main(String[] args) {
        List<Integer> res = powerfulIntegers(2, 3, 10);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }

    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> res = new HashSet<>();
        for (int a = 1; a < bound; a *= x) {
            for (int b = 1; a + b <= bound; b *= y) {
                res.add(a + b);
                if (y == 1) {
                    break;
                }
            }
            if (x == 1) {
                break;
            }
        }
        return new ArrayList<>(res);
    }
}
