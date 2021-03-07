package com.algorithm.trees;

public class ValidateBST {
	private static Integer prev;

	public static void main(String[] args) {
		TreeNode root = null;
		prev = null;
		System.out.println(inorder(root));

	}

	private static boolean inorder(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (!inorder(root.left)) {
			return false;
		}
		if (prev != null && root.val <= prev) {
			return false;
		}
		prev = root.val;
		return inorder(root.right);
	}
}
