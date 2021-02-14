package com.algorithm.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.IntStream;

public class HackerRankSolution {
	//My Graph class
	private static class Graph<T> {
		private final Map<T, List<T>> adjs;

		public Graph() {
			adjs = new HashMap<T, List<T>>();
		}

		public void addVertex(T t) {
			getAdjs().putIfAbsent(t, new ArrayList<T>());
		}

		public void addEdge(T source, T destination, boolean isBidir) {
			if (!getAdjs().containsKey(source)) {
				addVertex(source);
			}
			if (!getAdjs().containsKey(destination)) {
				addVertex(destination);
			}
			getAdjs().get(source).add(destination);
			if (isBidir) {
				getAdjs().get(destination).add(source);
			}
		}

		@Override
		public String toString() {
			return "Graph [adjs=" + getAdjs() + "]";
		}

		public Map<T, List<T>> getAdjs() {
			return adjs;
		}

		List<T> getAdjVertices(T t) {
			return getAdjs().get(t);
		}
	}

	//Find shortest path with BFS
	public static <T> void shortestPath(Graph<T> g, T source, T dest, Map<T, Integer> dist, Map<T, T> pred) {
		Set<T> visited = new LinkedHashSet<T>();
		Queue<T> queue = new LinkedList<T>();
		dist.put(source, 0);
		queue.add(source);
		while (!queue.isEmpty()) {
			T vert = queue.poll();
			visited.add(vert);
			for (T adjVert : g.getAdjVertices(vert)) {
				if (!visited.contains(adjVert)) {
					visited.add(adjVert);
					dist.put(adjVert, dist.get(vert) + 1);
					pred.put(adjVert, vert);
					queue.add(adjVert);
					if (adjVert.equals(dest)) {
						return;
					}
				}
			}
		}
	}

	// Complete the quickestWayUp function below.
	/**
	 * @param ladders
	 * @param snakes
	 * @return
	 */
	static int quickestWayUp(int[][] ladders, int[][] snakes) {
		Map<Integer, Integer> ladderMap = new HashMap<>();
		Map<Integer, Integer> snakeMap = new HashMap<>();
		// put the ladders in map
		for (int[] lads : ladders) {
			ladderMap.put(lads[0], lads[1]);
		}
		// put the snake in a map
		for (int[] snake : snakes) {
			snakeMap.put(snake[0], snake[1]);
		}
		/*
		 * Construct the graph 
		 * 1. every 1 - 100 cell will be a vertex
		 * 2. if cell has a ladder or snake replace that source vertices in the edge with the destination
		 * 		for example 4 has ladder to 14 replace all 4 in vertex 1-3 with 14
		 * 3. Do the same for snake above.
		 * 4. Remove the adj vertices leading to the ladder or snake for example the adj vertices for 4 will be empty
		 * 	  since you can't go to vertex 4 anymore in the game you will directly go to 14 from 4
		 */
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
		/*
		 * Doing point 4 above.
		 */
		ladderMap.forEach((from, to) -> {
			snakeAndLadder.getAdjs().get(from).clear();
		});
		snakeMap.forEach((from, to) -> {
			snakeAndLadder.getAdjs().get(from).clear();
		});
		// do the BFS
		Map<Integer, Integer> dist = new HashMap<Integer, Integer>();
		Map<Integer, Integer> pred = new HashMap<Integer, Integer>();
		Integer source = 1;
		Integer dest = 100;
		shortestPath(snakeAndLadder, source, dest, dist, pred);
		return dist.get(dest) != null ? dist.get(dest) : -1;
	}
	
	public static void main(String[] args) {
		
		// Sample test case.
		int[][] ladders = new int[][] {
			{32, 62},
			{42, 68},
			{12, 98}
		};
		int[][] snakes = new int[][] {
			{95, 13},
			{97, 25},
			{93, 37},
			{79, 27},
			{75, 19},
			{49, 47},
			{67, 17}
		};
		
		System.out.println(quickestWayUp(ladders, snakes));
	}
}
