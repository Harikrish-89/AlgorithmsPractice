package com.oracle.questions;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, Integer> {

	private static final long serialVersionUID = 1L;
	
	private int capacity;

	public LRUCache(int capacity) {
		super(capacity, 0.75f, true);
		this.capacity = capacity;
	}

	public Integer put(Integer key, Integer value) {
		return super.put(key, value);
	}

	public Integer get(Integer key) {
		return super.getOrDefault(key, -1);
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
		return size() > capacity;
	}
}
