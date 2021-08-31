package com.algorithm.arrays;

public class MaxDifference {
    public static void main(String[] args) {
        int[] arr = { 30, 10, 8, 2 };
        System.out.println(findMaxDiff(arr));
    }

    private static int findMaxDiff(int[] arr) {
        int localMin = arr[0];
        int res = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            res = Math.max(res, arr[i] - localMin);
            localMin = Math.min(localMin, arr[i]);
        }
        return res;
    }

}
