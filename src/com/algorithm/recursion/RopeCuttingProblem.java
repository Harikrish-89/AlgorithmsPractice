package com.algorithm.recursion;

public class RopeCuttingProblem {
	public static void main(String[] args) {

		int n = 5, a = 2, b = 5, c = 1;
		System.out.println(findMaxWays(n, a, b, c));
	}

	private static int findMaxWays(int n, int a, int b, int c) {
		if (n == 0) {
			return 0;
		}
		if (n < 0) {
			return -1;
		}
		int maxWays = Math.max(findMaxWays(n - a, a, b, c),
				Math.max(findMaxWays(n - b, a, b, c), findMaxWays(n - c, a, b, c)));
		return maxWays == -1 ? maxWays : maxWays + 1;
	}

}
