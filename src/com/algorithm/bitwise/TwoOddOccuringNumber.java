package com.algorithm.bitwise;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TwoOddOccuringNumber {
	public static void main(String[] args) {
		int[] arr = { 4, 3, 4, 4, 4, 5, 5, 6 };
		// naive(arr);
		//efficient(arr);
		int x =3;
		x = (x<<1) + x + (x>>1);
		System.out.println(x);
	}

	private static void efficient(int[] arr) {
		int n = arr.length;
		int xor = 0, res1 = 0, res2 = 0;
		for (int i = 0; i < n; i++)
			xor = xor ^ arr[i];
		int sn = xor & (~(xor - 1));
		for (int i = 0; i < n; i++) {
			if ((arr[i] & sn) != 0)
				res1 = res1 ^ arr[i];
			else
				res2 = res2 ^ arr[i];
		}
		System.out.println(res1 + " " + res2);

	}

	private static void naive(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		System.out.println(map.entrySet().stream().filter(e -> (e.getValue() % 2) != 0).map(e -> e.getKey())
				.collect(Collectors.toList()));
	}
}
