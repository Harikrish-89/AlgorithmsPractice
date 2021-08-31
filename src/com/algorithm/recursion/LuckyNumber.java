package com.algorithm.recursion;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LuckyNumber {
    public static void main(String[] args) {
        System.out.println(isLuckyNumber(73));
    }

    private static boolean isLuckyNumber(int n) {
        List<Integer> series = IntStream.rangeClosed(1, n).mapToObj( i -> i).collect(Collectors.toList());
      
      return isLuckyNumberIterative(series, n, 2);
    }

    private static boolean isLuckyNumberIterative(List<Integer> series, int n, int counter) {
        if(series.size() < counter){
            return series.contains(n);
        }
        for(int i=counter-1; i < series.size(); i += counter-1){
            series.remove(i);
        }
        return isLuckyNumberIterative(series, n, counter+1);
    }
}
