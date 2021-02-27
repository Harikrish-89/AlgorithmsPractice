package com.algorithm.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class WeightedGraph<T> {

	private final Map<T, List<Edge<T>>> adjs;

	public WeightedGraph() {
		adjs = new HashMap<T, List<Edge<T>>>();
	}

	public void addVertex(T t) {
		adjs.putIfAbsent(t, new ArrayList<Edge<T>>());
	}

	public void addEdge(T source, T destination, int weight) {
		if (!adjs.containsKey(source)) {
			addVertex(source);
		}
		if (!adjs.containsKey(destination)) {
			addVertex(destination);
		}
		adjs.get(source).add(new Edge<T>(source, destination, weight));
	}

	public void removeVertex(T element) {
		adjs.remove(element);
		adjs.values().stream().forEach(e -> e.remove(element));
	}

	public void removeEdge(T vertex1, T vertex2) {
		Optional.of(adjs.get(vertex1)).ifPresent(edges -> edges.remove(vertex2));
		Optional.of(adjs.get(vertex2)).ifPresent(edges -> edges.remove(vertex1));
	}

	List<Edge<T>> getAdjVertices(T t) {
		return adjs.get(t);
	}

	List<Edge<T>> getAllEdges() {
		return adjs.keySet().stream().flatMap(key -> adjs.get(key).stream()).collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return "Graph [adjs=" + adjs + "]";
	}

	public Map<T, List<Edge<T>>> getAdjs() {
		return adjs;
	}

	public Map<T, Double> bellManFord(T source) {
		final Map<T, Double> distances = new HashMap<T, Double>(this.getAdjs().keySet().size());
		if (!this.getAdjs().containsKey(source)) {
			System.out.println("source not found");
			return null;
		}
		this.getAdjs().keySet().stream().forEach(key -> distances.put(key, Double.POSITIVE_INFINITY));
		distances.put(source, (double) 0);
		this.getAdjs().keySet().stream().forEach(key -> {
			this.getAllEdges().stream().forEach(edge -> {
				// relax the edge
				if (distances.get(edge.getFrom()) + edge.getCost() < distances.get(edge.getTo())) {
					distances.put(edge.getTo(), distances.get(edge.getFrom()) + edge.getCost());
				}
			});
		});
		// Find negative cycle
		this.getAdjs().keySet().stream().forEach(key -> {
			this.getAllEdges().stream().forEach(edge -> {
				// relax the edge
				if (distances.get(edge.getFrom()) + edge.getCost() < distances.get(edge.getTo())) {
					distances.put(edge.getTo(), Double.NEGATIVE_INFINITY);
				}
			});
		});
		return distances;
	}

}
