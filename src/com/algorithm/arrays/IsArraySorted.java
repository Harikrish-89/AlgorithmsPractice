package com.algorithm.arrays;

public class IsArraySorted {
    public static void main(String[] args) {
        System.out.println(isArraySorted(new int[]{-1,0,3,4}));
    }

    private static boolean isArraySorted(int[] is) {
        for(int i = 1; i < is.length; i++){
            if(is[i] < is[i-1]){
                return false;
            }
        }
        return true;
    }
    
}
