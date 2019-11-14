package com.leetcode.PathInZigzagLabelledBinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PathInZigzagLabelledBinaryTree {
    public static void main(String[] args) {
        int label = 1;
        List<Integer> list = pathInZigZagTree(label);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

    public static List<Integer> pathInZigZagTree(int label) {
        int num = label;
        int level = 0;
        int step = 1;
        while (num > 0) {
            num -= step;
            if (num <= 0) {
                break;
            }
            step = step << 1;
            level++;
        }
        List<Integer> list = new ArrayList<>(level);
        list.add(label);
        helper(list, level, label);
        return list;
    }

    public static void helper(List<Integer> list, int level, int label) {
        if (level == 0) {
            return;
        }
        if (level == 1) {
            list.add(0, 1);
            return;
        }
        int sum = (int) (Math.pow(2, level) - 1);
        int index = (label - 1 - sum) / 2;
        int num = (int) (Math.pow(2, level) - 1 - index);
        list.add(0, num);
        helper(list, level - 1, num);
    }
}
