package com.algorithm.recursion;

import java.util.Arrays;

public class ReverseStringRecursion {
	public static void main(String[] args) {
		String s = "hari";
		char[] charArray = s.toCharArray();
		swap(0, charArray.length - 1, charArray);
		System.out.println(charArray);
	}

	private static void swap(int index1, int index2, char[] array) {
		if (index1 >= index2) {
			return;
		}
		char temp = array[index2];
		array[index2] = array[index1];
		array[index1] = temp;
		swap(++index1, --index2, array);
		
	}
	
	
}
