package com.algorithm.trees;

public class BinarySearchTree<T extends Comparable<T>> {

	private Node<T> root;

	public BinarySearchTree() {
		this.root = null;
	}

	public void add(T value) {
		root = addRecursive(root, value);
	}

	private Node<T> addRecursive(Node<T> current, T value) {

		if (current == null) {
			return new Node<T>(value);
		}

		if (value.compareTo(current.getKey()) < 0) {
			current.setLeft(addRecursive(current.getLeft(), value));
		} else if (value.compareTo(current.getKey()) > 0) {
			current.setRight(addRecursive(current.getRight(), value));
		}

		return current;
	}

	public Node<T> search(T element) {
		return searchRecursive(root, element);
	}

	private Node<T> searchRecursive(Node<T> current, T element) {
		if (current != null) {
			if (current.getKey().equals(element)) {
				return current;
			}
			if (element.compareTo(current.getKey()) > 0) {
				return searchRecursive(current.getRight(), element);
			} else if (element.compareTo(current.getKey()) < 0) {
				return searchRecursive(current.getLeft(), element);
			}
		}
		return null;
	}

	public boolean remove(T element) {
		Node<T> node = search(element);
		if (node != null) {
			node = null;
			return true;
		}
		return false;
	}

}
