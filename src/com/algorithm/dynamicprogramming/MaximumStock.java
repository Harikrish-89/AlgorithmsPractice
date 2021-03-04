package com.algorithm.dynamicprogramming;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaximumStock {

	/*
	 * Complete the 'stockmax' function below.
	 *
	 * The function is expected to return a LONG_INTEGER. The function accepts
	 * INTEGER_ARRAY prices as parameter.
	 */

	public static long stockmax(List<Integer> prices) {
		// Write your code here
		long profit=0L;
		long maxSoFar=0L;
		 for (int i = prices.size() - 1; i > -1 ; i--) {
	            if (prices.get(i) >= maxSoFar) {
	                maxSoFar = prices.get(i);
	            }
	            profit += maxSoFar - prices.get(i);
	        }
	        return profit;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(stockmax(IntStream.of(5, 4, 3, 4, 5).boxed().collect(Collectors.toList())));
	}
}
