package com.algorithm.bitwise;

import java.util.HashMap;
import java.util.Map;

public class OneOddOccuringXor {
	public static void main(String[] args) {
		int[] arr = { 4, 3, 4, 4, 4, 5, 5 };
		naive(arr);
		efficient(arr);
	}

	private static void efficient(int[] arr) {
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			res = res ^ arr[i];
		}
		System.out.println(res);
	}

	private static void naive(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		System.out.println(
				map.entrySet().stream().filter(e -> (e.getValue() % 2) != 0).map(e -> e.getKey()).findFirst().get());
	}
}
