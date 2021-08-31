package com.algorithm.recursion;

public class TowerOfHanoi {
	public static void main(String[] args) {
		towerOfHanoi(4,'A', 'B','C');

	}

	private static void towerOfHanoi(int n, char source, char aux, char dest) {
		if(n == 1) {
			System.out.println("move 1 from "+ source +" to " + dest);
			return;
		}
		towerOfHanoi(n-1, source, dest, aux);
		System.out.println("move " + n +" from " + source + " to " + dest);
		towerOfHanoi(n-1, aux, source, dest);
	}
}
