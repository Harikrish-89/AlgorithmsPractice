package com.algorithm.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

	public void remove(T element) {
		root = removeRecursive(root, element);
	}

	private Node<T> removeRecursive(Node<T> current, T element) {
		if (current == null) {
			return null;
		}
		if (element.compareTo(current.getKey()) > 0) {
			current.setRight(removeRecursive(current.getRight(), element));
		} else if (element.compareTo(current.getKey()) < 0) {
			current.setLeft(removeRecursive(current.getLeft(), element));
		} else if (element.compareTo(current.getKey()) == 0) {
			if (current.getLeft() == null && current.getRight() == null) {
				return null;
			}
			if (current.getLeft() == null) {
				return current.getRight();
			}
			if (current.getRight() == null) {
				return current.getLeft();
			}
			T minValue = findMinValue(current.getRight());
			current.setKey(minValue);
			current.setRight(removeRecursive(current.getRight(), minValue));
		}

		return root;
	}

	// Depth first search
	// in order traversal
	public void traverseInOrder(Node<T> node) {
		if (node != null) {
			traverseInOrder(node.getLeft());
			System.out.println(node.getKey());
			traverseInOrder(node.getRight());
		}

	}

	public void traverseInOrderIterative(Node<T> node) {
		Deque<Node<T>> stack = new ArrayDeque<Node<T>>();
		Node<T> current = node;
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.getLeft();
			}
			current = stack.pop();
			System.out.println(current.getKey());
			current = current.getRight();
		}

	}

	public void traversePreOrder(Node<T> node) {
		if (node != null) {
			System.out.println(node.getKey());
			traversePreOrder(node.getLeft());
			traversePreOrder(node.getRight());
		}
	}

	public void traversePostOrder(Node<T> node) {
		if (node != null) {
			traversePreOrder(node.getLeft());
			traversePreOrder(node.getRight());
			System.out.println(node.getKey());
		}
	}

	public void levelOrderTraversalOrBFS() {
		Node<T> current = root;
		Queue<Node<T>> queue = new LinkedList<Node<T>>();
		queue.add(current);

		while (!queue.isEmpty()) {
			current = queue.remove();
			System.out.println(current.getKey());
			if (current.getLeft() != null) {
				queue.add(current.getLeft());
			}
			if (current.getRight() != null) {
				queue.add(current.getRight());
			}
		}
	}
	
	public void zigZagLevelOrder() {
	        Queue<Node<T>> queue = new LinkedList<Node<T>>();
	        List<List<T>> result = new ArrayList<List<T>>();
	        if(root == null) return;
	        
	        queue.add(root);
	        boolean reverse = false;
	        while(!queue.isEmpty()) {
	            List<T> list = new ArrayList<T>();
	           int n = queue.size();
	            for(int i = 0 ; i < n ; i++) {
	            	Node<T> node = queue.poll();
	                
	                list.add(node.getKey());
	                if(node.getLeft() != null) queue.add(node.getLeft());
	                if(node.getRight() != null) queue.add(node.getRight());
	            }
	           
	            if(reverse) Collections.reverse(list); 
	            result.add(list);
	            reverse = !reverse;
	        }
	        System.out.println(result);
	}

	private T findMinValue(Node<T> current) {
		return current.getLeft() == null ? current.getKey() : findMinValue(current.getLeft());
	}

	public int findHeightOfTree() {
		return calcualteHeight(root);
	}

	private int calcualteHeight(Node<T> current) {
		if (current == null) {
			return 0;
		}
		int ltHeight = calcualteHeight(current.getLeft());
		int rtHeight = calcualteHeight(current.getRight());
		return Math.max(ltHeight, rtHeight) + 1;
	}

}
