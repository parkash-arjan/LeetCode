package algo.leetcode;

public class MaximumSubArray {

	public static void main(String[] args) {
		// System.out.println(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
		System.out.println(maxSubArray(new int[] { 1, -3, 2, -5, 7, 6, -1, -4, 11, -23 }));
	}

	public static int maxSubArray(int[] nums) {

		int maxSum = nums[0];
		int result = maxSum;
		for (int i = 1; i < nums.length; i++) {
			maxSum = Math.max(nums[i], nums[i] + maxSum);
			result = Math.max(result, maxSum);
			 
		}
	 
		return result;
	}

}
