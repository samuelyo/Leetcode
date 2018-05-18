package com.onlinetest.tencent;

import java.util.Arrays;
import java.util.Scanner;

public class DrawerQ {

	public static int count = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			char[][] chs = new char[n][m];
			char[][] temp = new char[n][m];
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				for (int j = 0; j < m; j++) {
					chs[i][j] = s.charAt(j);
				}
				Arrays.fill(temp[i], 'X');
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (chs[i][j] != temp[i][j]) {
						if (chs[i][j] == 'Y' || (chs[i][j] == 'G' && temp[i][j] == 'B')) {
							right(temp, chs, i, j);
							count ++;
						}else if (chs[i][j] == 'B' || (chs[i][j] == 'G' && temp[i][j] == 'Y')) {
							left(temp, chs, i, j);
							count ++;
						}else if(chs[i][j] == 'G') {
							right(temp, chs, i, j);
							left(temp, chs, i, j);
							count += 2;
						}
					}
				}
			}
			System.out.println(count);
		}
		sc.close();

	}

	public static void right(char[][] temp, char[][] chs, int i, int j) {
		while(i >= 0 && i < temp.length && j >= 0 && j < temp[0].length) {
			if (chs[i][j] == 'Y' && temp[i][j] == 'X') {
				temp[i][j] = 'Y';
			} else if (chs[i][j] == 'G') {
				if(temp[i][j] == 'B') {
					temp[i][j] = 'G';
				}else if(temp[i][j] == 'X') {
					temp[i][j] = 'Y';
				}
			} else {
				break;
			}
			i ++;
			j ++;
		}
	}

	public static void left(char[][] temp, char[][] chs, int i, int j) {
		while(i >= 0 && i < temp.length && j >= 0 && j < temp[0].length) {
			if (chs[i][j] == 'B' && temp[i][j] == 'X') {
				temp[i][j] = 'B';
			} else if (chs[i][j] == 'G') {
				if(temp[i][j] == 'Y') {
					temp[i][j] = 'G';
				}else if(temp[i][j] == 'X'){
					temp[i][j] = 'B';
				}
			} else {
				break;
			}
			i ++;
			j --;
		}
	}

}
