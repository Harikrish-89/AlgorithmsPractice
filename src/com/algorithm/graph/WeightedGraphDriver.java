package com.algorithm.graph;

public class WeightedGraphDriver {

	public static void main(String[] args) {
		
			    WeightedGraph<Character> graph = new WeightedGraph<Character>();
			    
			    graph.addEdge('a', 'b', 1);
			    graph.addEdge('b', 'c', 1);
			    graph.addEdge( 'c', 'e', 1);
			    graph.addEdge('e', 'd', -3);
			    graph.addEdge('d', 'c', 1);
			    graph.addEdge('b', 'f', 4);
			    graph.addEdge('b', 'g', 4);
			    graph.addEdge('f', 'g', 5);
			    graph.addEdge('g', 'h', 4);
			    graph.addEdge('f', 'h', 3);
			    System.out.println(graph);
			    System.out.println(graph.bellManFord('a'));
	}
}
