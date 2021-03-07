package com.algorithms.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PalindromeList {
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		node1.setNext(node2);
		/*
		 * Node node3 = new Node(2); node2.setNext(node3); Node node4 = new Node(1);
		 * node3.setNext(node4);
		 */
		isPalindrome(node1);

	}

	private static void isPalindrome(Node node1) {
		List<Integer> forward = new ArrayList<Integer>();
		Node current = node1;
		while(current != null) {
			forward.add(current.getVal());
			current = current.getNext();
		}
		current = node1;
		Node prev = null;
		while (current != null) {
			Node temp = current.getNext();
			current.setNext(prev);
			prev = current;
			current = temp;
		}
		current = prev;
		int i =0;
		while(current != null) {
			if(current.getVal() != forward.get(i)) {
				System.out.println(false);
				return;
			}
			current = current.getNext();
			i++;
		}
		System.out.println(true);
	}
}
