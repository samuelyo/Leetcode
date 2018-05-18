package com.onlinetest.tencent;

import java.util.Scanner;

public class DrawerQ2 {

	public static int count = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			char[][] chs = new char[n][m];
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				for (int j = 0; j < m; j++) {
					chs[i][j] = s.charAt(j);
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (chs[i][j] == 'Y') {
						right(chs, i, j);
						count++;
					} else if (chs[i][j] == 'B') {
						left(chs, i, j);
						count++;
					} else if (chs[i][j] == 'G') {
						right(chs, i, j);
						left(chs, i, j);
						count += 2;
					}
				}
			}
			System.out.println(count);
		}
		sc.close();

	}

	public static void right(char[][] chs, int i, int j) {
		while (i >= 0 && i < chs.length && j >= 0 && j < chs[0].length) {
			if (chs[i][j] == 'Y') {
				chs[i][j] = 'X';
			} else if (chs[i][j] == 'G') {
				chs[i][j] = 'B';
			} else {
				break;
			}
			i++;
			j++;
		}
	}

	public static void left(char[][] chs, int i, int j) {
		while (i >= 0 && i < chs.length && j >= 0 && j < chs[0].length) {
			if (chs[i][j] == 'B') {
				chs[i][j] = 'X';
			} else if (chs[i][j] == 'G') {
				chs[i][j] = 'Y';
			} else {
				break;
			}
			i++;
			j--;
		}
	}

}
