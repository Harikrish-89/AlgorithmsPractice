package com.algorithm.dynamicprogramming;

import java.util.Arrays;

public class CoinChangeMinimumCoins {
	public static void main(String[] args) {
		int[] coins = { 1,2,5 };
		int amount = 11;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount+1);
		dp[0] = 0;
		for (int i = 0; i < coins.length; i++) {
			int currentCoin = coins[i];
			for (int j = 1; j < dp.length; j++) {
				if (j >= currentCoin) {
					int noOfCurrentCoin = j / currentCoin;
					int balance = j % currentCoin;
					int totalCoins = noOfCurrentCoin + dp[balance];
					dp[j] = Math.min(dp[j], totalCoins);
				}
			}
		}
		System.out.println(dp[amount]);
		System.out.println(solvedMineConflictsWithLeetCode(coins, amount));
	}
	
	public static int solvedMineConflictsWithLeetCode(int[] coins, int amount) {
	        int[] dp = new int[amount + 1];
	        Arrays.fill(dp, amount +1);
			dp[0] = 0;
			for (int i = 0; i < coins.length; i++) {
				int currentCoin = coins[i];
				for (int j = 0; j < dp.length; j++) {
					if (j < currentCoin) {
						dp[j] = 1;
					}
					if (j >= currentCoin) {
						int noOfCurrentCoin = j / currentCoin;
						int balance = j % currentCoin;
						int totalCoins = noOfCurrentCoin + dp[balance];
						dp[j] = Math.min(dp[j], totalCoins);
					}
				}
			}
			
	        return dp[amount];
	}
}
