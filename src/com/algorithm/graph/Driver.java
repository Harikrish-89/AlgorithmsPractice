package com.algorithm.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.IntStream;

public class Driver {
// Practice for Graph with Collections.
	public static void main(String[] args) {
		/*
		 * Graph<String> graph = new Graph<String>(); graph.addVertex("Bob");
		 * graph.addVertex("Alice"); graph.addVertex("Mark"); graph.addVertex("Rob");
		 * graph.addVertex("Maria"); graph.addEdge("Bob", "Alice", false);
		 * graph.addEdge("Bob", "Rob", false); graph.addEdge("Alice", "Mark", false);
		 * graph.addEdge("Rob", "Mark", false); graph.addEdge("Alice", "Maria", false);
		 * graph.addEdge("Rob", "Maria", false); System.out.println(graph);
		 */
		int[][] ladders = new int[][] { { 32, 62 }, { 42, 68 }, { 12, 98 } };
		int[][] snakes = new int[][] { { 95, 13 }, { 97, 25 }, { 93, 37 }, { 79, 27 }, { 75, 19 }, { 49, 47 },
				{ 67, 17 } };
		Map<Integer, Integer> ladderMap = new HashMap<>();
		Map<Integer, Integer> snakeMap = new HashMap<>();

		for (int[] lads : ladders) {
			ladderMap.put(lads[0], lads[1]);
		}
		for (int[] snake : snakes) {
			snakeMap.put(snake[0], snake[1]);
		}

		Graph<Integer> snakeAndLadder = new Graph<Integer>();
		IntStream.rangeClosed(1, 100).forEach(i -> {
			snakeAndLadder.addVertex(i);
			IntStream.of(1, 2, 3, 4, 5, 6).forEach(dice -> {
				if (i + dice <= 100) {
					if (ladderMap.containsKey(i + dice)) {
						snakeAndLadder.addEdge(i, ladderMap.get(i + dice), false);
					} else if (snakeMap.containsKey(i + dice)) {
						snakeAndLadder.addEdge(i, snakeMap.get(i + dice), false);
					} else {
						snakeAndLadder.addEdge(i, i + dice, false);
					}
				}
			});
		});

		ladderMap.forEach((from, to) -> {
			snakeAndLadder.getAdjs().get(from).clear();
		});
		snakeMap.forEach((from, to) -> {
			snakeAndLadder.getAdjs().get(from).clear();
		});

		System.out.println(snakeAndLadder);
		depthFirst(snakeAndLadder, 1);
		Map<Integer, Integer> dist = new HashMap<Integer, Integer>();
		Map<Integer, Integer> pred = new HashMap<Integer, Integer>();
		Integer source = 1;
		Integer dest = 100;
		// bfsOrShortestPath(graph, source, dest, dist, pred);
		bfsOrShortestPath(snakeAndLadder, source, dest, dist, pred);
		System.out.println("Distance:" + dist);
		System.out.println("short path =>" + dist.get(dest));
		Integer crawl = dest;
		ArrayList<Integer> path = new ArrayList<Integer>();
		path.add(dest);
		while (!pred.get(crawl).equals(source)) {
			path.add(pred.get(crawl));
			crawl = pred.get(crawl);
		}
		path.add(source);
		StringBuilder pathString = new StringBuilder();
		for (int i = path.size() - 1; i >= 0; i--) {
			String append = (i == 0) ? "" : "=>";
			pathString.append(path.get(i) + append);

		}
		System.out.println("PathString:" + pathString.toString());
	}

	public static <T> void depthFirst(Graph<T> g, T vertex) {
		Set<T> visited = new LinkedHashSet<T>();
		Stack<T> stack = new Stack<T>();
		stack.push(vertex);
		while (!stack.isEmpty()) {
			T vert = stack.pop();
			if (!visited.contains(vert)) {
				visited.add(vert);
				g.getAdjVertices(vert).stream().forEach(adjVerts -> {
					stack.push(adjVerts);
				});
			}
		}
		System.out.println("DFS=>" + visited);
	}

	public static <T> void bfsOrShortestPath(Graph<T> g, T source, T dest, Map<T, Integer> dist, Map<T, T> pred) {
		Set<T> visited = new LinkedHashSet<T>();
		Queue<T> queue = new LinkedList<T>();
		dist.put(source, 0);
		queue.add(source);
		visited.add(source);
		while (!queue.isEmpty()) {
			T vert = queue.poll();
			g.getAdjVertices(vert).stream().forEach(adjVert -> {
				if (!visited.contains(adjVert)) {
					visited.add(adjVert);
					queue.add(adjVert);
					dist.put(adjVert, dist.get(vert) + 1);
					pred.put(adjVert, vert);
				}
			});
		}
		System.out.println("BFS=>" + visited);
	}
}
