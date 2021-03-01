package com.algorithm.greedy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GridChallenge {
	public static void main(String[] args) {
		String[] grid = { "hcd", "awc", "shm" };

		List<Integer> sums = Arrays.stream(grid).map(string -> string.chars().sum()).collect(Collectors.toList());
		System.out.println(sums);
		System.out.println(IntStream.range(0, sums.size() - 1).mapToObj(i -> sums.get(i + 1) >= sums.get(i)).filter(bool -> !bool).findAny()
				.orElse(true));
		
		  int n=grid.length;
	        for(int i=0;i<n;i++)
	        {
	            char []c=grid[i].toCharArray();
	            Arrays.sort(c);
	            grid[i]=new String(c);
	        }
	        for(int i=1;i<n;i++)
	        {
	            for(int j=0;j<grid[i].length();j++)
	            {
	                if(grid[i-1].charAt(j)>grid[i].charAt(j))
	                    System.out.println("NO");
	            }
	        }
	        System.out.println("YES");
	}
}
