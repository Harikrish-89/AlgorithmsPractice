package com.algorithm.arrays;

public class FrequenciesInSortedArray {
    public static void main(String[] args) {
        int arr [] = {10,10,10, 20,20, 30, 30, 30};
        findFrequencies(arr);
    }

    private static void findFrequencies(int[] arr) {
        int count=1;
        for(int i =0; i < arr.length-1; i++){
            if(arr[i] == arr[i+1]){
                count ++;
            }else{
                System.out.println("elm:" + arr[i] + " appeared times:"+ count);
                count = 1;
            }
        }
        System.out.println("elm:" + arr[arr.length-1] + " appeared times:" + count);
    }
    
}

