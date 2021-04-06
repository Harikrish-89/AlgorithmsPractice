package com.algorithm.trees;

import java.util.LinkedList;

public class BinarySearchTreeInOrderSuccessor {
	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode current = root;
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			if (current.val > p.val) {
				return current;
			}
			current = current.right;
		}
		return null;
	}
}
