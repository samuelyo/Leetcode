package com.leetcode.ReorderLogFiles;

import java.util.*;

public class ReorderLogFiles {
    public static void main(String[] args) {
        String[] logs = {"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};
        String[] res = reorderLogFiles(logs);
        System.out.println(Arrays.toString(res));
    }

    public static String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length == 0) {
            return new String[0];
        }
        PriorityQueue<String> before = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] temp1 = o1.split(" ");
                String[] temp2 = o2.split(" ");
                int index = 1;
                while (index < temp1.length && index < temp2.length && temp1[index].equals(temp2[index])) {
                    index++;
                }
                return temp1[index].compareTo(temp2[index]);
            }
        });
        List<String> after = new ArrayList<>();
        for (String log : logs) {
            String[] temp = log.split(" ");
            if (temp.length > 1 && Character.isLetter(temp[1].charAt(0))) {
                before.offer(log);
            } else {
                after.add(log);
            }
        }
        String[] res = new String[before.size() + after.size()];
        int index = 0;
        while (!before.isEmpty()) {
            res[index] = before.poll();
            index++;
        }
        for (int i = 0; i < after.size(); i++) {
            res[index] = after.get(i);
            index++;
        }
        return res;
    }
}
