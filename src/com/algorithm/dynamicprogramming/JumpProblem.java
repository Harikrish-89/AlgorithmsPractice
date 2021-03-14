package com.algorithm.dynamicprogramming;

public class JumpProblem {

	public static enum Index {
		GOOD, BAD, UNKNOWN;
	}

	static Index[] memo;

	public static void main(String[] args) {

		// recursive backtracking
		int[] nums = { 2, 3, 1, 1, 4 };
		// boolean isReachable = canReachEnd_backTracking(0, nums);

		// top down memoization
		memo = new Index[nums.length];
		for (int i = 0; i < memo.length; i++) {
			memo[i] = Index.UNKNOWN;
		}
		memo[memo.length - 1] = Index.GOOD;
		// boolean isReachableTopDown = canReachEnd_TopDown(0, nums);
		boolean isReachableBottomUp = canReachEnd_bottomup(nums);

		boolean isGreedy = canReachGreedy(nums);
		System.out.println(isGreedy);
	}

	private static boolean canReachGreedy(int[] nums) {
		int lastPos = nums.length - 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if(i + nums[i] >= lastPos) {
				lastPos = i;
			}
		}
		return lastPos == 0;
	}

	private static boolean canReachEnd_bottomup(int[] nums) {

		for (int i = nums.length - 2; i >= 0; i--) {
			int longestPosition = Math.min(i + nums[i], nums.length - 1);
			for (int j = i + 1; j <= longestPosition; j++) {
				if (memo[j] == Index.GOOD) {
					memo[i] = Index.GOOD;
					break;
				}
			}
		}

		return memo[0] == Index.GOOD;
	}

	private static boolean canReachEnd_TopDown(int pos, int[] nums) {
		if (memo[pos] != Index.UNKNOWN) {
			return memo[pos] == Index.GOOD;
		}
		int furthestPosition = Math.min(pos + nums[pos], nums.length - 1);
		for (int nextPos = furthestPosition; nextPos > pos; nextPos--) {
			if (canReachEnd_backTracking(nextPos, nums)) {
				memo[pos] = Index.GOOD;
				return true;
			}
		}
		memo[pos] = Index.BAD;
		return false;
	}

	private static boolean canReachEnd_backTracking(int pos, int[] nums) {

		if (pos == nums.length - 1) {
			return true;
		}
		int furthestPosition = Math.min(pos + nums[pos], nums.length - 1);
		for (int nextPos = furthestPosition; nextPos > pos; nextPos--) {
			return canReachEnd_backTracking(nextPos, nums);
		}
		return false;
	}
}
