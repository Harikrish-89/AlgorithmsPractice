package com.algorithm.trees;

public class SortedArrayIntoBST {
	public static void main(String[] args) {
		int[] nums = { -10, -3, 0, 5, 9 };
		TreeNode root = null;
		
        int mid = nums.length % 2 == 0 ? nums.length/2 : nums.length/2 +1;
        int rootVal = nums[mid];
        root =	addRecursive(root, rootVal);
		for(int i=mid, j=mid; i>=0 && j < nums.length ; i--, j++) {
			if(nums[i] != rootVal || nums[j]!= rootVal) {
				root = addRecursive(root, nums[i]);
                root = addRecursive(root, nums[j]);
			}
		}
        BinaryTreeLevelOrderTraversal.bfs(root);
    }
    private static TreeNode addRecursive(TreeNode current, Integer val) {
		if(current == null) {
			return new TreeNode(val);
		}
		if(val < current.val) {
			current.left = addRecursive(current.left, val);
		}
		if(val > current.val) {
			current.right = addRecursive(current.right, val);
		}
		return current;
	}
}
