package com.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
	
	 class Node{
		 Integer value;
		 Integer min;
	 }
	 private Deque<Node> stack;
	    
	    public MinStack() {
	        stack = new ArrayDeque<Node>();
	    }
	    
	    public void push(int x) {
	    	Node node = new Node();
	    	node.value = x;
	    	node.min = stack.isEmpty() ? x : Math.min(getMin(), x);
	        stack.push(node);
	    }
	    
	    public void pop() {
	        stack.pop();
	    }
	    
	    public int top() {
	        return stack.peek().value;
	    }
	    
	    public int getMin() {
	        return stack.peek().min;
	    }
	    
	public static void main(String[] args) {

	}
}
