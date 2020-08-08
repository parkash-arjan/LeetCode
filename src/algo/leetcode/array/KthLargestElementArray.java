package algo.leetcode.array;

import java.util.PriorityQueue;

public class KthLargestElementArray {

	public static void main(String[] args) {
 
		System.out.println(findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
	}

	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < nums.length; i++) {
			minHeap.add(nums[i]);

			if (minHeap.size() > k) {
				minHeap.poll();
			}

		}

		return minHeap.peek();
	}
	
	
//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer>  minHeap = new PriorityQueue<>();
//
//        for(int i= 0;i<nums.length;i++){
//  	      	if(minHeap.size()== k) {
//  	      			if (nums[i]<minHeap.peek())
//  	      				continue;
//  	      			minHeap.remove();
//  	      	}
//  	      	minHeap.add(nums[i]);      	
//        }
//
//        return minHeap.peek();        
//      }
}
