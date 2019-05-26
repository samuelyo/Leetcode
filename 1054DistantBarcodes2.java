package com.leetcode.DistantBarcodes;

import java.util.*;

public class DistantBarcodes2 {
    public static void main(String[] args) {
        int[] barcodes = {1, 1, 1, 1, 2, 2, 3, 3};
        int[] res = rearrangeBarcodes(barcodes);
        System.out.println(Arrays.toString(res));
    }

    public static int[] rearrangeBarcodes(int[] barcodes) {
        if (barcodes == null || barcodes.length == 0) {
            return barcodes;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int barcode : barcodes) {
            map.put(barcode, map.getOrDefault(barcode, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey() - o2.getKey();
                } else {
                    return o2.getValue() - o1.getValue();
                }
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }
        int[] res = new int[barcodes.length];
        int index = 0;
        while (!queue.isEmpty()) {
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
            int count = 2;
            while (!queue.isEmpty() && count > 0) {
                Map.Entry<Integer, Integer> cur = queue.poll();
                res[index] = cur.getKey();
                index++;
                cur.setValue(cur.getValue() - 1);
                list.add(cur);
                count--;
            }
            for (Map.Entry<Integer, Integer> e : list) {
                if (e.getValue() > 0) {
                    queue.offer(e);
                }
            }
        }
        return res;
    }
}
