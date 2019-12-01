package com.leetcode.RelativeSortArray;

import java.util.*;

public class RelativeSortArray {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] res = relativeSortArray(arr1, arr2);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        Set<Integer> set = new HashSet<>();
        for (int num : arr2) {
            set.add(num);
        }
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : arr1) {
            if (!set.contains(num)) {
                list.add(num);
            } else {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }
        }
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < arr2.length; i++) {
            int cur = arr2[i];
            int times = map.get(cur);
            for (int j = 0; j < times; j++) {
                resList.add(cur);
            }
        }
        Collections.sort(list);
        resList.addAll(list);
        for (int i = 0; i < arr1.length; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
}
