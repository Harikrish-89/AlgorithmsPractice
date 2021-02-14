package com.algorithm.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Graph<T> {

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

	public void removeVertex(T element) {
		getAdjs().remove(element);
		getAdjs().values().stream().forEach(e -> e.remove(element));
	}

	public void removeEdge(T vertex1, T vertex2) {
		Optional.of(getAdjs().get(vertex1)).ifPresent(edges -> edges.remove(vertex2));
		Optional.of(getAdjs().get(vertex2)).ifPresent(edges -> edges.remove(vertex1));
	}
	
	List<T> getAdjVertices(T t) {
	    return getAdjs().get(t);
	}

	@Override
	public String toString() {
		return "Graph [adjs=" + getAdjs() + "]";
	}

	public Map<T, List<T>> getAdjs() {
		return adjs;
	}
}
