package algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class MergeIntervals {

	public static void main(String[] args) {
		// Input: [[1,3],[2,6],[8,10],[15,18]]

		int[][] intervals = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		// int[][] intervals = new int[][] { { 1, 4 }, { 4, 5 } };
		// merge(intervals);
		// Stream.of(merge(intervals)).map(Arrays::toString).forEach(System.out::println);

		Stream.of(merge(intervals)).map(Arrays::toString).forEach(System.out::println);
	}

	public static int[][] merge(int[][] intervals) {
		PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> Integer.compare(x[0], y[0]));

		for (int i = 0; i < intervals.length; i++) {
			queue.add(intervals[i]);
		}

		List<int[]> result = new ArrayList<>();

		while (!queue.isEmpty() && queue.size() > 1) {
			int[] i1 = queue.poll();
			int[] i2 = queue.poll();
			int[] mergedIntervals = merge(i1, i2);

			if (mergedIntervals == null) {
				result.add(i1);
				queue.add(i2);
				// result.add(mergedIntervals);
			} else {
				queue.add(mergedIntervals);
			}
		}

		if (!queue.isEmpty()) {
			result.add(queue.poll());
		}

		int[][] resultArray = new int[result.size()][2];
		int i = 0;
		for (int[] is : result) {
			resultArray[i++] = is;
		}

		return resultArray;
	}

	public static int[] merge(int[] a, int[] b) {

		if (b[0] <= a[1]) {
			return new int[] { Math.min(a[0], b[0]), Math.max(a[1], b[1]) };
		}
		return null;
	}
}
