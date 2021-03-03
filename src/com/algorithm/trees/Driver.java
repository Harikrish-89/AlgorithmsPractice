package com.algorithm.trees;

public class Driver {
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.add(1);
		bst.add(4);
		bst.add(17);
		bst.add(15);
		bst.add(22);
		System.out.println(bst);
		System.out.println(bst.search(20));
		/*
		 * bst.traverseInOrder(bst.search(1)); bst.traversePreOrder(bst.search(1));
		 * bst.traversePostOrder(bst.search(1));
		 */
		bst.levelOrderTraversalOrBFS();
	}
}
