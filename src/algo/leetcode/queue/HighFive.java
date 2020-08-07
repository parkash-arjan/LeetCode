package algo.leetcode.queue;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

public class HighFive {

	public static void main(String[] args) {
		int[][] highFive = highFive(new int[][] { { 1, 91 }, { 1, 92 }, { 2, 93 }, { 2, 97 }, { 1, 60 }, { 2, 77 },
				{ 1, 65 }, { 1, 87 }, { 1, 100 }, { 2, 100 }, { 2, 76 } });

		for (int i = 0; i < highFive.length; i++) {
			System.out.println(highFive[i][0] + "  " + highFive[i][1]);

		}

	}

	public static int[][] highFive(int[][] items) {

		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

		for (int i = 0; i < items.length; i++) {
			PriorityQueue<Integer> queue = map.getOrDefault(items[i][0],
					new PriorityQueue<>(Collections.reverseOrder()));

			queue.add(items[i][1]);
			map.put(items[i][0], queue);

		}

		int[][] result = new int[map.size()][2];

		Set<Entry<Integer, PriorityQueue<Integer>>> entrySet = map.entrySet();

		int row = 0;

		for (Entry<Integer, PriorityQueue<Integer>> entry : entrySet) {
			Integer studentId = entry.getKey();

			PriorityQueue<Integer> queueMarks = entry.getValue();
			int count = 1;
			int total = 0;
			while (!queueMarks.isEmpty() && count++ <= 5) {
				Integer marks = queueMarks.poll();
				total = total + marks;
			}

			total = total / 5;
			result[row][0] = studentId;
			result[row][1] = total;
			row++;
		}

		return result;

	}
}
