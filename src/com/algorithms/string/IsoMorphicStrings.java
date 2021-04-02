package com.algorithms.string;

public class IsoMorphicStrings {
	public static void main(String[] args) {
		String s = "foo", t = "bar";
		if(s.length() != t.length()) {
			System.out.println(false);
			return;
		}
		
		int[] sArr = new int[256];
		int[] tArr = new int[256];
		int len = s.length();
		for(int i=0; i< len; i++) {
			if(sArr[(int)s.charAt(i)] != tArr[(int)t.charAt(i)]) {
				System.out.println(false);
				return;
			}
			sArr[s.charAt(i)] = i+1;
			tArr[s.charAt(i)] = i+1;
		}
		System.out.println(true);
	}
}
