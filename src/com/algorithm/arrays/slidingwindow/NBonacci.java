package com.algorithm.arrays.slidingwindow;

import java.util.Arrays;

public class NBonacci {

    public static void main(String[] args) {

        simple();
        slidingWindow();
        
    }

    private static void slidingWindow() {
        int n = 10, k = 5;
        int[] res = new int[n];
        res[k-1] = 1;
        res[k] = 1;
        for(int i = k + 1 ; i < n; i++){
            res[i] = res[i-1] + res[i-1] - res[i-k-1];
        }
            
        System.out.println(Arrays.toString(res));
    }

    private static void simple() {
        int n = 10, k = 5;
        int[] res = new int[n];
        res[k-1] = 1;
        for(int i = k ; i < n; i++){
            int sumFori = 0;
            int start = 0;
            while( start <= k){
                sumFori += res[i-start];
                start++;
            }
            res[i] = sumFori;
            
        }
        System.out.println(Arrays.toString(res));
    }
    
}
