package com.algorithm.arrays;

import java.util.Arrays;

public class RearrangeAlternatively {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int left = 0, right = arr.length-1, i=0;
        int[] res = new int[arr.length];
        
        while(left < right){
            res[i] = Math.max(arr[left], arr[right]);
            res[i+1] = Math.min(arr[left], arr[right]);
            i+=2;
            left++;
            right--;
        }
        for(i=0; i< res.length; i++){
            arr[i] = res[i];
        }
        System.out.println(Arrays.toString(res));

    }

}
