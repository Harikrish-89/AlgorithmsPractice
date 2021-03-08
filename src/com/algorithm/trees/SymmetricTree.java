package com.algorithm.trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class SymmetricTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		bfs(root);
	}

	private static void bfs(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<TreeNode> visited = new ArrayList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			visited.add(current);
			if (current.left != null) {
				queue.add(current.left);
			}
			if (current.right != null) {
				queue.add(current.right);
			}
		}
		if (visited.size() == 1) {
			System.out.println(true);
			return;
		}
		System.out.println(visited.stream().map(node -> node.val).collect(Collectors.toList()));
	}
}