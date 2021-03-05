package com.algorithms.string;

import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		String s = "loveleetcode";
		System.out.println(findChar(s));
	}

	private static int findChar(String s) {
		return s.chars().mapToObj(i -> (char) i)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(entry -> entry.getValue() == 1).mapToInt(entry -> s.indexOf(entry.getKey())).min().orElse(-1);
	}
}
