package com.algorithm.dynamicprogramming;

public class MaximumProfit {
	public static void main(String[] args) {
		int[] prices = {2,1,2,1,0,1,2};
		int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice){
                minprice = prices[i];
            }
            maxprofit = Math.max(maxprofit, prices[i]-minprice);
        }
        
        System.out.println(maxprofit);
	}
}
