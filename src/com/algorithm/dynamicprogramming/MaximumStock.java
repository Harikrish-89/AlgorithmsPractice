package com.algorithm.dynamicprogramming;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
