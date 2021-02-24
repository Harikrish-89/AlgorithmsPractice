package com.algorithm.greedy;

import java.util.Arrays;

public class SherlockMiniMaxOptimised {
	public static void main(String[] args) {
		int[] arr = { 5, 8, 14 };
		int p = 4;
		int q = 9;
		int n = arr.length;
		Arrays.sort(arr);
		int ans = -1;
		int num = -1;
		if (arr[0] > p) {
			if (ans < (arr[0] - p)) {
				ans = (arr[0] - p);
				num = p;
			}
		}
		if (arr[n - 1] < q) {
			if (ans < (q - arr[n - 1])) {
				ans = (q - arr[n - 1]);
				num = q;
			}

		}
		for (int i = 0; i < n-1; i++) {
			int cur = (arr[i] + arr[i + 1]) / 2;
			if (cur <= q && cur >= p && (cur - arr[i]) > ans) {
				ans = (cur - arr[i]);
				num = cur;
			} else if (cur > q) {
				if (q - arr[i] > ans) {
					ans = (q - arr[i]);
					num = q;
				}

			}
			else if (cur < p) {
				if (arr[i + 1] - p > ans) {
					ans = (arr[i + 1] - p);
					num = p;
				}

			}
		}
		System.out.println(num);

	}

}
