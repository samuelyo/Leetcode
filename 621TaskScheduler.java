package com.leetcode.TaskScheduler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskScheduler {

	public static void main(String[] args) {

		char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
		int n = 2;
		System.out.println(leastInterval(tasks, n));

	}

	public static int leastInterval(char[] tasks, int n) {

		int[] c = new int[26];
		for (char t : tasks) {
			c[t - 'A']++;
		}
		Arrays.sort(c);
		int i = 25;
		while (i >= 0 && c[i] == c[25])
			i--;

		return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
	}

}
