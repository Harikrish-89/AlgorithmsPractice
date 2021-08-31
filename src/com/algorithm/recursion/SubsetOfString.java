package com.algorithm.recursion;

import java.util.ArrayList;

public class SubsetOfString {
	public static void main(String[] args) {
		ArrayList<String> result = new ArrayList<>();
		String s = "ABC";
		printSubSets(s, "", 0, result);
		System.out.println(result);
	}

	private static void printSubSets(String s, String cur, int index, ArrayList<String> result) {
		if(index == s.length()) {
			result.add(cur);
			return;
		}
		printSubSets(s, cur, index+1, result);
		printSubSets(s, cur+s.charAt(index), index+1, result);
	}
}
