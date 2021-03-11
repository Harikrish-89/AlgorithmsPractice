package com.algorithms.string;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParanthesis {
	
	
	public static void main(String[] args) {
		String parens = "32423(sgsdg)";
		Deque<Character> stack = new ArrayDeque<Character>();
		parens.chars().mapToObj(c -> (char)c).filter(c -> c == '(' || c==')').forEach(c -> {
			if(!stack.isEmpty() &&  c.equals(')') && stack.peek().equals('(')) {
				stack.pop();
			}else {
				stack.push(c);
			}
		});
		System.out.println(stack.isEmpty());
	}
}
