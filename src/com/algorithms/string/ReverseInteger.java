package com.algorithms.string;

public class ReverseInteger {
	public static void main(String[] args) {
		int x = 1534236469;
		char[] chars = String.valueOf(x).toCharArray();
		char[] result = new char[chars.length];
		for (int i = chars.length - 1, j = 0; i >= 0 && j < chars.length; i--, j++) {
			if (chars[i] != '-') {
				result[j] = chars[i];
			}
		}
		if(Long.valueOf(new String(result).trim()) > Integer.MAX_VALUE) {
			System.out.println(0);
			return;
		}
		if(chars[0] == '-' && -Long.valueOf(new String(result).trim()) < Integer.MIN_VALUE) {
			System.out.println(0);
			return;
		}
		System.out.println(chars[0] == '-' ? -Integer.valueOf(new String(result).trim())
				: Integer.valueOf(new String(result).trim()));

	}
}
