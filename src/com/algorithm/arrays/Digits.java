package com.algorithm.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Digits {
	public static void main(String[] args) {
		int[] digits = {9, 9, 0};
		int[] result = new int[digits.length +1];
		if(digits[digits.length-1] < 9) {
			digits[digits.length-1] = digits[digits.length-1] +1;
			System.out.println(Arrays.stream(digits).boxed().collect(Collectors.toList()));
		}
		int index = digits.length -1;
		boolean added = false;
		while(index >= 0) {
			if(!added) {
				if(digits[index] >= 9) {
					result[index+1] = 0;
				}else {
					result[index+1] = digits[index] +1;
					added = true;
				}
			}else {
				result[index+1] = digits[index];
			}
			
		--index;
		}
		if(!added) {
			result[0] = 1;
		}else {
			result = Arrays.copyOfRange(result, 1, result.length);
		}
		System.out.println(Arrays.stream(result).boxed().collect(Collectors.toList()));
	}
}
