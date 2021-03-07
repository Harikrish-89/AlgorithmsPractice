package com.algorithms.string;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ValidAnagram {
	public static void main(String[] args) {
		String s = "anagram";
		String t = "nagaram";
		if(s.length() != t.length()) {
			System.out.println(false);
			return;
		}
		Map<Character, Long> mapOfS = s.chars().mapToObj(i -> (char) i)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Map<Character, Long> mapOfT = t.chars().mapToObj(i -> (char) i)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(mapOfS);
		System.out.println(mapOfT);
		for(char c : mapOfT.keySet()) {
			if(!mapOfT.get(c).equals(mapOfS.get(c))) {
				System.out.println(false);
				return;
			}
		}
		System.out.println(true);
	}

}
