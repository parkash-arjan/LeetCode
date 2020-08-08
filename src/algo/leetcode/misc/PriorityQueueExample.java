package algo.leetcode.misc;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueExample {

	public static void main(String[] args) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

		queue.add(1);
		queue.add(3);
		queue.add(2);
		queue.add(5);
		queue.add(5);
		queue.add(5);

		while (!queue.isEmpty()) {
			System.out.println(queue.poll());

		}

	}

}
