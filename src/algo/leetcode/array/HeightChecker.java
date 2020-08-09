package algo.leetcode.array;

import java.util.Arrays;

public class HeightChecker {
	public int heightChecker(int[] heights) {
		int[] temp = new int[101];

		for (int height : heights) {
			temp[height]++;
		}

		int idx = 0;
		int count = 0;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != 0) {
				int j = temp[i];
				for (int k = 0; k < j; k++) {
					if (heights[idx] != i) {
						count++;
					}
					idx++;
				}
			}
		}

		return count;
	}
//	public int heightChecker(int[] heights) {
//		int[] temp = Arrays.copyOfRange(heights, 0, heights.length);
//		Arrays.sort(heights);
//
//		int count = 0;
//		for (int i = 0; i < heights.length; i++) {
//			if (heights[i] != temp[i])
//				count++;
//		}
//
//		return count;
//	}
}
