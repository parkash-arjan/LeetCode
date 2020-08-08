package algo.leetcode.array;

import java.util.PriorityQueue;

public class KthLargestElementArraInStream {
	private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	private int k = 0;

	public KthLargestElementArraInStream(int k, int[] nums) {
		this.k = k;
		for (int i = 0; i < nums.length; i++)
			add(nums[i]);
	}

	public int add(int val) {

		if (minHeap.size() == k) {
			if (val < minHeap.peek())
				return minHeap.peek();
			minHeap.poll();
		}

		minHeap.add(val);

		return minHeap.peek();
	}
}
