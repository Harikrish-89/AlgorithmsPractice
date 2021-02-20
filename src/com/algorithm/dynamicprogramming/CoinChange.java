package com.algorithm.dynamicprogramming;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getWays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. LONG_INTEGER_ARRAY c
     */

    public static long getWays(int n, List<Long> c) {
    // Write your code here
        long[] ways = new long[n+1];
        ways[0] = 1;
        c.forEach(coin -> {
            for(int i=0; i< ways.length; i++){
                if(coin <= i){
                    ways[i] = ways[(int) (i - coin)] + ways[i];
                }
            }
        });
        return ways[n];
    }
}

public class CoinChange {
    public static void main(String[] args) throws IOException {
      System.out.println(Result.getWays(4, Arrays.asList(1L,2L,3L)));
    }
}
