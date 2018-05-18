package com.onlinetest.tencent;

import java.util.Scanner;

public class ReverseArray {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			long n = sc.nextLong();
			long m = sc.nextLong();
			long times = n / m / 2;
			long value = 0;
			for (int i = 1; i <= 2 * m; i++) {
				if (i <= m) {
					value -= i;
				} else {
					value += i;
				}
			}
			System.out.println(value * times);

		}
		sc.close();

	}

}
