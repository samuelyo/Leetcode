package com.leetcode.LargestTimeForGivenDigits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestTimeForGivenDigits {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        String res = largestTimeFromDigits(A);
        System.out.println(res);
    }

    public static String largestTimeFromDigits(int[] A) {
        if (A == null || A.length == 0) {
            return "";
        }
        int sec = 1439;
        while (sec >= 0) {
            int hour = sec / 60;
            int min = sec % 60;
            List<Integer> list = new ArrayList<>();
            list.add(hour / 10);
            list.add(hour % 10);
            list.add(min / 10);
            list.add(min % 10);
            Collections.sort(list);
            String temp = "";
            for (int i = 0; i < list.size(); i++) {
                temp += "" + list.get(i);
            }
            Arrays.sort(A);
            String origin = "";
            for (int i = 0; i < A.length; i++) {
                origin += "" + A[i];
            }
            if (origin.equals(temp)) {
                return "" + (hour <= 9 ? "0" + hour : hour) + ":" + (min <= 9 ? "0" + min : min);
            }
            sec--;
        }
        return "";
    }

}
