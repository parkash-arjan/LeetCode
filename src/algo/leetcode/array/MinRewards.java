package algo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class MinRewards {

	public static void main(String[] args) {
		// minRewards(new int[] { 8, 4, 2, 1, 3, 6, 7, 9, 5 });
		// minRewards(new int[] { 1, 2, 3 });
		minRewards(new int[] { 3, 2, 1 });
	}

	public static int minRewards(int[] scores) {
		List<Integer> localMinimas = new ArrayList<>();
		int[] rewards = new int[scores.length];

		for (int i = 0; i < scores.length; i++) {
			if (isLocalMinima(scores, i)) {
				localMinimas.add(i);
				rewards[i] = 1;
			}
		}

		for (int i = 0; i < rewards.length; i++) {
			System.out.print(rewards[i] + "   ");
		}
		System.out.println();

		localMinimas.forEach(index -> {
			expandRight(scores, rewards, index);
			expandLeft(scores, rewards, index);
		});

		for (int i = 0; i < rewards.length; i++) {
			System.out.print(rewards[i] + "   ");
		}
		System.out.println();

		return -1;
	}

	public static void expandRight(int[] scores, int[] rewards, int i) {

		if (i == scores.length - 1) {
			return;
		}

		for (int j = i + 1; j < scores.length; j++) {
			if (scores[j] > scores[j - 1]) {
				rewards[j] = rewards[j - 1] + 1;
			} else {
				break;
			}
		}

	}

	public static void expandLeft(int[] scores, int[] rewards, int i) {
		if (i <= 0) {
			return;
		}

		for (int j = i - 1; j >= 0; j--) {
			if (scores[j] > scores[j + 1]) {
				if (rewards[j] < (rewards[j + 1] + 1)) {
					rewards[j] = rewards[j + 1] + 1;
				} else {
					break;
				}
			} else {
				break;
			}
		}
	}

	private static boolean isLocalMinima(int[] scores, int index) {
		if (getValue(scores, index) < getValue(scores, index + 1)
				&& getValue(scores, index) < getValue(scores, index - 1)) {
			return true;
		}
		return false;
	}

	private static int getValue(int[] scores, int index) {

		if (index < 0 || index >= scores.length) {
			return Integer.MAX_VALUE;
		}

		return scores[index];

	}

}