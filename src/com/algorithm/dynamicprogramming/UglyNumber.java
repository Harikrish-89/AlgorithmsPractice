package com.algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber {
// Bad approach for large numbers but better than original recursion?? may be
	public static void main(String[] args) {
		int n = 1500;
		List<Double> uglySequence = new ArrayList<Double>();
		uglySequence.add(1.0);
		Double i = 2.0;
		while (uglySequence.size() < n) {
			Double reminderOf2 = i / 2;
			Double reminderOf3 = i / 3;
			Double reminderOf5 = i / 5;
			if (reminderOf2.equals(1.0) || reminderOf3.equals(1.0) || reminderOf5.equals(1.0)
					|| uglySequence.contains(reminderOf2) || uglySequence.contains(reminderOf3)
					|| uglySequence.contains(reminderOf5)) {

				uglySequence.add(i);
			}
			System.out.println(uglySequence.size());
			i++;
		}
		System.out.println(uglySequence.get(uglySequence.size()-1));
	}

}
