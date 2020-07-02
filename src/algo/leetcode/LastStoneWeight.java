package algo.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class LastStoneWeight {

	public static void main(String[] args) {
		// new LastStoneWeight().lastStoneWeight(new int[] { 2, 7, 4, 1, 8, 1 });
		new LastStoneWeight().lastStoneWeight(new int[] { 2, 2 });
	}

	// [ 2,7,4,1,8,1]
	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

		// int[] copyOf = Arrays.copyOf(stones , stones.length);
//		List<Integer> asList = Arrays.asList(stones);
//		Collections.addAll(queue, asList);
		for (Integer integer : stones) {
			queue.add(integer);
		}
		// queue.addAll(IntStream.of(stones).boxed().collect(Collectors.toCollection(ArrayList::new)));

		while (!queue.isEmpty() && queue.size() > 1) {
			Integer x = queue.poll();
			Integer y = queue.poll();
			queue.add(x - y);

		}
		return queue.peek();
	}
}
