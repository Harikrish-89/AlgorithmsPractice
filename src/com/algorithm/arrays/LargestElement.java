package com.algorithm.arrays;

public class LargestElement {
    public static void main(String[] args) {
        int [] arr = {10,40,20,30};
        System.out.println(findLargest(arr));
    }

    private static int findLargest(int[] arr) {
        int max = Integer.MIN_VALUE, maxIndex = Integer.MIN_VALUE;
        for(int i=0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
}
