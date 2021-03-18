package com.algorithms.linkedlist;

import java.util.LinkedList;

import org.graalvm.compiler.core.common.util.ReversedList;

public class ReverseALinkedList {

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
		reverse(node1);
		Node node = node1;
		while (node.getNext() != null) {
			System.out.println(node.getVal());
			node = node.getNext();
		}
	}

	private static void reverse(Node node1) {
		Node current = node1;
		int length = 1;
		while(current.getNext() != null) {
			current = current.getNext();
			length ++;
		}
		Node[] nodes = new Node[length];
		int i =0;
		current = node1;
		while(current.getNext() != null) {
			nodes[i] = current;
			current = current.getNext();
			i++;
		}
		nodes[i] = current;
		for(int j= nodes.length -1; j>0; j--) {
			nodes[j].setNext(nodes[j-1]);
		}
		nodes[0].setNext(null);
		node1 = nodes[length-1];
	}
}
