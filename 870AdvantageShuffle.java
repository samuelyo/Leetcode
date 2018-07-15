package com.leetcode.AdvantageShuffle;

import java.util.*;

public class AdvantageShuffle {
    public static void main(String[] args) {
        int[] A = {2, 0, 4, 1, 2};
        int[] B = {1, 3, 0, 0, 2};
        int[] res = advantageCount(A, B);
        System.out.println(Arrays.toString(res));
    }

    public static int[] advantageCount(int[] A, int[] B) {
        List<int[]> list = new ArrayList<int[]>();
        for (int i = 0; i < B.length; i++) {
            int cur = B[i];
            int[] temp = new int[]{i, cur};
            list.add(temp);
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        Arrays.sort(A);
        int indexA = 0;
        int indexB = 0;
        int[] res = new int[A.length];
        Arrays.fill(res, -1);
        boolean[] visited = new boolean[A.length];
        while (indexB < list.size()) {
            int[] cur = list.get(indexB);
            while (indexA < A.length && A[indexA] <= cur[1]) {
                indexA++;
            }
            if (indexA < A.length) {
                res[cur[0]] = A[indexA];
                visited[indexA] = true;
                indexA++;
            }
            indexB++;
        }
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i] == -1) {
                while (index < visited.length && visited[index] == true) {
                    index++;
                }
                if (index < A.length) {
                    res[i] = A[index];
                    visited[index] = true;
                    index++;
                }
            }
        }
        return res;
    }
}
