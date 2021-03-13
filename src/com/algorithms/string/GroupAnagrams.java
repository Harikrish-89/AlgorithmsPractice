package com.algorithms.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {
	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		if (strs.length == 0) {
			System.out.println(new ArrayList());
			return;
		}
		Map<String, List> ans = new HashMap<String, List>();
		for (String s : strs) {
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String key = String.valueOf(ca);
			if (!ans.containsKey(key))
				ans.put(key, new ArrayList());
			ans.get(key).add(s);
		}
		System.out.println(new ArrayList(ans.values()));
	}

	public static List<List<String>> groupAnagramsNotOptimisedButAccepted(String[] strs) {
		Map<String, List<Integer>> sortedStringIndexMap = new HashMap<String, List<Integer>>();
		for (int i = 0; i < strs.length; i++) {
			String s = sortString(strs[i]);
			if (sortedStringIndexMap.containsKey(s)) {
				sortedStringIndexMap.get(s).add(i);
			} else {
				List<Integer> li = new ArrayList<Integer>();
				li.add(i);
				sortedStringIndexMap.put(s, li);
			}
		}
		List<List<String>> result = new ArrayList<List<String>>();
		for (int i = 0; i < strs.length; i++) {
			String s = sortString(strs[i]);
			if (sortedStringIndexMap.containsKey(s)) {
				result.add(sortedStringIndexMap.get(s).stream().map(k -> strs[k]).collect(Collectors.toList()));
				sortedStringIndexMap.remove(s);
			}
		}
		return result;
	}

	private static String sortString(String str) {
		StringBuilder builder = new StringBuilder();
		str.chars().map(i -> ((char) i)).sorted().forEach(ch -> builder.append(ch));
		return builder.toString();
	}

	public static void unOptimisedNotAccepted(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		for (int i = 0; i < strs.length; i++) {
			if (strs[i] != null) {
				List<String> indexRes = new ArrayList<String>();
				indexRes.add(strs[i]);
				for (int j = i + 1; j < strs.length; j++) {
					if (strs[j] != null && isAnagram(strs[i], strs[j])) {
						indexRes.add(strs[j]);
						strs[j] = null;
					}
				}
				result.add(indexRes);
			}
		}
		System.out.println(result);
	}

	private static boolean isAnagram(String str1, String str2) {
		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		return Arrays.equals(c1, c2);
	}
}
