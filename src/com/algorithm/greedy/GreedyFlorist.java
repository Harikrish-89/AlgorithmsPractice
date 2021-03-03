package com.algorithm.greedy;

import java.util.Arrays;
import java.util.stream.Collectors;

public class GreedyFlorist {
	public static void main(String[] args) {
		int k = 3;
		int[] c = { 390225, 426456, 688267, 800389, 990107, 439248, 240638, 15991, 874479, 568754, 729927, 980985,
				132244, 488186, 5037, 721765, 251885, 28458, 23710, 281490, 30935, 897665, 768945, 337228, 533277,
				959855, 927447, 941485, 24242, 684459, 312855, 716170, 512600, 608266, 779912, 950103, 211756, 665028,
				642996, 262173, 789020, 932421, 390745, 433434, 350262, 463568, 668809, 305781, 815771, 550800 };
		int n = c.length;
		Arrays.sort(c);
		System.out.println(Arrays.stream(c).boxed().collect(Collectors.toList()));
		int sum = 0;
		for (int i = n - 1; i > n - k - 1; i--) {
			sum += c[i];
		}
		int flowerPurchased = 1;
		int j=1;
		for (int i = n - k - 1; i >= 0; i--) {
			sum += (flowerPurchased + 1) * c[i];
			if (j % k == 0) {
				flowerPurchased++;
				j=0;
			}
			j++;
		}
		System.out.println(sum);	
	}
}
