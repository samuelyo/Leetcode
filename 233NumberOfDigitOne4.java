package com.leetcode.NumberOfDigitOne;

public class NumberOfDigitOne4 {

	public static void main(String[] args) {

		int n = 10;
		System.out.println(countDigitOne(n));

	}

	public static int countDigitOne(int n) {

		/**
		 * a = round;b = n % base;
		 * 以算百位上1为例子:   假设百位上是0, 1, 和 >=2 三种情况: 
         *case 1: n=3141092, a= 31410, b=92. 计算百位上1的个数应该为 3141 *100 次.
         *case 2: n=3141192, a= 31411, b=92. 计算百位上1的个数应该为 3141 *100 + (92+1) 次. 
         *case 3: n=3141592, a= 31415, b=92. 计算百位上1的个数应该为 (3141+1) *100 次. 
         *以上三种情况可以用 一个公式概括:
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
