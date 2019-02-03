package com.leetcode.IntervalListIntersections;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    public static void main(String[] args) {

    }

    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return new Interval[]{};
        }

        int m = A.length, n = B.length;
        int i = 0, j = 0;
        List<Interval> res = new ArrayList<>();
        while (i < m && j < n) {
            Interval a = A[i];
            Interval b = B[j];

            // find the overlap... if there is any...
            int startMax = Math.max(a.start, b.start);
            int endMin = Math.min(a.end, b.end);

            if (endMin >= startMax) {
                res.add(new Interval(startMax, endMin));
            }

            //update the pointer with smaller end value...
            if (a.end == endMin) {
                i++;
            }
            if (b.end == endMin) {
                j++;
            }
        }
        int size = res.size();

        Interval[] list = new Interval[size];
        for (int k = 0; k < size; k++) {
            list[k] = res.get(k);
        }
        return list;
    }
}
