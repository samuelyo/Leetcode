package com.leetcode.MirrorReflection;

public class MirrorReflection {

	public static void main(String[] args) {

		int p = 2;
		int q = 1;
		int res = mirrorReflection(p, q);
		System.out.println(res);

	}

	public static int mirrorReflection(int p, int q) {

		boolean up = true;
		boolean east = true;
		int remain = p;
		while (true) {
			remain -= q;
			if (remain == 0) {
				if (up) {
					if (east) {
						return 1;
					} else {
						return 2;
					}
				} else {
					if (east) {
						return 0;
					}
				}
			}
			if (remain < 0) {
				remain += p;
				up = !up;
			}
			east = !east;
		}
	}

}
