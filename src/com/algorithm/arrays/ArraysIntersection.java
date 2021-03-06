package com.algorithm.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysIntersection {

	public static void main(String[] args) {
		int[] nums1 = {1,2};
		int[] nums2 = {1,1};
		if(nums1.length == nums2.length) {
		 findIntersection(nums1, nums2);
		}
		findIntersection(nums1.length < nums2.length ? nums1 : nums2,
				nums1.length > nums2.length ? nums1 : nums2);
	}

	private static int[] findIntersection(int[] smaller, int[] bigger) {
		List<Integer> list = Arrays.stream(bigger).boxed().collect(Collectors.toList());
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < smaller.length; i++) {
			if (list.contains(smaller[i])) {
				result.add(smaller[i]);
				list.remove(Integer.valueOf(smaller[i]));
			}
		}
		System.out.println(result);
		return result.stream().mapToInt(i -> i).toArray();
	}
	
	 public int[] intersect(int[] nums1, int[] nums2) {
		    if (nums1.length > nums2.length) {
		        return intersect(nums2, nums1);
		    }
		    HashMap<Integer, Integer> m = new HashMap<>();
		    for (int n : nums1) {
		        m.put(n, m.getOrDefault(n, 0) + 1);
		    }
		    int k = 0;
		    for (int n : nums2) {
		        int cnt = m.getOrDefault(n, 0);
		        if (cnt > 0) {
		            nums1[k++] = n;
		            m.put(n, cnt - 1);
		        }
		    }
	 	    return Arrays.copyOfRange(nums1, 0, k);
	 }
}
