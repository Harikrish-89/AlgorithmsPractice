package com.algorithm.arrays;

import java.util.Arrays;

public class RearrangeWithOOneExtraSpace {
    public static void main(String[] args) {
        long arr[] = {4,0,2,1,3};
        long res[] = new long[arr.length];
        int n = arr.length;
        withNExtraSpace(arr, res);
        arr = new long[]{4,0,2,1,3};

        for (int i = 0; i < n; i++){
            int indexModifed = (int) arr[i];
            long modulo = arr[indexModifed] % n;
            arr[i] +=  modulo * n;
        }
     

        // Second Step: Divide all values by n
        for (int i = 0; i < n; i++)
            arr[i] /= n;

            System.out.println(Arrays.toString(arr));
    }

    private static void withNExtraSpace(long[] arr, long[] res) {
        for(int i=0; i< arr.length; i++){
            res[i] = arr[(int) arr[i]];
        }
        for(int i=0; i< arr.length; i++){
            arr[i] =res[i];
        }
    }
    
}
