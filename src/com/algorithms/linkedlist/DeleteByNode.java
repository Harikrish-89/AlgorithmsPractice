package com.algorithms.linkedlist;

public class DeleteByNode {

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		node1.setNext(node2);
		Node node3 = new Node(3);
		node2.setNext(node3);
		Node node4 = new Node(4);
		node3.setNext(node4);

		deleteNode(node2);
		Node node = node1;
		while (node != null) {
			System.out.println(node.getVal());
			node = node.getNext();
		}

	}

	private static void deleteNode(Node node) {
		node.setVal(node.getNext().getVal());
		node.setNext(node.getNext().getNext());
	}
}