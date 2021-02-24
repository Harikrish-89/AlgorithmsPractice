package com.algorithm.dynamicprogramming;

public class HackerRankAbbrevation {

	public static void main(String[] args) {

		String a = "SYIHDDSMREKXOKRFDQAOZJQXRIDWXPYINFZCEFY";

		String b = "SYIHDDSMREKXOKRFDQAOZJQXRIDWXPYINFZCEFYyxu";
		int l1 = b.length();
		int l2 = a.length();
		boolean[][] equality = new boolean[l1 + 1][l2 + 1];
		equality[0][0] = true;
		for (int i = 1; i < l1; i++) {
			equality[i][0] = equality[i - 1][0] && Character.isLowerCase(b.charAt(i - 1));
		}
		for (int i = 1; i < l2; i++) {
			equality[0][i] = false;
		}
		for (int i = 1; i <= l1; i++) {
			for (int j = 1; j <= l2; j++) {
				if (Character.isUpperCase(b.charAt(i - 1))) {
					equality[i][j] = a.charAt(j - 1) == b.charAt(i - 1) && equality[i - 1][j - 1];
				} else {
					Character capitalisedB = Character.toUpperCase(b.charAt(i - 1));
					if (capitalisedB == a.charAt(j - 1)) {
						equality[i][j] = equality[i-1][j] || equality[i - 1][j - 1];
					} else {
						equality[i][j] = equality[i - 1][j];
					}
				}

			}
		}

		System.out.println(equality[l1][l2]);

	}

}
