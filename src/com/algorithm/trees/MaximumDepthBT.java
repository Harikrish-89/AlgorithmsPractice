package com.algorithm.trees;

import java.util.Arrays;

public class MaximumDepthBT {
	public static void main(String[] args) {
		Integer[] input = { 3, 9, 20, null, null, 15, 7 };
		TreeNode root = new TreeNode();
		findDepth(root);

	}

	public static int findDepth(TreeNode current) {
		int leftHeight = 0;
		int rightHeight = 0;
		if (current == null) {
			return 0;
		}
		if (current.left == null && current.right == null) {
			return 1;
		}
		leftHeight += findDepth(current.left) + 1;
		rightHeight += findDepth(current.right) + 1;
		return Math.max(leftHeight, rightHeight);
	}
}
