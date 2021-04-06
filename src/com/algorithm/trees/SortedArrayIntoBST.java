package com.algorithm.trees;

public class SortedArrayIntoBST {
	public static void main(String[] args) {
		int[] nums = { -10, -3, 0, 5, 9 };
		TreeNode root = null;

		int mid = nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1;
		int rootVal = nums[mid];
		root = addRecursive(root, rootVal);
		for (int i = mid, j = mid; i >= 0 && j < nums.length; i--, j++) {
			if (nums[i] != rootVal || nums[j] != rootVal) {
				root = addRecursive(root, nums[i]);
				root = addRecursive(root, nums[j]);
			}
		}
		BinaryTreeLevelOrderTraversal.bfs(root);
	}

	private static TreeNode addRecursive(TreeNode current, Integer val) {
		if (current == null) {
			return new TreeNode(val);
		}
		if (val < current.val) {
			current.left = addRecursive(current.left, val);
		}
		if (val > current.val) {
			current.right = addRecursive(current.right, val);
		}
		return current;
	}

	int[] nums;

	public TreeNode helper(int left, int right) {
		if (left > right)
			return null;

// always choose left middle node as a root
		int p = (left + right) / 2;

// preorder traversal: node -> left -> right
		TreeNode root = new TreeNode(nums[p]);
		root.left = helper(left, p - 1);
		root.right = helper(p + 1, right);
		return root;
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		this.nums = nums;
		return helper(0, nums.length - 1);
	}
}
