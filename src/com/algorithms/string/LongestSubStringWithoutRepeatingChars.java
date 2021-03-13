package com.algorithms.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStringWithoutRepeatingChars {
	public static void main(String[] args) {
		String s = "abba";
		Set<Character> set = new HashSet<Character>();
		int l = 0, r = 0, n = s.length(), ans=0;
		while (l < n && r < n) {
			if(!set.contains(s.charAt(r))) {
				set.add(s.charAt(r));
				r++;
				ans = Math.max(ans, r-l);
			}else {
				set.remove(s.charAt(l));
				l++;
			}
		}
		System.out.println(ans);
		System.out.println(optimisedSlidingWindow(s));
	}
	
	public static int optimisedSlidingWindow(String s) {
		//abba
		int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            map.put(s.charAt(j), j + 1);
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
	}
}
