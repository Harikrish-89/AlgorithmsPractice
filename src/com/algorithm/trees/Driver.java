package com.algorithm.trees;

public class Driver {
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.add(1);
		bst.add(20);
		bst.add(25);
		System.out.println(bst);
		System.out.println(bst.search(20));
		bst.remove(20);
		System.out.println(bst);
	}
}
