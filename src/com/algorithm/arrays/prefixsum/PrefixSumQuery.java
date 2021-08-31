package com.algorithm.arrays.prefixsum;

public class PrefixSumQuery {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 6, 8, 5, 7, 38 };
        int[] cumSum = new int[arr.length];
        int cumSumInit = arr[0];
        cumSum[0]  = cumSumInit;
        for (int i = 1; i < arr.length; i++) {
            cumSumInit += arr[i];
            cumSum[i] = cumSumInit;
        }

        int sumOfOneAndFive = cumSum[5] - cumSum[0];
        System.out.println(sumOfOneAndFive);
    }

}
