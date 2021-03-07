package com.algorithms.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CycleInTheList {
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
		node6.setNext(node1);
		findCycle(node1);
	}

	private static void findCycle(Node head) {
		Map<Node, Integer> map = new HashMap<Node, Integer>();
		Node current = head;
		int pos = 0;
		while(current != null) {
			if(map.containsKey(current)) {
				System.out.println(true);
				return;
			}
			map.put(current, pos);
			current = current.getNext();
			pos++;
		}
		System.out.println(false);
	}
}
