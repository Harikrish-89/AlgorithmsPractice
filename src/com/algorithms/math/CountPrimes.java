package com.algorithms.math;

import java.util.Arrays;

public class CountPrimes {
	
	public static void main(String[] args) {
		int n = 121;
		Boolean[] isPrime = new Boolean[n];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for(int i=2; i*i < n; i++) {
			if(isPrime[i]) {
				for(int j=i*i; j < n; j+=i) {
					isPrime[j]= false;
				}
			}
		}
		System.out.println(Arrays.stream(isPrime).filter(b -> b).count());
	}

}
