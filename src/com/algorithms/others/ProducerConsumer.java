package com.algorithms.others;

import java.util.ArrayDeque;
import java.util.Deque;

public class ProducerConsumer {
	public static void main(String[] args) throws InterruptedException {
		PC pc = new PC();
		Thread t1 = new Thread(() -> {
			try {
				System.out.println("Running t1");
				pc.produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		Thread t2 = new Thread(() -> {
			try {
				System.out.println("Running t2");
				pc.consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}

	private static class PC {

		private Deque<Integer> queue = new ArrayDeque<>();

		private int capacity = 2;

		public void produce() throws InterruptedException {
			int value = 0;
			synchronized (this) {
				while (true) {
					if (queue.size() == capacity)
						wait();
					System.out.println("Value produced:" + value);
					queue.add(value++);
					notify();
					Thread.sleep(1000);
				}
			}
		}

		public void consume() throws InterruptedException {
			synchronized (this) {
				while (true) {
					if (queue.isEmpty())
						wait();
					Integer value = queue.removeLast();
					System.out.println("Value consumed:" + value);
					notify();
					Thread.sleep(1000);
				}
			}
		}

	}
}
