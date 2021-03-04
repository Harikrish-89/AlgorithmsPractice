package com.algorithm.dynamicprogramming;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Question1 {
	public static void main(String[] args) {

		List<Integer> input = IntStream.of(2, 1, 2).boxed().collect(Collectors.toList());
		input.sort((c1, c2) -> c1.compareTo(c2));
		Integer maxSumSofar = input.get(input.size() - 1);
		Integer pos = input.size() - 2;
		while (maxSumSofar <= IntStream.range(0, pos).map(i -> input.get(i)).sum()) {
			maxSumSofar = maxSumSofar + input.get(pos);
			pos--;
		}
		System.out.println(
				IntStream.range(pos, input.size()).map(i -> input.get(i)).boxed().collect(Collectors.toList()));

	}
}
