package com.algorithm.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = null;
		root.left.right = new TreeNode(3);
		root.right.left = null;
		root.right.right = new TreeNode(3);
		bfs(root);
	}

	public static void bfs(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> layerVals =  new ArrayList<List<Integer>>();
		if(root == null) {
			return;
		}
		queue.add(root);
		int level = 0;
		
		while (!queue.isEmpty()) {
			layerVals.add(new ArrayList<Integer>());
			int levelLength = queue.size();
			for(int i=0; i< levelLength ; i++) {
				TreeNode current = queue.poll();
				if(current != null) {
					queue.add(current.left);
					queue.add(current.right);
				}
				layerVals.get(level).add( current != null ? current.val : null);
					
			}
			/*
			 * if(!verifyIsSymmentric(layerVals.get(level))) { System.out.println(false);
			 * return; }
			 */
			level++;
		}
		System.out.println(level);
		System.out.println(layerVals);
		System.out.println(true);
		
	}

	private static boolean verifyIsSymmentric(List<Integer> list) {
		List<Integer> listrev = new ArrayList<Integer>();
		for(int i= list.size() -1; i >= 0; i--) {
			listrev.add(list.get(i));
		}
		return list.equals(listrev);
	}
}
