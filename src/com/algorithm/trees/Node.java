package com.algorithm.trees;

public class Node<T> {

	private final T key;

	private  Node<T> left;

	private  Node<T> right;

	public Node(T key, Node<T> left, Node<T> right) {
		super();
		this.key = key;
		this.setLeft(left);
		this.setRight(right);
	}

	public Node(T key) {
		super();
		this.key = key;
		this.setLeft(null);
		this.setRight(null);
	}

	public Node() {
		key = null;
		right = left = null;
	}

	public T getKey() {
		return key;
	}

	public Node<T> getLeft() {
		return left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}
}
