package com.algorithms.linkedlist;

public class AddTwoNumbers {

	/**
	 * Definition for singly-linked list.
	 */
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode();
		node1.val = 2;
		ListNode node2 = new ListNode();
		node2.val = 4;
		node1.next = node2;
		ListNode node3 = new ListNode();
		node3.val = 3;
		node2.next = node3;
		
		ListNode node11 = new ListNode();
		node11.val = 5;
		ListNode node12 = new ListNode();
		node12.val = 6;
		node11.next = node12;
		ListNode node13 = new ListNode();
		node13.val = 4;
		node12.next = node13;
		addTwoNumbers(node1, node11);
	}

	public static ListNode addTwoNumbers(ListNode node1, ListNode node2) {
		StringBuilder builder1 = new StringBuilder();
		StringBuilder builder2 = new StringBuilder();
		ListNode current = node1;
		while (current != null) {
			builder1.append(String.valueOf(current.val));
			current = current.next;
		}
		current = node2;
		while (current != null) {
			builder2.append(String.valueOf(current.val));
			current = current.next;
		}
		String finalSum = String.valueOf(Integer.valueOf(builder1.toString()) 
				+ Integer.valueOf(builder2.toString()));
		finalSum = new StringBuilder(finalSum).reverse().toString();
		int i = 0;
		ListNode result = new ListNode();
		current = result;
		while (i < finalSum.length() ) {
			current.val = Integer.parseInt(String.valueOf(finalSum.charAt(i)));
			if(i !=  finalSum.length() -1) {
				current.next = new ListNode();
			}
			current = current.next;
			i++;
		}
		return result;
	}
}
