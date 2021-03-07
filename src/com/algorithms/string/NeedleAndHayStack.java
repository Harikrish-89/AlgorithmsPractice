package com.algorithms.string;

public class NeedleAndHayStack {
	public static void main(String[] args) {
		String haystack = "hello";
		String needle = "ll";
		System.out.println(needle=="" ? 0 : haystack.contains(needle) ? haystack.indexOf(needle) : -1);
	}
}
