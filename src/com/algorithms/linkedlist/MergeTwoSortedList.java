package com.algorithms.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeTwoSortedList {
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
		
		Node node11 = new Node(1);
		Node node12 = new Node(2);
		node11.setNext(node12);
		Node node13 = new Node(3);
		node12.setNext(node13);
		Node node14 = new Node(4);
		node13.setNext(node14);
		Node node15 = new Node(5);
		node14.setNext(node15);
		Node node16 = new Node(6);
		node15.setNext(node16);
		merge(node1, node11);
		
		
	}

	private static void merge(Node node1, Node node2) {
		List<Integer> finalList = new ArrayList<Integer>();
		Node current =  node1;
		while(current != null) {
			finalList.add(current.getVal());
			current = current.getNext();
		}
		current = node2;
		while(current != null) {
			finalList.add(current.getVal());
			current = current.getNext();
		}
		Collections.sort(finalList);
		System.out.println(finalList);
		Node merged = new Node(finalList.get(0));
		current = merged;
		for(int i=1; i< finalList.size(); i++) {
			current.setNext(new Node(finalList.get(i)));
			current = current.getNext();
		}
		System.out.println(merged);
	}
}
