package com.algorithm.arrays.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSumOfKConsecutiveElements {

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        for(int i =0 ; i < k; i++){
            currSum+= arr[i];
        }
        maxSum = currSum;
        for( int i = k; i< arr.length ; i++){
            currSum += arr[i] - arr[i-k];
            maxSum = Math.max(maxSum, currSum);
        }
        System.out.println(maxSum);
    }
    
}
