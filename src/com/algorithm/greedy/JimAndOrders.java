package com.algorithm.greedy;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JimAndOrders {

	private static class Order implements Comparable<Order> {
		private final Integer customerNumber;
		private final Integer prepareTime;
		private final Integer delivery;
		private final Integer linePos;

		public Order(Integer cusNo, Integer prepTime, Integer linePos) {
			this.customerNumber = cusNo;
			this.prepareTime = prepTime;
			this.linePos = linePos;
			this.delivery = this.customerNumber + this.prepareTime;
		}

		public Integer getLinePos() {
			return linePos;
		}

		@Override
		public int compareTo(Order o) {
			return this.delivery < o.delivery ? -1 
					: this.delivery > o.delivery ? 1 
							: 0;
		}
	}

	public static void main(String[] args) {
		int[][] orders = { { 1, 3 }, { 2, 3 }, { 3, 3 } };

		System.out.println(IntStream.range(0, orders.length).mapToObj(i -> new Order(orders[i][0], orders[i][1], i)).sorted()
				.mapToInt(order -> order.getLinePos()+1).toArray());
	}

}
