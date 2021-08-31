package com.algorithm.arrays;

import java.util.HashSet;
import java.util.Set;

public class SmallestPositiveMissingNo {

    public static void main(String[] args) {
        int[] arr = { 0, -10, 1, 3, -20 };
        System.out.println(missingNumber(arr, arr.length));
    }

    static int missingNumber(int arr[], int size) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add(arr[i]);
        }
        int missingNo = Integer.MAX_VALUE;
        for (int i = 1; i <= size; i++) {
            if (!set.contains(i)) {
                missingNo = Math.min(missingNo, i);
            }
        }
        if (missingNo == Integer.MAX_VALUE)
            missingNo = size + 1;
        return missingNo;
    }
}
