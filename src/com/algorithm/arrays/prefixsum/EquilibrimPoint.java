package com.algorithm.arrays.prefixsum;

import java.util.*;
import java.util.stream.Collectors;

public class EquilibrimPoint {

    public static void main(String[] args) {
        Integer[] arr = { 3, 4, 8, -4,-5, 20, 3, 3};
        //Integer[] arr = { 4, 42, 27, 16, 28, 3, 4, 5, 9, 3, 31, 5, 5, 29, 10, 18, 35, 35, 33, 19, 41, 23, 8, 32, 9, 5,
               // 8, 18, 35, 13, 6, 7, 6, 10, 11, 13, 37, 2, 25, 7, 28, 43 };
    Set<Integer> set = Arrays.stream(arr).map(i -> Integer.valueOf(i)).collect(Collectors.toSet());
        Integer[] leftCumSum = new Integer[arr.length];
        int cumSum = 0;
        for (int i = 0; i < arr.length; i++) {
            cumSum += arr[i];
            leftCumSum[i] = cumSum;
        }
        cumSum = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            cumSum += arr[i];
            if (cumSum - leftCumSum[i] == 0) {
                System.out.println("equilibrim at:" + (i+1));
                return;
            }
        }
        System.out.println("no Equilibrim");

    }

}
