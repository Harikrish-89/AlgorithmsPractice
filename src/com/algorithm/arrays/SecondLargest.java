package com.algorithm.arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int [] arr = {10,30,40,20};
        System.out.println(findSecondLargest(arr));
    }
    
    private static int findSecondLargest(int[] arr) {
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE, secondMaxIndex = 0, maxIndex = 0;
        for(int i=0; i < arr.length; i++){
            if(arr[i] > max && arr[i] > secondMax){
                secondMax = max;
                secondMaxIndex = maxIndex;
                max = arr[i];
                maxIndex = i;
            }else if(arr[i] > secondMax && arr[i] < max){
                secondMax = arr[i];
                secondMaxIndex = i;
            }
        }
        return secondMaxIndex;
    }
}
