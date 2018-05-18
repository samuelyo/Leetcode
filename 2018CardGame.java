package com.onlinetest.tencent;

import java.util.Arrays;
import java.util.Scanner;

public class CardGame {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int len = sc.nextInt();
			long[] nums = new long[len];
			for (int i = 0; i < len; i++) {
				nums[i] = sc.nextLong();
			}
			Arrays.sort(nums);
			long res = 0;
			int index = nums.length - 1;
			while (index - 1 >= 0) {
				res += nums[index] - nums[index - 1];
				index -= 2;
			}
			if (nums.length % 2 == 1) {
				res += nums[index];
			}
			System.out.println(res);
		}
		sc.close();

	}

}
