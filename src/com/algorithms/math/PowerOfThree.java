package com.algorithms.math;

import java.math.BigDecimal;

public class PowerOfThree {
	public static void main(String[] args) {
		int n = 19682;
		System.out.println((Math.log10(n) / Math.log10(3)) % 1 == 0);
	}
}
