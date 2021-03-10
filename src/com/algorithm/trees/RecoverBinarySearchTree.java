package com.algorithm.trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class RecoverBinarySearchTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.left.right = new TreeNode(2);

		inorderTraversal(root);
	}

	private static void inorderTraversal(TreeNode root) {
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode current = root;
		stack.push(root);
		TreeNode pred = null;
		TreeNode x = null;
		TreeNode y = null;
		
		while (!stack.isEmpty()) {
			while (current.left != null) {
				stack.push(current.left);
				current = root.left;
			}
			current = stack.pop();
			if(pred != null && current.val < pred.val ) {
				y=current;
				if(x==null) x= pred;
				else break;
			}
			pred = current;
			System.out.println(current.val);
			if (current.right != null) {
				stack.push(current.right);
				current = current.right;
			}

		}
		Integer temp = x.val;
		x.val = y.val;
		y.val = temp;
	}
}
