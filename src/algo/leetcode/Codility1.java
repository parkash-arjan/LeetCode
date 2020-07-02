package algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Codility1 {
	public static void main(String[] args) {

	}

	public int solution(int[] A) {

		if (A.length < 3)
			return -1;

		List<Integer> intervals = new ArrayList<>();

		int runningDiff = A[0] - A[1];
		int intervalCount = 1;
		for (int i = 2; i < A.length; i++) {

			int currDiff = A[i - 1] - A[i];

			if (runningDiff == currDiff) {
				intervalCount++;

			} else {
				if (intervalCount >= 2) {
					intervals.add(intervalCount);
				}

				runningDiff = currDiff;

				intervalCount = 1;
			}
		}
		int resultCount = 0;
		for (Integer interval : intervals) {
			if (interval <= 3) {
				resultCount = resultCount + 1;
			} else {
				resultCount = interval - 1;
			}
		}
		return resultCount;
	}
}
