package com.leetcode.NumberOfDigitOne;

public class NumberOfDigitOne4 {

	public static void main(String[] args) {

		int n = 10;
		System.out.println(countDigitOne(n));

	}

	public static int countDigitOne(int n) {

		/**
		 * a = round;b = n % base;
		 * �����λ��1Ϊ����:   �����λ����0, 1, �� >=2 �������: 
         *case 1: n=3141092, a= 31410, b=92. �����λ��1�ĸ���Ӧ��Ϊ 3141 *100 ��.
         *case 2: n=3141192, a= 31411, b=92. �����λ��1�ĸ���Ӧ��Ϊ 3141 *100 + (92+1) ��. 
         *case 3: n=3141592, a= 31415, b=92. �����λ��1�ĸ���Ӧ��Ϊ (3141+1) *100 ��. 
         *����������������� һ����ʽ����:
         *(a + 8) / 10 * m + (a % 10 == 1) * (b + 1);
		 */
		if (n < 1) {
			return 0;
		}
		int count = 0;
		long base = 1;
		while (base <= n) {
			long a = n / base;
			long b = n % base;
			count += a / 10 * base;
			if(a % 10 == 0) {
				base *= 10;
				continue;
			}else if(a % 10 == 1) {
				count += (b + 1);
			}else{
				count += base;
			}
			base *= 10;
		}
		return count;

	}

}
