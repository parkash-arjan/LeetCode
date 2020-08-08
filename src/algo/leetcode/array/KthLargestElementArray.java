package algo.leetcode.array;

import java.util.PriorityQueue;

public class KthLargestElementArray {
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < nums.length; i++) {
			if (minHeap.size() == k) {
				if (nums[i] < minHeap.peek())
					continue;
				minHeap.remove();
			}
			minHeap.add(nums[i]);
		}

		return minHeap.peek();
	}
}
