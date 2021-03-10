package com.oracle.questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TimeMap {
	Map<String, TreeMap<Integer, String>> M;

	public TimeMap() {
		M = new HashMap();
	}

	public void set(String key, String value, int timestamp) {
		if (!M.containsKey(key))
			M.put(key, new TreeMap());

		M.get(key).put(timestamp, value);
	}

	public String get(String key, int timestamp) {
		if (!M.containsKey(key))
			return "";

		TreeMap<Integer, String> tree = M.get(key);
		Integer t = tree.floorKey(timestamp);
		return t != null ? tree.get(t) : "";
	}

	public static void main() {
		TimeMap map = new TimeMap();
		map.set("foo", "bar", 1);
		System.out.println(map.get("foo", 1));

	}
}
