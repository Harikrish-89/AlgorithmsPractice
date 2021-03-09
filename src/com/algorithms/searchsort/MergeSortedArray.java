package com.algorithms.searchsort;

import java.util.Arrays;

public class MergeSortedArray {
	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int m = 3;
		int[] nums2 = { 2, 5, 6 };
		int n = 3;
		for (int i = m, j = 0; i < m + n && j < n; i++, j++) {
			nums1[i] = nums2[j];
		}
		Arrays.sort(nums1);
	}
}
