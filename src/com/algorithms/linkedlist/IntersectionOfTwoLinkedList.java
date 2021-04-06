package com.algorithms.linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IntersectionOfTwoLinkedList {
	public static void main(String[] args) {

	}
	
	public static ListNode getIntersection(ListNode headA, ListNode headB) {
		Set<ListNode> set = new HashSet<ListNode>();
		ListNode current = headA;
		while(current != null) {
			set.add(current);
			current = current.next;
		}
		current = headB;
		while(current != null) {
			if(set.contains(current)) {
				return current;
			}
			current = current.next; 
		}
		return null;
	}
	
	class ListNode {
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
}
