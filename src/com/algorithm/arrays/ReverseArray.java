package com.algorithm.arrays;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        reverse(new int[]{1,3,4,5,6});
    }

    private static void reverse(int[] is) {
        int left = 0, right = is.length -1;
        while(left < right){
            int temp = is[left];
            is[left] = is[right];
            is[right] = temp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(is));
    }
    
}
