package com.leetcode.NumberOfDigitOne;

public class NumberOfDigitOne {

	public static void main(String[] args) {
		
		int n = 10;
		System.out.println(countDigitOne(n));

	}
	
	public static int countDigitOne(int n) {
		
		/**
		 * a = n/m;b = n%m;
		 * �����λ��1Ϊ����:   �����λ����0, 1, �� >=2 �������: 
         *case 1: n=3141092, a= 31410, b=92. �����λ��1�ĸ���Ӧ��Ϊ 3141 *100 ��.
         *case 2: n=3141192, a= 31411, b=92. �����λ��1�ĸ���Ӧ��Ϊ 3141 *100 + (92+1) ��. 
         *case 3: n=3141592, a= 31415, b=92. �����λ��1�ĸ���Ӧ��Ϊ (3141+1) *100 ��. 
         *����������������� һ����ʽ����:
         *(a + 8) / 10 * m + (a % 10 == 1) * (b + 1);
		 */
		int ones = 0;
	    for (long m = 1; m <= n; m *= 10) {
	        long a = n/m, b = n%m;
	        ones += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
	    }
	    return ones;
		
	}

}
