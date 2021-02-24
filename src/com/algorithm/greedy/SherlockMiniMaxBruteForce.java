package com.algorithm.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SherlockMiniMaxBruteForce {

	public static void main(String[] args) {
		int[] arr = { 5, 8, 14 };
		int p = 4;
		int q = 9;
		Arrays.sort(arr);
		Map<Integer, Integer> minimumArrayMap = new HashMap<Integer, Integer>();
		IntStream.rangeClosed(p, q).forEach(i -> {
			Arrays.stream(arr).forEach(arrItem -> {
				if (minimumArrayMap.containsKey(i)) {
					minimumArrayMap.put(i, Math.min(minimumArrayMap.get(i), Math.abs(i - arrItem)));
				} else {
					minimumArrayMap.put(i, Math.abs(i - arrItem));
				}
			});
		});
		List<Map.Entry<Integer, Integer>> listOfEntries = minimumArrayMap.entrySet().stream()
				.sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
				.collect(Collectors.toList());
		Integer maxMinDiff = listOfEntries.get(0).getValue();
		System.out.println(listOfEntries.stream().filter(entry -> entry.getValue().equals(maxMinDiff))
				.map(entry -> entry.getKey()).min((i1, i2) -> i1.compareTo(i2)).get());
	}

}
