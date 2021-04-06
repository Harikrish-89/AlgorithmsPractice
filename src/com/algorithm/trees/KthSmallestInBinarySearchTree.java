package com.algorithm.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class KthSmallestInBinarySearchTree {
	  public static int kthSmallest(TreeNode root, int k) {
	        List<Integer> inOrder = new ArrayList<Integer>();
	        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
	        TreeNode current = root;
	        while(current != null || !stack.isEmpty()){
	            while(current != null){
	                stack.push(current);
	                current = current.left;
	            }
	            current = stack.pop();
	            inOrder.add(current.val);
	            current = current.right;
	        }
	        return inOrder.get(k-1);
	    }
}
