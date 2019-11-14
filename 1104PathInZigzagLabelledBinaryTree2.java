package com.leetcode.PathInZigzagLabelledBinaryTree;

import java.util.LinkedList;
import java.util.List;

public class PathInZigzagLabelledBinaryTree2 {
    public static void main(String[] args) {
        int label = 1;
        List<Integer> list = pathInZigZagTree(label);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

    public static List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> result = new LinkedList<>();
        int parent = label;
        result.addFirst(parent);

        while (parent != 1) {
            int d = (int) (Math.log(parent) / Math.log(2));
            int offset = (int) Math.pow(2, d + 1) - 1 - parent;
            parent = ((int) Math.pow(2, d) + offset) / 2;
            result.addFirst(parent);
        }

        return result;
    }
}
