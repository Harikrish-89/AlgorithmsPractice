package com.algorithm.arrays;

public class MaxSubArraySum {

    public static void main(String[] args) {
        int [] arr = {1, -2, 3, -1, 2};
        System.out.println(maxSubArraySum(arr));
        System.out.println(maxSubArrayRecursion(arr, arr.length-1,0));
    }

    private static int maxSubArrayRecursion(int[] arr, int n, int res) {
        if( n == 0){
            return arr[n];
        }
        return Math.max(res, Math.max(arr[n], arr[n] + maxSubArrayRecursion(arr, n-1, res)));
    }

    private static int maxSubArraySum(int[] arr) {
        int maxSumCur = arr[0];
        int res = arr[0];
        for(int i = 1; i < arr.length ; i++){
            maxSumCur = Math.max(arr[i], arr[i]+ maxSumCur);
            res = Math.max(res, maxSumCur);
        }
        return res;
    }
    
}
