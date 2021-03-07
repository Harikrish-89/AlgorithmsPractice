package com.algorithms.linkedlist;

public class RemoveNthNodeFromEnd {

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		node1.setNext(node2);
		Node node3 = new Node(3);
		node2.setNext(node3);
		Node node4 = new Node(4);
		node3.setNext(node4);
		Node node5 = new Node(5);
		node4.setNext(node5);
		Node node6 = new Node(6);
		node5.setNext(node6);

		delete(node1, 2);
		Node node = node1;
		while (node != null) {
			System.out.println(node.getVal());
			node = node.getNext();
		}

	}

	private static void delete(Node node1, int n) {
		Node current = node1;
		int length = 1;
		while (current.getNext() != null) {
			current = current.getNext();
			length++;
		}
		System.out.println(length);
		int nodePos = length - n;
		System.out.println(nodePos);
		int i = 0;
		Node nodeToReplace = node1;
		Node previous = null;
		while (i < nodePos) {
			previous = nodeToReplace;
			nodeToReplace = nodeToReplace.getNext();
			i++;
		}
		System.out.println(i);
		System.out.println(nodeToReplace);
		if (nodeToReplace.getNext() == null) {
			previous.setNext(null);
			return;
		}

		nodeToReplace.setVal(nodeToReplace.getNext().getVal());
		nodeToReplace.setNext(nodeToReplace.getNext().getNext());

	}

}
