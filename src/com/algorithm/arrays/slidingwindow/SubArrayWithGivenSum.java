package com.algorithm.arrays.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class SubArrayWithGivenSum {

    public static void main(String[] args) {
        slidingWindow();

        hashing();
    }

    private static void hashing() {
        Map<Integer, Integer> cumSumMap = new HashMap<>();
        int arr[] = {15, 2, 4, 8, 9, 5, 10, 23}; 
        int k = 23; 
        int cumSum = 0 , count = 0;
        for(int i=0; i<arr.length; i++) {
            cumSum += arr[i];
            int complement = cumSum - k;
            if(cumSumMap.containsKey(complement)){
                count += cumSumMap.get(complement);
            }
            cumSumMap.put(cumSum, cumSumMap.getOrDefault(cumSum, 0)+1);
        }
        System.out.println(count);

    }

    private static void slidingWindow() {
        int arr[] = {15, 2, 4, 8, 9, 5, 10, 23}; 
		int n = arr.length; 
		int sum = 23; 
        int start = 0;
        int currSubArraySum = arr[0];
        if(currSubArraySum == sum){
            System.out.println(true);
        }
        for(int i=1; i < n; i++){
           while(currSubArraySum > sum && start < i-1){
            currSubArraySum = currSubArraySum - arr[start];
            start ++;
           }
           if(currSubArraySum == sum){
               System.out.println("Subarray Found between index :" + start + " and " + (i-1));
               return;
           }
           if(i < n)
           currSubArraySum += arr[i];

        }
        System.out.println("Subarray not found");
    }
    
}
